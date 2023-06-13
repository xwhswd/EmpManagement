package com.iweb.arui;

import com.iweb.arui.pojo.Department;
import com.iweb.arui.service.DepartmentService;
import com.iweb.arui.service.impl.DepartmentServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class DepartmentTest {
    DepartmentService departmentService = new DepartmentServiceImpl();

    @Test
    public void addDepartment(){
        System.out.println(departmentService.addDepartment(new Department(1,"pthon部1")));
    }
    @Test
    public void deleteDepartment(){
        System.out.println(departmentService.deleteDepartment(new Department(2,null)));
    }
    @Test
    public void updateDepartment(){
        System.out.println(departmentService.updateDepartment(new Department(3,"pp部")));
    }
    @Test
    public void getAllDepartment(){
        System.out.println(departmentService.getAllDepartment().toString());
    }@Test
    public void getDepartmentByKey(){
        System.out.println(departmentService.getDepartmentByKey(new Department(3,"部")));
    }


}
