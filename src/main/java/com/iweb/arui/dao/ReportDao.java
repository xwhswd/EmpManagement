package com.iweb.arui.dao;

import com.iweb.arui.pojo.Report;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface ReportDao {
    void add(Report report);
    void delete(Report report);
    void update(Report report);
    List<Report> selectAll();
    List<Report> selectFuzzy(Report report);
}
