package com.iweb.arui.service;

import com.iweb.arui.pojo.Employee;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface EmployeeService {
    /**
     * 添加员工接口
     * @param employee 员工信息
     * @return 校验结果
     */
    boolean addEmployee(Employee employee);

    /**
     *删除员工接口
     * @param employee 根据id删除
     * @return 返回校验结果
     */
    boolean deleteEmployee(Employee employee);

    /**
     * 更新员工接口
     * @param employee 员工信息
     * @return 校验结果
     */
    boolean updateEmployee(Employee employee);

    /**
     * 查询所有员工的接口
     * @return 所有员工的集合
     */
    List<Employee> selectAllEmployee();

    /**
     * 模糊查询接口
     * @param employee 传入查询的key
     * @return 员工集合
     */
    List<Employee> selectEmployeeByKey(Employee employee);
}
