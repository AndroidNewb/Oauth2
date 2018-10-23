package authz_server.controller;


import java.util.ArrayList;
import java.util.Iterator;
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
import authz_server.model.OLBUserInfo;
import authz_server.model.Transaction;

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
    
    @RequestMapping(value = "/user/getUserDetails", produces = "application/json")
    @ResponseBody
    public OLBUserInfo getUserDetails()
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String principalName = auth.getName(); //get logged in username
        System.out.println("LoggedIn User ->>> "+principalName);
        ModelAndView userModel= new ModelAndView("user");
        OLBUserInfo userDetails=null;;
        try {
            RestTemplate restTemplate = new RestTemplate();
            userDetails=restTemplate.getForObject("http://localhost:9000/oauth/getuserinfo/"+principalName, OLBUserInfo.class);
            System.out.println(userDetails.toString());
            
           /* Iterator<Transaction> listIterator=userDetails.getTransactions().iterator();
            while(listIterator.hasNext())
            {
            	Transaction transaction= listIterator.next();
            	System.out.println(transaction.toString());
            }*/
            
            
            userModel.addObject("username", userDetails.getUsername());
            userModel.addObject("balance", userDetails.getBalance());
            userModel.addObject("accountNo", userDetails.getAccountNo());
            userModel.addObject("transactions", userDetails.getTransactions());
            
		} catch (Exception e) {
			e.printStackTrace();
		}
        
     
    	return userDetails;
    }

}