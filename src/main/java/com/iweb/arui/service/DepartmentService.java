package com.iweb.arui.service;

import com.iweb.arui.pojo.Department;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface DepartmentService {
    /**
     * 添加部门接口
     * @param department 部门信息
     * @return 返回校验结果
     */
    boolean addDepartment(Department department);

    /**
     * 删除部门接口
     * @param department 根据id删除
     * @return 返回校验结果
     */
    boolean deleteDepartment(Department department);

    /**
     * 更新部门接口
     * @param department 根据id更新
     * @return 返回校验结果
     */
    boolean updateDepartment(Department department);

    /**
     * 获取所有部门接口
     * @return 返回所有部门信息
     */
    List<Department> getAllDepartment();

    /**
     * 模糊查询部门接口
     * @param department 传入模糊查询key
     * @return 返回查询到的所有部门信息
     */
    List<Department> getDepartmentByKey(Department department);
}
