package app.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.model.Employee;

@Controller
public class EmployeeController {

	

	
    @RequestMapping(value = "/user/getEmployeesList", produces = "application/json")
    @ResponseBody
    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setEmpId("emp1");
        emp.setEmpName("empName");
        employees.add(emp);
        return employees;

    }

}