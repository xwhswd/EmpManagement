package com.iweb.arui.service.impl;

import com.iweb.arui.dao.DepartmentDao;
import com.iweb.arui.dao.impl.DepartmentDaoImpl;
import com.iweb.arui.pojo.Department;
import com.iweb.arui.service.DepartmentService;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class DepartmentServiceImpl implements DepartmentService{
    private static DepartmentDao departmentDao;
    static {
        departmentDao=new DepartmentDaoImpl();
    }

    @Override
    public boolean addDepartment(Department department) {
        return false;
    }

    @Override
    public boolean deleteDepartment(Department department) {
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        return false;
    }

    @Override
    public List<Department> getAllDepartment() {
        return null;
    }

    @Override
    public List<Department> getDepartmentByKey(Department department) {
        return null;
    }
}
