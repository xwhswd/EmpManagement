package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.EmployeeDao;
import com.iweb.arui.dao.PostDao;
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
public class PostDaoImpl implements PostDao {
    private static EmployeeDao employeeDao;
    static {
        employeeDao=new EmployeeDaoImpl();
    }
    @Override
    public synchronized boolean add(Post post) {
        String  sql="insert into post(position_name,position_msg) values(?,?)";
        boolean flag = false;
        Connection connection = null;
        try{
            connection=DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,post.getPositionName());
            ps.setString(2,post.getPositionMsg());
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
    public synchronized boolean delete(Post post) {
        String  sql="delete from post where id = ?";
        boolean flag = false;
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,post.getId());
            ps.execute();
            flag=ps.getUpdateCount()>=1;
            if (flag){
                List<Employee> employees = employeeDao.selectAll();
                for (Employee employee:employees) {
                    if (employee.getPost().getId()==post.getId()){
                        employee.setPost(new Post(0,"未分配","未分配"));
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
    public synchronized boolean update(Post post) {
        String  sql="update post set position_name=?,position_msg=? where id=?";
        boolean flag = false;
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,post.getPositionName());
            ps.setString(2,post.getPositionMsg());
            ps.setLong(3,post.getId());
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
    public synchronized List<Post> selectAll() {
        List<Post> list = new ArrayList<>();
        String  sql="select * from post";
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Post post = new Post();
                post.setId(rs.getLong(1));
                post.setPositionName(rs.getString(2));
                post.setPositionMsg(rs.getString(3));
                list.add(post);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized List<Post> selectFuzzy(Post post) {
        List<Post> list = new ArrayList<>();
        String  sql="select * from post where position_name like concat('%',?,'%') " +
                "or position_msg like concat('%',?,'%') ";
        Connection connection = null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,post.getPositionName());
            ps.setString(2,post.getPositionMsg());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Post p = new Post();
                post.setId(rs.getLong(1));
                post.setPositionName(rs.getString(2));
                post.setPositionMsg(rs.getString(3));
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return list;
    }

    @Override
    public synchronized Post selectById(long id) {
        String  sql="select * from post where id=?";
        Connection connection=null;
        Post post=null;
        try{
            connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                post=new Post();
                post.setId(rs.getLong(1));
                post.setPositionName(rs.getString(2));
                post.setPositionMsg(rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB_Pool.returnConnection(connection);
        }
        return post;
    }
}
