package com.iweb.arui.dao;

import com.iweb.arui.pojo.Department;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface DepartmentDao {
    /**
     * 添加一个部门
     * @param depart  部门信息 id不传入,传入部门名称添加一个部门
     * @return  操作是否成功
     */
    boolean add(Department depart);

    /**
     * 删除一个部门
     * @param depart 根据id删除部门
     * @return 操作是否成功
     */
    boolean delete(Department depart);

    /**
     * 更新部门信息
     * @param depart 根据id更新部门
     * @return 操作是否成功
     */
    boolean update(Department depart);

    /**
     * 查询所有部门
     * @return 返回一个部门的集合
     */
    List<Department> selectAll();

    /**
     * 根据信息模糊查询部门
     * @param depart 模糊查询的关键词
     * @return 返回查询的集合
     */
    List<Department> selectFuzzy(Department depart);

    /**
     * 根据id查询部门
     * @param id 部门号
     * @return 返回一个部门对象
     */
    Department selectById(long id);
}
