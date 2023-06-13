package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.UserDao;
import com.iweb.arui.pojo.Report;
import com.iweb.arui.pojo.User;
import com.iweb.arui.util.DB_Pool;
import sun.java2d.pipe.AAShapePipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class UserDaoImpl implements UserDao {

    @Override
    public synchronized boolean add(User user) {
        String  sql="insert into user(username,password,role,status) values(?,?,?,?)";
        boolean flag=false;
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            if (user==null||selectByUsername(user.getUsername())!=null){
                return false;
            }
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,"普通用户");
            ps.setString(4,"未登录");
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
    public synchronized boolean delete(User user) {
        String  sql="delete from user where id=?";
        boolean flag = false;
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,user.getId());
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
    public synchronized boolean update(User user) {
        String  sql="update user set username=?,password=?,role=?,status=? where id=?";
        boolean flag = false;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getRole());
            ps.setString(4,user.getStatus());
            ps.setLong(5,user.getId());
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
    public synchronized List<User> selectAll() {
        List<User> list = new ArrayList<>();
        String  sql="select * from user";
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getLong(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getString(4));
                user.setStatus(rs.getString(5));
                list.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized List<User> selectFuzzy(User user) {
        List<User> list = new ArrayList<>();
        Connection connection=null;
        String  sql="select * from user where username like concat('%',?,'%') and status like concat('%',?,'%')";
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getStatus());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                User u = new User();
                u.setId(rs.getLong(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setRole(rs.getString(4));
                u.setStatus(rs.getString(5));
                list.add(u);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized User selectByUsername(String username) {
        String  sql="select * from user where username=?";
        User user = null;
        Connection connection=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return user;
    }

    @Override
    public synchronized User selectById(long id) {
        String  sql="select * from user where id=?";
        Connection connection=null;
        User user=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return user;
    }
}
