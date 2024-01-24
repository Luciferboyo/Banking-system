package com.javahongkong.bootcamp.exercise;

public class Transaction implements TransactionInterface{
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *                      The bank where the account is housed.
	 * @param accountNumber
	 *                      The customer's account number.
	 * @param attemptedPin
	 *                      The PIN entered by the customer.
	 * @throws Exception
	 *                   Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		Account user =  bank.getAccount(accountNumber);
		if(user.getPin() != attemptedPin){
			throw new IllegalArgumentException("Invalid account Pin");
		}
		this.bank = bank;
		this.accountNumber = accountNumber;
		
	}

	public double getBalance() {
		// complete the function
		return this.bank.getBalance(this.accountNumber);
	}

	public void credit(double amount) {
		// complete the function
		bank.credit(this.accountNumber, amount);
	}

	public boolean debit(double amount) {
		// complete the function
		if(bank.debit(accountNumber, amount))
			return true;
		return false;
	}
}
