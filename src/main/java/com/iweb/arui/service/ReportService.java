package com.iweb.arui.service;

import com.iweb.arui.pojo.Report;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface ReportService {
    boolean deleteReport(Report report);
    boolean generateReport(Report report);
    boolean selectAllReport(Report report);
    List<Report> selectReportByKey();
    List<Report> updateReport(Report report);
}
