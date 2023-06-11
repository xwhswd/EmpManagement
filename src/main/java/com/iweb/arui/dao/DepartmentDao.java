package com.iweb.arui.dao;

import com.iweb.arui.pojo.Department;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface DepartmentDao {
    boolean add(Department depart);
    boolean delete(Department depart);
    boolean update(Department depart);
    List<Department> selectAll();
    List<Department> selectFuzzy(Department depart);
}
