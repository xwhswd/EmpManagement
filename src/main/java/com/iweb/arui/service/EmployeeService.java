package com.iweb.arui.service;

import com.iweb.arui.pojo.Employee;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    List<Employee> selectAllEmployee();
    List<Employee> selectEmployeeByKey(Employee employee);
}
