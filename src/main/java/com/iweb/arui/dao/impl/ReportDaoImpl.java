package com.iweb.arui.dao.impl;

import com.iweb.arui.dao.ReportDao;
import com.iweb.arui.pojo.Report;
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
public class ReportDaoImpl implements ReportDao {

    @Override
    public boolean add(Report report) {
        String  sql="insert into report(report_name,report_msg) values(?,?)";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,report.getReportName());
            ps.setString(2,report.getReportMsg());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(Report report) {
        String  sql="delete from report where id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setLong(1,report.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(Report report) {
        String  sql="update report set report_name=?,report_msg=? where report_id=?";
        boolean flag = false;
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,report.getReportName());
            ps.setString(2,report.getReportMsg());
            ps.setLong(3,report.getId());
            flag=ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Report> selectAll() {
        List<Report> list = new ArrayList<>();
        String  sql="select * from report";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Report report = new Report();
                report.setId(rs.getLong(1));
                report.setReportName(rs.getString(2));
                report.setReportMsg(rs.getString(3));
                list.add(report);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Report> selectFuzzy(Report report) {
        List<Report> list = new ArrayList<>();
        String  sql="select * from report where report_name like concat('%',?,'%')" +
                "and report_msg like concat('%',?,'%')";
        try(Connection connection = DB_Pool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,report.getReportName());
            ps.setString(2,report.getReportMsg());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Report rp = new Report();
                rp.setId(rs.getLong(1));
                rp.setReportName(rs.getString(2));
                rp.setReportMsg(rs.getString(3));
                list.add(rp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
