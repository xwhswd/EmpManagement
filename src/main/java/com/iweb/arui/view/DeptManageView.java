package com.iweb.arui.view;

import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.Department;
import com.iweb.arui.service.DepartmentService;
import com.iweb.arui.service.impl.DepartmentServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class DeptManageView {
    static DepartmentService departmentService;
    static {
        departmentService=new DepartmentServiceImpl();
    }
    public static void deptManageView(){
        Print.print("进入 部门管理 页面...");
        Print.print("请选择要进行的操作");
        Print.print("1.添加部门");
        Print.print("2.删除部门");
        Print.print("3.更新部门");
        Print.print("4.查询所有部门");
        Print.print("5.模糊筛选部门");
        Print.print("6.返回用户界面");
        String choose = GetCommand.nextLine();
        UserController.deptManInfo(choose);
    }

    public static void addDept(){
        Print.print("请输入要添加的部门名称:");
        String inputName = GetCommand.nextLine();
        boolean b = departmentService.addDepartment(new Department(0, inputName));
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("添加错误,请重新输入");
            DeptManageView.addDept();
        }
    }
    public static void deleteDept(){
        Print.print("请输入要删除的部门id:");
        String id = GetCommand.nextLine();
        Print.print("请输入要添加的部门名称:");
        String inputName = GetCommand.nextLine();
        boolean b = departmentService.updateDepartment(new Department(Long.parseLong(id), inputName));
        if (b){
            Print.print("删除成功");
            AdminView.adminView();
        }else {
            Print.print("添加错误,请重新输入");
            DeptManageView.deleteDept();
        }
    }
    public static void updateDept(){
        Print.print("请输入要修改的部门id:");
        String id = GetCommand.nextLine();
        boolean b = departmentService.deleteDepartment(new Department(Long.parseLong(id), null));
        if (b){
            Print.print("修改成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            DeptManageView.updateDept();
        }
    }
    public static void searchAllDept(){
        Print.print("以下是已有部门信息:");
        List<Department> allDepartment = departmentService.getAllDepartment();
        for (Department d:allDepartment) {
            Print.print(d.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
    public static void searchDeptByKey(){
        Print.print("请输入要查询的key:");
        String key = GetCommand.nextLine();
        Print.print("以下是已有部门信息:");
        List<Department> allDepartment = departmentService.getDepartmentByKey(new Department(0,key));
        for (Department d:allDepartment) {
            Print.print(d.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
}
