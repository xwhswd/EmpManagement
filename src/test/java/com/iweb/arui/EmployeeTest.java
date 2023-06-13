package com.iweb.arui;

import com.iweb.arui.pojo.Department;
import com.iweb.arui.pojo.Employee;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.service.EmployeeService;
import com.iweb.arui.service.impl.EmployeeServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class EmployeeTest {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void addPost(){
        System.out.println(employeeService.addEmployee(new Employee
                (1,"张三","123","345","男",
                        new Post(1,null,null),
                        new Department(1,null))));
    }
    @Test
    public void deleteEmployee(){
        System.out.println(employeeService.deleteEmployee(new Employee
                (1,null,null,null,null,
                        new Post(0,null,null),
                        new Department(0,null))));
    }
    @Test
    public void updateEmployee(){
        System.out.println(employeeService.updateEmployee(new Employee
                (2,"张三2","123","345","男",
                        new Post(1,null,null),
                        new Department(1,null))));
    }
    @Test
    public void selectAllEmployee(){
        System.out.println(employeeService.selectAllEmployee().toString());
    }
    @Test
    public void selectEmployeeByKey(){
        System.out.println(employeeService.selectEmployeeByKey(new Employee
                (2,"张",null,null,"男", new Post(),new Department())));
    }
}
