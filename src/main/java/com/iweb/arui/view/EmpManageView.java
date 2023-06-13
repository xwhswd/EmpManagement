package com.iweb.arui.view;

import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.Department;
import com.iweb.arui.pojo.Employee;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.EmployeeService;
import com.iweb.arui.service.impl.EmployeeServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class EmpManageView {
    static EmployeeService employeeService;
    static {
        employeeService=new EmployeeServiceImpl();
    }

    public static void empManageView(){
        Print.print("进入 员工管理 页面...");
        Print.print("请选择要进行的操作");
        Print.print("1.添加员工");
        Print.print("2.删除员工");
        Print.print("3.更新员工");
        Print.print("4.查询所有员工");
        Print.print("5.模糊筛选员工");
        Print.print("6.返回用户界面");
        String choose = GetCommand.nextLine();
        UserController.empManInfo(choose);
    }
    public static void addEmp(){
        Print.print("请输入要添加的员工姓名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入要添加的员工身份证号码:");
        String idCard = GetCommand.nextLine();
        Print.print("请输入要添加的员工电话号码:");
        String phone = GetCommand.nextLine();
        Print.print("请输入要添加的员工性别:");
        String sex = GetCommand.nextLine();
        Print.print("请输入要添加的员工职位号:");
        String position = GetCommand.nextLine();
        Print.print("请输入要添加的员工部门号:");
        String department = GetCommand.nextLine();
        Employee employee = new Employee(0, inputUserName, idCard, phone, sex,
                new Post(Long.parseLong(position), null, null),
                new Department(Long.parseLong(department), null));
        boolean b = employeeService.addEmployee(employee);
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            EmpManageView.addEmp();
        }
    }
    public static void deleteEmp(){
        Print.print("请输入要删除的员工id:");
        String id = GetCommand.nextLine();
        boolean b = employeeService.deleteEmployee(new Employee(Long.parseLong(id),null,
                null,null,null,null,null));
        if (b){
            Print.print("删除成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            DeptManageView.deleteDept();;
        }
    }
    public static void updateEmp(){
        Print.print("请输入要修改的员工id:");
        String id = GetCommand.nextLine();
        Print.print("请输入要修改的员工姓名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入要添加的员工身份证号码:");
        String idCard = GetCommand.nextLine();
        Print.print("请输入要添加的员工电话号码:");
        String phone = GetCommand.nextLine();
        Print.print("请输入要添加的员工性别:");
        String sex = GetCommand.nextLine();
        Print.print("请输入要添加的员工职位号:");
        String position = GetCommand.nextLine();
        Print.print("请输入要添加的员工部门号:");
        String department = GetCommand.nextLine();
        Employee employee = new Employee(Long.parseLong(id), inputUserName, idCard, phone, sex,
                new Post(Long.parseLong(position), null, null),
                new Department(Long.parseLong(department), null));
        boolean b = employeeService.updateEmployee(employee);
        if (b){
            Print.print("修改成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            EmpManageView.updateEmp();
        }
    }
    public static void searchAllEmp(){
        Print.print("以下是员工信息:");
        List<Employee> list = employeeService.selectAllEmployee();
        for (Employee e:list) {
            Print.print(e.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
    public static void searchEmpByKey(){
        Print.print("请输入要查询的姓名key:");
        String name = GetCommand.nextLine();
        Print.print("请输入要查询的身份证key:");
        String idCard = GetCommand.nextLine();
        Print.print("请输入要查询的电话号码key:");
        String phone = GetCommand.nextLine();
        Print.print("请输入要查询的性别key:");
        String sex = GetCommand.nextLine();
        Print.print("请输入要查询的职位号key:");
        String position = GetCommand.nextLine();
        Print.print("请输入要查询的部门号key:");
        String department = GetCommand.nextLine();
        Print.print("以下是员工信息:");
        List<Employee> list = employeeService.selectEmployeeByKey(new Employee(0, name, idCard, phone, sex,
                new Post(Long.parseLong(position), null, null),
                new Department(Long.parseLong(department), null)));
        for (Employee e:list) {
            Print.print(e.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
}
