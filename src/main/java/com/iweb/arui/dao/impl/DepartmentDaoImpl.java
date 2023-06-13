package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.DepartmentDao;
import com.iweb.arui.dao.EmployeeDao;
import com.iweb.arui.dao.UserDao;
import com.iweb.arui.pojo.Department;
import com.iweb.arui.pojo.Employee;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.util.DB_Pool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class DepartmentDaoImpl implements DepartmentDao {
    private static EmployeeDao employeeDao;
    static {
        employeeDao=new EmployeeDaoImpl();
    }
    @Override
    public synchronized boolean add(Department depart) {
        String  sql="insert into department(dept_name) values(?)";
        boolean flag = false;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,depart.getDeptName());
            ps.execute();
            flag=ps.getUpdateCount()>=1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return flag;
    }

    @Override
    public synchronized boolean delete(Department depart) {
        String  sql="delete from department where id= ?";
        boolean flag = false;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,depart.getId());
            ps.execute();
            flag=ps.getUpdateCount()>=1;
            if (flag){
                List<Employee> employees = employeeDao.selectAll();
                for (Employee employee:employees) {
                    if (employee.getDepartment().getId()==depart.getId()){
                        employee.setDepartment(new Department(0,"未分配"));
                        employeeDao.update(employee);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return flag;
    }

    @Override
    public synchronized boolean update(Department depart) {
        String  sql="update department set dept_name=? where id=?";
        boolean flag = false;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,depart.getDeptName());
            ps.setLong(2,depart.getId());
            ps.execute();
            flag=ps.getUpdateCount()>=1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return flag;
    }

    @Override
    public synchronized List<Department> selectAll() {
        List<Department> list = new ArrayList<>();
        String  sql="select * from department";
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department d = new Department();
                d.setId(rs.getLong(1));
                d.setDeptName(rs.getString(2));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized List<Department> selectFuzzy(Department depart) {
        List<Department> list = new ArrayList<>();
        String  sql="select * from department where dept_name like concat('%',?,'%')";
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,depart.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department d = new Department();
                d.setId(rs.getLong(1));
                d.setDeptName(rs.getString(2));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized Department selectById(long id) {
        String  sql="select * from department where id=?";
        Connection connection=null;
        Department d=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                d = new Department();
                d.setId(rs.getLong(1));
                d.setDeptName(rs.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return d;
    }
}
