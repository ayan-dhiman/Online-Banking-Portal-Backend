package com.bankapppackage.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapppackage.bankapp.beans.Customer;
import com.bankapppackage.bankapp.dao.CustomerRepo;


@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
    CustomerRepo repo;
   
    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
    	
        repo.save(customer);
    }
    
   
    @GetMapping("/getCustomersAll") 
    public Iterable<Customer> getCustomers(){
  
    	
    	return repo.findAll();
    	
    }
    
    @PutMapping("/updateCustomerLoan/{id}")
    public void updateCustomer(@PathVariable int id,@RequestBody Customer customer)
    {
    	Customer updateCustomer=repo.findById(id).orElse(null);
    	updateCustomer.setIsApprovedNow(customer.getIsApprovedNow());
    	repo.save(updateCustomer);
    	
    }
    
    @GetMapping("/getLoanRequest/{accountNo}/{isApprovedNow}")
    public Customer getRequest(@PathVariable long accountNo,@PathVariable int isApprovedNow)
    {
    	Customer cust=repo.getRequests(accountNo,isApprovedNow);
    	return cust;
    }
    
    @GetMapping("/getUndeniedLoanRequest/{accountNo}")
    public Customer getUndeniedRequest(@PathVariable long accountNo)
    {
    	Customer acc=repo.getUndeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getDeniedLoanRequest/{accountNo}")
    public Customer getDeniedRequest(@PathVariable long accountNo)
    {
    	Customer acc=repo.getDeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getAllLoanRequest/{accountNo}")
    public Iterable<Customer> getAllLoanRequest(@PathVariable long accountNo)
    {
    	Iterable<Customer> acc=repo.getAllRequestForAccount(accountNo);
    	return acc;
    }
    
    
    
}