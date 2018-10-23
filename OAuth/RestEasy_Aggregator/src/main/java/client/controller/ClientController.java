package client.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import client.model.Employee;
import client.model.OLBUserInfo;
import client.model.Transaction;



@Controller
public class ClientController {

	/*
	 * Starting OAuth URl
	 */
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ModelAndView getOLBUserInfo() {
		return new ModelAndView("getUsers");
	}


	@RequestMapping(value = "/showUsers", method = RequestMethod.GET)
	public ModelAndView showUsers(@RequestParam("code") String code) throws JsonProcessingException, IOException {
		ResponseEntity<String> response = null;
		System.out.println("Authorization Code------> " + code);

		RestTemplate restTemplate = new RestTemplate();

		// According OAuth documentation we need to send the client id and secret key in the header for authentication
		String credentials = "resteasy:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = "http://localhost:5001/oauth/token";
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:5002/showUsers";

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token Response ---------> " + response.getBody());

		// Get the Access Token From the recieved JSON response
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();

		String url = "http://localhost:5001/user/getUserDetails";

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers1);

		ResponseEntity<OLBUserInfo> OLBUser = restTemplate.exchange(url, HttpMethod.GET, entity, OLBUserInfo.class);
		System.out.println(OLBUser);
		OLBUserInfo userInfo=OLBUser.getBody();

		/*Iterator<Transaction> listIterator=userInfo.getTransactions().iterator();
		while(listIterator.hasNext())
		{
			Transaction transaction= listIterator.next();
			System.out.println(transaction.toString());
		}*/

		ModelAndView model = new ModelAndView("showUsers");
		model.addObject("user",userInfo);
		return model;
	}

	//-----------------------------------


	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ModelAndView getEmployeeInfo() {
		return new ModelAndView("getEmployees");
	}


	@RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
	public ModelAndView showEmployees(@RequestParam("code") String code) throws JsonProcessingException, IOException {
		ResponseEntity<String> response = null;
		System.out.println("Authorization Code------> " + code);

		RestTemplate restTemplate = new RestTemplate();

		// According OAuth documentation we need to send the client id and secret key in the header for authentication
		String credentials = "resteasy:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = "http://localhost:5001/oauth/token";
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:5002/showEmployees";

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token Response ---------> " + response.getBody());

		// Get the Access Token From the recieved JSON response
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();

		String url = "http://localhost:5001/user/getEmployeesList";

		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(headers1);

		ResponseEntity<Employee[]> employees = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
		System.out.println(employees);
		Employee[] employeeArray = employees.getBody();

		ModelAndView model = new ModelAndView("showEmployees");
		model.addObject("employees", Arrays.asList(employeeArray));
		return model;
	}



}
