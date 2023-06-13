package com.iweb.arui.dao;

import com.iweb.arui.pojo.Report;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface ReportDao {
    /**
     * 添加公告
     * @param report 添加的公告信息
     * @return 返回操作是否成功
     */
    boolean add(Report report);

    /**
     * 删除公告
     * @param report 根据id删除公告
     * @return 返回操作是否成功
     */
    boolean delete(Report report);

    /**
     * 更新公告
     * @param report 根据id更新公告
     * @return 返回操作是否成功
     */
    boolean update(Report report);

    /**
     * 查询所有公告
     * @return 返回所有公告的集合
     */
    List<Report> selectAll();

    /**
     * 根据关键字查询公告
     * @param report 传入相关关键字
     * @return 返回查询到的公告的集合
     */
    List<Report> selectFuzzy(Report report);

    /**
     * 根据id查询公告
     * @param id 公告id
     * @return 一个公告对象
     */
    Report selectById(long id);
}
