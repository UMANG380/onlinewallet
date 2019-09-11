package com.cg.onlinewallet.service;

import java.math.BigInteger;
import java.math.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cg.onlinewallet.dao.UserDao;
import com.cg.onlinewallet.dao.UserDaoImpl;
import com.cg.onlinewallet.dto.Account;
import com.cg.onlinewallet.dto.User;
import com.cg.onlinewallet.myexception.UserException;

public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();

	public User<Account> addUser(User<Account> u) {
		return dao.addUser(u);
	}

	public HashMap<BigInteger, User<Account>> showUser() {
		
		
		
		
		return dao.showUser();
	}

	public boolean deleteUser(BigInteger id) {
		return dao.deleteUser(id);
	}

	public User<Account> searchUser(BigInteger id) {
	
		return dao.searchUser(id);
		
	}
	
	public static void validateId(BigInteger id) throws UserException{
		BigInteger bi1 = new BigInteger("10000000");
		BigInteger bi2 = new BigInteger("99999999");
		int res1 = id.compareTo(bi1);
		int res2 = id.compareTo(bi2); 
		  if(res2 == 1 || res1 == -1) {
		  throw new UserException("Id should be of 8 digits");
		  }
	  }

	public static void validateName(String name)  throws UserException{
		
		boolean b1 =  name.matches( "[A-Z][a-z]*" );
		if(b1==false) {
			throw new UserException("Invalid Name");
		}
		
		
	}
public static void validatePassword(String name)  throws UserException{
		
		boolean b1 =  name.matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" );
		if(b1==false) {
			throw new UserException("Choose a Strong Password");
		}
				
	}
public static void validatePhoneNumber(BigInteger phoneNo) throws UserException{
	BigInteger bi1 = new BigInteger("1000000000");
	BigInteger bi2 = new BigInteger("9999999999");
	int res1 = phoneNo.compareTo(bi1);
	int res2 = phoneNo.compareTo(bi2); 
	  if(res2 == 1 || res1 == -1) {
	  throw new UserException("Phone Number should be of 10 digits");
	  }
  }
	

	

}
