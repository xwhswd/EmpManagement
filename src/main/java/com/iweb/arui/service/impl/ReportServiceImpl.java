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
        if (report==null){
            return false;
        }
        return reportDao.delete(report);
    }

    @Override
    public boolean generateReport(Report report) {
        if (report==null){
            return false;
        }
        return reportDao.add(report);
    }

    @Override
    public List<Report> selectAllReport() {
        return reportDao.selectAll();
    }

    @Override
    public List<Report> selectReportByKey(Report report) {
        return reportDao.selectFuzzy(report);
    }

    @Override
    public boolean updateReport(Report report) {
        if (report==null){
            return false;
        }
        return reportDao.update(report);
    }

    @Override
    public Report getNewestReport() {
        List<Report> list = selectAllReport();
        if (list==null){
            return new Report(0,"","");
        }
        return list.get(list.size()-1);
    }

}
