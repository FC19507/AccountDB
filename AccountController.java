package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("account")
public class AccountController {
	ArrayList<Account> accounts = new ArrayList<Account>();
	@Autowired
	AccountService accountservice;
	@GetMapping("/")
	List<Account> getAcount() {
		System.out.println("called..");
		return accountservice.getAccount();
		}

	@GetMapping("/{name}")
    Account getAccount(@PathVariable String name) {
		for(Account account: accounts) {
			if(account.getName().equals(name)) {
				return account;
			}
		}
		System.out.println("Account not found");
		return null;
	}

	@PostMapping
	String postAccount(@RequestBody Account account) {
		accountservice.save(account);
		System.out.println("GOT acount  USER"+account.getName());;
		return "post called";

	}
}
