package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.DepartmentDao;
import com.iweb.arui.dao.EmployeeDao;
import com.iweb.arui.dao.PostDao;
import com.iweb.arui.pojo.Department;
import com.iweb.arui.pojo.Employee;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.util.DB_Pool;
import javafx.geometry.Pos;

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
public class EmployeeDaoImpl implements EmployeeDao {
    private static PostDao postDao;
    private static DepartmentDao departmentDao;
    static {
        postDao=new PostDaoImpl();
        departmentDao=new DepartmentDaoImpl();
    }
    @Override
    public synchronized boolean add(Employee emp) {
        String  sql="insert into employee(emp_name,identity_card,phone_number,sex,pid,dept_id) values(?,?,?,?,?,?)";
        boolean flag = false;
        Connection connection=null;
        try{
            if (postDao.selectById(emp.getPost().getId())==null||departmentDao.selectById(emp.getDepartment().getId())==null){
                return false;
            }
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdentityCard());
            ps.setString(3,emp.getPhoneNumber());
            ps.setString(4,emp.getSex());
            ps.setLong(5,emp.getPost().getId());
            ps.setLong(6,emp.getDepartment().getId());
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
    public synchronized boolean delete(Employee emp) {
        String  sql="delete from employee where id=?";
        boolean flag = false;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,emp.getId());
            ps.execute();
            flag = ps.getUpdateCount()>=1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return flag;
    }

    @Override
    public synchronized boolean update(Employee emp) {
        String  sql="update employee set emp_name=?,identity_card=?,phone_number=?,sex=?,pid=?,dept_id=? where id=?";
        boolean flag = false;
        Connection connection=null;
        try{
            if (postDao.selectById(emp.getPost().getId())==null||departmentDao.selectById(emp.getDepartment().getId())==null){
                return false;
            }
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdentityCard());
            ps.setString(3,emp.getPhoneNumber());
            ps.setString(4,emp.getSex());
            ps.setLong(5,emp.getPost().getId());
            ps.setLong(6,emp.getDepartment().getId());
            ps.setLong(7,emp.getId());
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
    public synchronized List<Employee> selectAll() {
        List<Employee> list = new ArrayList<>();
        String  sql="select * from employee";
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getLong(1));
                employee.setEmpName(rs.getString(2));
                employee.setIdentityCard(rs.getString(3));
                employee.setPhoneNumber(rs.getString(4));
                employee.setSex(rs.getString(5));
                Post p = postDao.selectById(rs.getLong(6));
                if (p==null){
                    p=new Post();
                }
                employee.setPost(p);
                Department department = departmentDao.selectById(rs.getLong(7));
                if (department==null){
                    department=new Department();
                }
                employee.setDepartment(department);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized List<Employee> selectFuzzy(Employee emp) {
        List<Employee> list = new ArrayList<>();
        String  sql="select * from employee where emp_name like concat('%',?,'%') and " +
                " identity_card like concat('%',?,'%') and" +
                " phone_number like concat('%',?,'%') and" +
                " sex like concat('%',?,'%') and" +
                " pid like concat('%',?,'%') and" +
                " dept_id like concat('%',?,'%')";
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdentityCard());
            ps.setString(3,emp.getPhoneNumber());
            ps.setString(4, emp.getSex());
            ps.setLong(5,emp.getPost().getId());
            ps.setLong(6,emp.getDepartment().getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getLong(1));
                employee.setEmpName(rs.getString(2));
                employee.setIdentityCard(rs.getString(3));
                employee.setPhoneNumber(rs.getString(4));
                employee.setSex(rs.getString(5));
                Post p = postDao.selectById(rs.getLong(6));
                if (p==null){
                    p=new Post();
                }
                employee.setPost(p);
                Department department = departmentDao.selectById(rs.getLong(7));
                if (department==null){
                    department=new Department();
                }
                employee.setDepartment(department);
                list.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized Employee selectById(long id) {
        String  sql="select * from employee where id=?";
        Connection connection=null;
        Employee employee=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee=new Employee();
                employee.setId(id);
                employee.setEmpName(rs.getString(2));
                employee.setIdentityCard(rs.getString(3));
                employee.setPhoneNumber(rs.getString(4));
                employee.setSex(rs.getString(5));
                employee.setPost(postDao.selectById(rs.getLong(6)));
                employee.setDepartment(departmentDao.selectById(rs.getLong(7)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return employee;
    }
}
