package com.cg.onlinewallet.ui;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


import com.cg.onlinewallet.dto.Account;
import com.cg.onlinewallet.dto.Transaction;
import com.cg.onlinewallet.dto.User;
import com.cg.onlinewallet.myexception.UserException;
import com.cg.onlinewallet.service.AccountService;
import com.cg.onlinewallet.service.AccountServiceImpl;
import com.cg.onlinewallet.service.UserService;
import com.cg.onlinewallet.service.UserServiceImpl;



public class MyApplication {
	public static void main(String[] args)  {

	
	Scanner sc = new Scanner(System.in);
	Account account = new Account();

	UserService service = new UserServiceImpl();
	AccountService accService = new AccountServiceImpl();
	
	HashMap<BigInteger, User<Account>> hm = null;
	List<Transaction> myAll=new LinkedList<Transaction>();
	User<Account> user = new User<Account>();
	
	
	int choice;		
	
	do {
		System.out.println("Enter choice");
		print();
		choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter id");
			BigInteger id = sc.nextBigInteger();
			try {
				UserServiceImpl.validateId(id);
			}catch(UserException e) {
				System.out.println(e);
			}
			System.out.println("Enter Name");
			
			String name = sc.next();
			try {
				UserServiceImpl.validateName(name);
			}catch(UserException e) {
				System.out.println(e);
			}
			System.out.println("Enter Password");
			String password = sc.next();
			try {
				UserServiceImpl.validatePassword(password);
			}catch(UserException e) {
				System.out.println(e);
			}
			
			System.out.println("Enter Phone Number");
			BigInteger phoneNo = sc.nextBigInteger();
			try {
				UserServiceImpl.validatePhoneNumber(phoneNo);
			}catch(UserException e) {
				System.out.println(e);
			}
			System.out.println("Enter Account Number");
			BigInteger accNo  = sc.nextBigInteger();
			try {
				AccountServiceImpl.validateAccountNumber(accNo);
			}catch(UserException e) {
				System.out.println(e);
			}
			account.setAccountNo(accNo);
			account.setBalance(1000.0);
			
			Transaction tranOne=new Transaction("Account created",new BigInteger("10001"),new Date(),0.0,1000.0);
			Transaction traTwo=new Transaction("Purchased Book",new BigInteger("10002"),new Date(),100.0,900.0);
			Transaction tranThree=new Transaction("Purchased Pizza",new BigInteger("10003"),new Date(),300.0,600.0);
			
			
			myAll.add(tranOne);
			myAll.add(traTwo);
			myAll.add(tranThree);
			account.setBalance(600.0);
			account.setTransactionList(myAll);
			user.setUserId(id);
			user.setUserName(name);
			user.setUserPassword(password);
			
			user.setPhoneNo(phoneNo);
			user.setAcc(account);
			
			service.addUser(user);
			hm = service.showUser();
			break;
		
		case 2:
			System.out.println("Enter the User id you want to delete");
			BigInteger uid = sc.nextBigInteger();
			service.deleteUser(uid);
			System.out.println("The user detalis has been deleted");
			break;
		case 3:
			System.out.println("Enter the user id you want to search");
			id = sc.nextBigInteger();
		    service.searchUser(id);
			System.out.println(user);
			break;
		
		case 4:
			System.out.println(myAll);
			
		}
	} while(choice!=4);
	
	}

    public static void print() {
    	System.out.println("1:To add user");
    	System.out.println("2:Delete User");
    	System.out.println("3:Search User");
    	System.out.println("4: To see all transactions");
    	System.out.println("5: Exit");
    	}
	
}
