package com.iweb.arui.service.impl;

import com.iweb.arui.dao.EmployeeDao;
import com.iweb.arui.dao.impl.EmployeeDaoImpl;
import com.iweb.arui.pojo.Employee;
import com.iweb.arui.service.EmployeeService;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeDao employeeDao;
    static {
        employeeDao=new EmployeeDaoImpl();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employee==null){
            return false;
        }
        return employeeDao.add(employee);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        if (employee==null){
            return false;
        }
        return employeeDao.delete(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        if (employee==null){
            return false;
        }
        return employeeDao.update(employee);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeDao.selectAll();
    }

    @Override
    public List<Employee> selectEmployeeByKey(Employee employee) {
        if (employee==null){
            return null;
        }
        return employeeDao.selectFuzzy(employee);
    }
}
