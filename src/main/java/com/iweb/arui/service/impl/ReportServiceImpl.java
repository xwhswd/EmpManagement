package com.iweb.arui.service.impl;

import com.iweb.arui.dao.ReportDao;
import com.iweb.arui.dao.impl.ReportDaoImpl;
import com.iweb.arui.pojo.Report;
import com.iweb.arui.service.ReportService;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class ReportServiceImpl implements ReportService {
    private static ReportDao reportDao;
    static {
        reportDao=new ReportDaoImpl();
    }

    @Override
    public boolean deleteReport(Report report) {
        return false;
    }

    @Override
    public boolean generateReport(Report report) {
        return false;
    }

    @Override
    public boolean selectAllReport(Report report) {
        return false;
    }

    @Override
    public List<Report> selectReportByKey() {
        return null;
    }

    @Override
    public List<Report> updateReport(Report report) {
        return null;
    }
}
