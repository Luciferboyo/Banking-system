package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank implements BankInterface{

	private LinkedHashMap<Long, Account> accounts; // object reference
	
	private static final AtomicLong count = new AtomicLong(System.currentTimeMillis());

	public static long number() {
		return count.getAndIncrement();
	}

	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		Account user = accounts.get(accountNumber);
		if (user == null) {
			throw new IllegalArgumentException("Invalid account number");
		}
		
		return user;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		CommercialAccount commercialAccount = new CommercialAccount(company, Bank.number(), pin, startingDeposit);
		accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
		return commercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		ConsumerAccount consumerAccount = new ConsumerAccount(person, Bank.number(), pin, startingDeposit);
		accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
		return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account user = accounts.get(accountNumber);
		if(user == null){
			throw new IllegalArgumentException("Invalid account number");
		}
		if(user.getPin() != pin){
			throw new IllegalArgumentException("Invalid account Pin");
		}
		return true;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account user = accounts.get(accountNumber);
		if (user == null) {
			throw new IllegalArgumentException("Account does not exist");
		}
		return user.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account user = accounts.get(accountNumber);
		if (user == null) {
			throw new IllegalArgumentException("Account does not exist");
		}
		user.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account user = accounts.get(accountNumber);
		if (user == null) {
			throw new IllegalArgumentException("Account does not exist");
		}
		if(user.debitAccount(amount))
			return true;
		return false;
	}
}
