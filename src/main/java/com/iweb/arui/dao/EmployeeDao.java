package com.iweb.arui.dao;

import com.iweb.arui.pojo.Employee;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface EmployeeDao {
    boolean add(Employee emp);
    boolean delete(Employee emp);
    boolean update(Employee emp);
    List<Employee> selectAll();
    List<Employee> selectFuzzy(Employee emp);
}
