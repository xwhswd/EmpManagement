package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.EmployeeDao;
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
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean add(Employee emp) {
        String  sql="insert into employee(emp_name,identity_card,phone_number,sex,pid,dept_pid) values(?,?,?,?,?,?)";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdentityCard());
            ps.setString(3,emp.getPhoneNumber());
            ps.setString(4,emp.getSex());
            ps.setLong(5,emp.getPost().getId());
            ps.setLong(6,emp.getDepartment().getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Employee emp) {
        String  sql="delete from employee where id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,emp.getId());
            flag = ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Employee emp) {
        String  sql="update employee set emp_name=?,identity_card=?,phone_number=?,sex=?,pid=?,dept_pid=? where id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,emp.getEmpName());
            ps.setString(2,emp.getIdentityCard());
            ps.setString(3,emp.getPhoneNumber());
            ps.setString(4,emp.getSex());
            ps.setLong(5,emp.getPost().getId());
            ps.setLong(6,emp.getDepartment().getId());
            ps.setLong(7,emp.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> list = new ArrayList<>();
        String  sql="select * from employee";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getLong(1));
                employee.setEmpName(rs.getString(2));
                employee.setIdentityCard(rs.getString(3));
                employee.setPhoneNumber(rs.getString(4));
                employee.setSex(rs.getString(5));
                /**
                 * 待完善
                 */
                employee.setPost(new Post());
                employee.setDepartment(new Department());
                list.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Employee> selectFuzzy(Employee emp) {
        List<Employee> list = new ArrayList<>();
        String  sql="select * from employee where emp_name like concat('%',?,'%') and " +
                "identity_card like concat('%',?,'%') and" +
                "phone_number like concat('%',?,'%') and" +
                "sex like concat('%',?,'%') and" +
                "pid like concat('%',?,'%') and" +
                "dept_pid like concat('%',?,'%')";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee employee = new Employee();
                employee.setEmpName(rs.getString(1));
                employee.setIdentityCard(rs.getString(2));
                employee.setPhoneNumber(rs.getString(3));
                employee.setSex(rs.getString(4));
                /**
                 * 待完善
                 */
                employee.setPost(new Post());
                employee.setDepartment(new Department());
                list.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
