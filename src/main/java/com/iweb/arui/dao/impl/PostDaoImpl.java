package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.PostDao;
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

    @Override
    public boolean add(Post post) {
        String  sql="insert into post(position_name,position_msg) values(?,?)";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,post.getPositionName());
            ps.setString(2,post.getPositionMsg());
            flag = ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Post post) {
        String  sql="delete from post where post_id = ?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,post.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Post post) {
        String  sql="update post set position_name=?,position_msg=? where id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,post.getPositionName());
            ps.setString(2,post.getPositionMsg());
            ps.setLong(3,post.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Post> selectAll() {
        List<Post> list = new ArrayList<>();
        String  sql="select * from post";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Post post = new Post();
                post.setId(rs.getLong(1));
                post.setPositionName(rs.getString(2));
                post.setPositionMsg(rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Post> selectFuzzy(Post post) {
        List<Post> list = new ArrayList<>();
        String  sql="select * from post where position_name like concat('%'.?,'%') " +
                "or position_msg like concat('%'.?,'%') ";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
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
        }
        return list;
    }
}
