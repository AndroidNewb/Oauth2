package authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import authserver.model.Users;
import authserver.repository.UsersRepository;

import java.security.Principal;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

	@Autowired
	UsersRepository userRepository;
	
    @GetMapping("/principal")
    public Principal user(Principal principal,HttpSession session) {
    	
    
    	session.setAttribute("EMAILS", "neha");
    	Users user=userRepository.findOneByName(principal.getName());
    	System.out.println("PRINCIPAL > "+user.getEmail());
    	return user;
    }
    
    @ModelAttribute("nehaObj")
    public String messages() {
        return "neha";
    }
    
    @GetMapping("/luser")
    public ModelAndView getUser(Principal principal)
    {
    	ModelAndView model1= new ModelAndView();
    	model1.addObject("neha", "neha");
    	return model1;
    }
    @GetMapping
    public String hello() {
        return "Hello World";
    }

}
