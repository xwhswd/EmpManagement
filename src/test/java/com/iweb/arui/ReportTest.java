package com.iweb.arui;

import com.iweb.arui.pojo.Report;
import com.iweb.arui.service.ReportService;
import com.iweb.arui.service.impl.ReportServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class ReportTest {
    ReportService reportService = new ReportServiceImpl();

    @Test
    public void deleteReport(){
        System.out.println(reportService.deleteReport(new Report(2, "", "")));
    }

    @Test
    public void generateReport(){
        System.out.println(reportService.generateReport(new Report(1, "sada", "asda")));
    }
    @Test
    public void selectAllReport(){
        System.out.println(reportService.selectAllReport().toString());
    }
    @Test
    public void selectReportByKey(){
        System.out.println(reportService.selectReportByKey((new Report(1, "sa", ""))).toString());
    }
    @Test
    public void updateReport(){
        System.out.println(reportService.updateReport(new Report(3, "sadsadasa", "asda")));
    }
    @Test
    public void getNewestReport(){
        System.out.println(reportService.getNewestReport());
    }
}
