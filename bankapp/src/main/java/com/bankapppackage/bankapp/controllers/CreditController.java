package com.bankapppackage.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapppackage.bankapp.beans.ApplyCreditCard;
import com.bankapppackage.bankapp.dao.ApplyCreditRepo;



@RestController
@CrossOrigin
public class CreditController {
	@Autowired
    ApplyCreditRepo repo;
    @PostMapping("/SaveCredit")
    public void addCustomer(@RequestBody ApplyCreditCard CreditCard) {
    	
    	 double limit=0.2*CreditCard.getSalary();
    	 CreditCard.setCreditLimit(limit);
    	 repo.save(CreditCard);
    }
     
    @GetMapping("/getApplycredit") 
    public Iterable<ApplyCreditCard> getApplycredit(){
    	
    	return repo.findAll();
    	
    }
    
    @PutMapping("/updateCreditCard/{id}")
    public void updateCreditCard(@PathVariable int id,@RequestBody ApplyCreditCard applycreditcard)
    {
    	ApplyCreditCard updateapplycreditcard=repo.findById(id).orElse(null);
    	updateapplycreditcard.setIsApprovedNow(applycreditcard.getIsApprovedNow());
    	repo.save(updateapplycreditcard);
    	
    }
    
    @GetMapping("/getCreditCardRequest/{accountno}/{isApprovedNow}")
    public ApplyCreditCard getRequest(@PathVariable long accountno,@PathVariable int isApprovedNow)
    {
    	ApplyCreditCard acc=repo.getRequests(accountno,isApprovedNow);
    	return acc;
    }
    
    @GetMapping("/getUndeniedCreditRequest/{accountNo}")
    public ApplyCreditCard getUndeniedRequest(@PathVariable long accountNo)
    {
    	ApplyCreditCard acc=repo.getUndeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getDeniedCreditRequest/{accountNo}")
    public ApplyCreditCard getDeniedRequest(@PathVariable long accountNo)
    {
    	ApplyCreditCard acc=repo.getDeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getAllCreditRequest/{accountNo}")
    public Iterable<ApplyCreditCard> getAllCreditRequest(@PathVariable long accountNo)
    {
    	Iterable<ApplyCreditCard> acc=repo.getAllRequestForAccount(accountNo);
    	return acc;
    }
 

}
