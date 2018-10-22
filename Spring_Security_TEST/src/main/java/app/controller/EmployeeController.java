package app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.model.Employee;
import app.repository.EmployeeRepository;



@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeData;

	@RequestMapping(value = "/addnew", method = RequestMethod.POST)
	public String newEmployee(Employee employee) {

		employeeData.save(employee);
		System.out.println("New employee -> "+employee.toString());
		return ("redirect:/listall");

	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("AddNewEmployee", "form", emp);

	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginPage() {

		
		return new ModelAndView("login");

	}

	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<Employee> allEmployees = employeeData.findAll();
		System.out.println(allEmployees.size());
		
		for(Employee emp:allEmployees)
		{
			System.out.println(emp.getName()+" "+emp.getDept());
		}
		
		return new ModelAndView("allEmployees", "employees", allEmployees);

	}

}