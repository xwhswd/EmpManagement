package com.iweb.arui.service;

import com.iweb.arui.pojo.Report;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface ReportService {
    /**
     * 删除公告接口
     * @param report 根据id删除
     * @return 返回操作结果
     */
    boolean deleteReport(Report report);

    /**
     * 生成公告接口
     * @param report 生成的公告信息,生成id
     * @return 返回操作结果
     */
    boolean generateReport(Report report);

    /**
     * 查询所有公告信息接口
     * @return 返回查询到的所有公告
     */
    List<Report> selectAllReport();

    /**
     * 根据关键字查询公告接口
     * @param report 公告key
     * @return 返回查询到的所有公告
     */
    List<Report> selectReportByKey(Report report);

    /**
     * 更新公告接口
     * @param report 根据id更新的信息
     * @return 公告更改结果
     */
    boolean updateReport(Report report);

    /**
     * 获取最新的公告
     * @return 返回获取到的最新公告
     */
    Report getNewestReport();
}
