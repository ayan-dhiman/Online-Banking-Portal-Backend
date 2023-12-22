package com.bankapppackage.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapppackage.bankapp.beans.ApplyDebitCard;
import com.bankapppackage.bankapp.dao.ApplyDebitRepo;


@RestController
@CrossOrigin
public class DebitController {
	
	@Autowired
    ApplyDebitRepo repo;
	
    @PostMapping("/SaveDebit")
    public void addCustomer(@RequestBody ApplyDebitCard DebitCard) {
        repo.save(DebitCard);
       
    }
    
    
    @GetMapping("/getDebitcard") 
    public Iterable<ApplyDebitCard> getDebitCard(){
    	return repo.findAll();
    }
    
    
    @PutMapping("/updateDebitCard/{id}")
    public void updateDebitCard(@PathVariable int id,@RequestBody ApplyDebitCard applydebitcard)
    {
    	ApplyDebitCard updateDebitCard=repo.findById(id).orElse(null);
    	updateDebitCard.setIsApprovedNow(applydebitcard.getIsApprovedNow());
    	repo.save(updateDebitCard);
    }
    
    @GetMapping("/getDebitCardRequest/{accountNo}/{isApprovedNow}")
    public ApplyDebitCard getRequest(@PathVariable long accountno,@PathVariable int isApprovedNow)
    {
    	ApplyDebitCard acc=repo.getRequests(accountno,isApprovedNow);
    	return acc;
    }
    @GetMapping("/getUndeniedDebitRequest/{accountNo}")
    public ApplyDebitCard getUndeniedRequest(@PathVariable long accountNo)
    {
    	ApplyDebitCard acc=repo.getUndeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getDeniedDebitRequest/{accountNo}")
    public ApplyDebitCard getDeniedRequest(@PathVariable long accountNo)
    {
    	ApplyDebitCard acc=repo.getDeniedRequest(accountNo);
    	return acc;
    }
    
    @GetMapping("/getAllDebitRequest/{accountNo}")
    public Iterable<ApplyDebitCard> getAllDebitRequest(@PathVariable long accountNo)
    {
    	Iterable<ApplyDebitCard> acc=repo.getAllRequestForAccount(accountNo);
    	return acc;
    }

}