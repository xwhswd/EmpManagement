package com.iweb.arui.dao;

import com.iweb.arui.pojo.Department;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface DepartmentDao {
    void add(Department depart);
    void delete(Department depart);
    void update(Department depart);
    List<Department> selectAll();
    List<Department> selectFuzzy(Department depart);
}
