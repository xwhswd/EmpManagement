package com.iweb.arui.view;

import com.iweb.arui.controller.AdminController;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.Report;
import com.iweb.arui.service.ReportService;
import com.iweb.arui.service.impl.ReportServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class ReportManageView {
    static ReportService reportService;
    static {
        reportService=new ReportServiceImpl();
    }
    public static void reportManageView(){
        Print.print("进入 公告管理 页面...");
        Print.print("请选择要进行的操作");
        Print.print("1.添加公告");
        Print.print("2.删除公告");
        Print.print("3.更新公告");
        Print.print("4.查询所有公告");
        Print.print("5.模糊筛选公告");
        Print.print("6.返回管理员界面");
        String choose = GetCommand.nextLine();
        AdminController.reportManInfo(choose);
    }
    public static void addReport(){
        Print.print("请输入要添加的公告名:");
        String reportName = GetCommand.nextLine();
        Print.print("请输入要添加的公告信息:");
        String reportMsg = GetCommand.nextLine();
        Report report = new Report(0,reportName, reportMsg);
        boolean b = reportService.generateReport(report);
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            ReportManageView.addReport();
        }
    }
    public static void deleteReport(){
        Print.print("请输入要添加的公告id:");
        String id = GetCommand.nextLine();
        boolean b = reportService.deleteReport(new Report(Long.parseLong(id), null, null));
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("删除失败");
            ReportManageView.deleteReport();
        }
    }
    public static void updateReport(){
        Print.print("请输入要修改的公告id:");
        String id = GetCommand.nextLine();
        Print.print("请输入要修改的公告名:");
        String reportName = GetCommand.nextLine();
        Print.print("请输入要修改的公告信息:");
        String reportMsg = GetCommand.nextLine();
        Report report = new Report(Long.parseLong(id),reportName, reportMsg);
        boolean b = reportService.updateReport(report);
        if (b){
            Print.print("修改成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            ReportManageView.updateReport();
        }
    }

    public static void searchAllReport(){
        Print.print("以下是公告信息:");
        List<Report> list = reportService.selectAllReport();
        for (Report r:list) {
            Print.print(r.toString());
        }
        Print.print("显示结束,返回主页面");
        AdminView.adminView();
    }

    public static void searchReportByKey(){
        Print.print("请输入要查询的公告名关键字:");
        String reportName = GetCommand.nextLine();
        Print.print("请输入要查询的公告信息关键字:");
        String reportMsg = GetCommand.nextLine();
        Print.print("以下是公告信息:");
        List<Report> list = reportService.selectReportByKey(new Report(0,reportName,reportMsg));
        for (Report r:list) {
            Print.print(r.toString());
        }
        Print.print("显示结束,返回主页面");
        AdminView.adminView();
    }
}
