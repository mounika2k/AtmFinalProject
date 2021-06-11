package com.hexaware.main.controller;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.hexaware.main.beans.Account;
import com.hexaware.main.beans.AccountType;
import com.hexaware.main.model.DBConfig;




@Controller
public class MainController {
	@Autowired
	private Account account;
	@Autowired
	private AccountType accounttype;
	@Autowired
	private DBConfig db;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/")
	public String showHome(Model model) {// dependency injection
	
		return "index"; 
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String showWelcome(Account account,BindingResult result,Model model) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Account> entity = new HttpEntity<Account>(account, headers);

		String s = restTemplate.exchange("http://localhost:6852/account/add", HttpMethod.POST, entity,String.class).getBody();
			model.addAttribute("msg","ACCOUNT CREATED SUCCESSFULLY");
		model.addAttribute("account",account);
		return "login";
		
	}
	 
	
	@RequestMapping("/transaction1")
	public String showTransaction(Model model) {
		model.addAttribute("account",account);
		return "transaction";
	}
	@RequestMapping("/login1")
	public String showLogin1(Model model) {
		model.addAttribute("account",account);
		model.addAttribute("msg", "");
		return "login";
	}
	@RequestMapping("/index")
	public String showIndex(Model model) {
		model.addAttribute("account",account);
		return "index";
	}
//	@RequestMapping("/index")
//	public String processTransfer(@RequestParam Long senderid, @RequestParam Long recepientid, @RequestParam Long amount, BindingResult result, Model model) {
//		
//	
//	System.out.println(amount);
//	HttpHeaders headers = new HttpHeaders();
//	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//	restTemplate.put("http://localhost:6852/accounttype/credit/"+recepientid+"/"+amount, entity);
//	restTemplate.put("http://localhost:6852/accounttype/debit/"+senderid+"/"+amount, entity);
//	model.addAttribute("msg", "ACCOUNT CREATED SUCCESSFULLY");
//
//	return "index";
//
//}
	
	
	
	@Bean
	public RestTemplate getTemplate() {
		final RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		return new RestTemplate();
	}
	@RequestMapping(value = "/register")
	public String processSignup(Model model) {

		model.addAttribute("account",account);
		
	     return "account";
		
	}

	@RequestMapping("/transaction") 
	public String processLogin(@RequestParam String email, @RequestParam String password, Account account, Model model) { 
	System.out.println(email); 
	System.out.println(password);
	String url = "http://localhost:6852/account/details/"+email+"/"+password; 
	HttpHeaders headers = new HttpHeaders();
	  
	  headers.setAccept(Arrays.asList(new MediaType[] { 
 	MediaType.APPLICATION_JSON
		  })); 
		  headers.setContentType(MediaType.APPLICATION_JSON);
	  headers.set("my_other_key", "my_other_value");
	  
	  // HttpEntity<String>: To get result as String. 
	 HttpEntity<String> entity = new HttpEntity<String>(headers);
	  
	 RestTemplate restTemplate = new RestTemplate();
	  
	  // Send request with GET method, and Headers.
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	  
	  String result = response.getBody();
	  
	  System.out.println(result);
	  
	  if(result == null) {
		  model.addAttribute("msg", "Invalid Credentials");
		  return "login";
	  }
	  return "transaction"; 
	}

}
