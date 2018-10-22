package authz_server.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import authz_server.model.Employee;
import authz_server.model.OLBUser;

@Controller
public class AuthZController {

	

	
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
    
    @RequestMapping(value = "/getUserDetails", produces = "application/json")
    @ResponseBody
    public ModelAndView getUserDetails()
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String principalName = auth.getName(); //get logged in username
        System.out.println("LoggedIn User ->>> "+principalName);
        ModelAndView userModel= new ModelAndView("user");
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            OLBUser userDetails=restTemplate.getForObject("http://localhost:9000/oauth/getuserinfo/"+principalName, OLBUser.class);
            
            userModel.addObject("username", userDetails.getUserName());
            userModel.addObject("balance", userDetails.getAvailableBalance());
            userModel.addObject("accountNo", userDetails.getAccountNumber());
            userModel.addObject("transactions", userDetails.getTransactions());
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
    	
     
    	
    	return userModel;
    }

}