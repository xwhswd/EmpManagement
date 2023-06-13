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
        if (department==null){
            return false;
        }
        return departmentDao.add(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        if (department==null){
            return false;
        }
        return departmentDao.delete(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        if (department==null){
            return false;
        }
        return departmentDao.update(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.selectAll();
    }

    @Override
    public List<Department> getDepartmentByKey(Department department) {
        if (department==null){
            return null;
        }
        return departmentDao.selectFuzzy(department);
    }
}
