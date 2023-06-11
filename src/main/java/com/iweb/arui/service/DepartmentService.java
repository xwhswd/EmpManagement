package com.iweb.arui.service;

import com.iweb.arui.pojo.Department;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean deleteDepartment(Department department);
    boolean updateDepartment(Department department);
    List<Department> getAllDepartment();
    List<Department> getDepartmentByKey(Department department);
}
