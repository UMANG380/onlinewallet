package com.cg.onlinewallet.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.onlinewallet.dao.AccountDao;
import com.cg.onlinewallet.dao.AccountDaoImpl;
import com.cg.onlinewallet.dao.TransactionDao;
import com.cg.onlinewallet.dao.TransactionDaoImpl;
import com.cg.onlinewallet.dao.UserDao;
import com.cg.onlinewallet.dao.UserDaoImpl;
import com.cg.onlinewallet.dto.Account;
import com.cg.onlinewallet.dto.Transaction;
import com.cg.onlinewallet.dto.User;
import com.cg.onlinewallet.myexception.UserException;

public class AccountServiceImpl implements AccountService {
	AccountDao dao = new AccountDaoImpl();
	List<Transaction> transactionList1 = new ArrayList<Transaction>();
	TransactionDao transDao = new TransactionDaoImpl();

	public Account addBankAccount(Account acc) {
		// TODO Auto-generated method stub
		return dao.addBankAccount(acc);
	}

	public Boolean deleteBankAccount(Account acc) {
		// TODO Auto-generated method stub
		return dao.deleteBankAccount(acc);
	}

	public HashMap<BigInteger, Account> showBankAccount() {
		// TODO Auto-generated method stub
		return dao.showBankAccount();
	}

	public Transaction addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		transactionList1.add(transDao.addTransaction(t));
		return t;
		
	}

	public static void validateAccountNumber(BigInteger accNo) throws UserException {
			BigInteger bi1 = new BigInteger("100000000000");
			BigInteger bi2 = new BigInteger("999999999999");
			int res1 = accNo.compareTo(bi1);
			int res2 = accNo.compareTo(bi2); 
			  if(res2 == 1 || res1 == -1) {
			  throw new UserException("Account Number should be of 12 digits");
			  }
		  }
		
	}

	
	


