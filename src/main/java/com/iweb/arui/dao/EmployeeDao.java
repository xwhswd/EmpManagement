package com.iweb.arui.dao;

import com.iweb.arui.pojo.Employee;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface EmployeeDao {
    /**
     * 添加一个员工
     * @param emp  不传入id,添加员工信息
     * @return 返回操作是否成功
     */
    boolean add(Employee emp);

    /**
     * 删除一个员工
     * @param emp 根据id删除员工信息
     * @return 返回操作是否成功
     */
    boolean delete(Employee emp);

    /**
     * 更新员工信息
     * @param emp 根据id更新员工信息
     * @return 返回操作是否成功
     */
    boolean update(Employee emp);

    /**
     * 查询所有员工
     * @return 返回员工集合
     */
    List<Employee> selectAll();

    /**
     * 模糊查询员工信息
     * @param emp 传入查询的相关key
     * @return 返回查询到所有员工的集合
     */
    List<Employee> selectFuzzy(Employee emp);

    /**
     * 根据id查询员工
     * @param id 员工id
     * @return 返回一个员工对象
     */
    Employee selectById(long id);
}
