package com.iweb.arui.dao;

import com.iweb.arui.pojo.Report;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface ReportDao {
    boolean add(Report report);
    boolean delete(Report report);
    boolean update(Report report);
    List<Report> selectAll();
    List<Report> selectFuzzy(Report report);
}
