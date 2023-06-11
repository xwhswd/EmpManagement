package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.DepartmentDao;
import com.iweb.arui.pojo.Department;
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

    @Override
    public boolean add(Department depart) {
        String  sql="insert into department(dept_name) values(?)";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,depart.getDeptName());
            flag = ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Department depart) {
        String  sql="delete from department where id=?)";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,depart.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Department depart) {
        String  sql="update department set dept_name=? where id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,depart.getDeptName());
            ps.setLong(2,depart.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Department> selectAll() {
        List<Department> list = new ArrayList<>();
        String  sql="select * from department";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department d = new Department();
                d.setId(rs.getLong(1));
                d.setDeptName(rs.getString(2));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Department> selectFuzzy(Department depart) {
        List<Department> list = new ArrayList<>();
        String  sql="select * from department where dept_name like concat('%',?,'%')";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Department d = new Department();
                d.setId(rs.getLong(1));
                d.setDeptName(rs.getString(2));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
