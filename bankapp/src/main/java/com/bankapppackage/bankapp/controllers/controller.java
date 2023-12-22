package com.bankapppackage.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bankapppackage.bankapp.beans.AccountNumber;
import com.bankapppackage.bankapp.beans.User;
import com.bankapppackage.bankapp.dao.Repository;
import com.bankapppackage.bankapp.dao.transactionRepository;

@Controller
@CrossOrigin
public class controller {

	@Autowired
	Repository repo;
	
	@Autowired
	transactionRepository transactRepo;

	@RequestMapping("/")
	public String createUser() {
		return "loginPage.jsp";
	}

	@RequestMapping("/newUser")
	public String newUser() {
		return "createUser.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestBody AccountNumber accNumber) {
		
		System.out.println(accNumber);

		User user = repo.findByAccountNumber(accNumber.getAccNumber());

		if(user != null)
		{
			System.out.println(user);
			return "welcome.jsp";
		}
		else
		{
			System.out.println("User not found !");
		}

		return "loginPage.jsp";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getUser")
	public @ResponseBody Iterable<User> getUser() {
		
		System.out.println(repo.findAll());

		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getUserById/{accountNumber}")
	public @ResponseBody User getUserById(@PathVariable long accountNumber) {
		
		System.out.println(repo.findByAccountNumber(accountNumber));

		return repo.findByAccountNumber(accountNumber);
	} 

	@RequestMapping("/addUser")
	public String addUser(@RequestBody User user) {
		System.out.println(user);
		repo.save(user);
		return "createUser.jsp";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getUserByPhone/{phone}")
	public @ResponseBody User getUserByPhone(@PathVariable String phone) {
		
		System.out.println(repo.findByPhone(phone));

		return repo.findByPhone(phone);
	}
	
	
//	---------------------Sakshi--------------------------------------
	
	@PutMapping("/updateCustomer/{accountNumber}")
    public void updateCustomer(@PathVariable long accountNumber, @RequestBody User user) {
        User u = repo.findByAccountNumber(accountNumber);
        u.setPassword(user.getPassword());
        repo.save(u);
    }
	
//	---------------------Sakshi--------------------------------------
	
//	---------------------Shivang--------------------------------------
	
	
	
	
//	---------------------Shivang--------------------------------------

}
