package com.javahongkong.bootcamp.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * Account implementation for commercial (business) customers.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account{
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		// complete the function
		super(company, accountNumber, pin, startingDeposit);
		authorizedUsers = new LinkedList<>();
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		// complete the function
		if (!isAuthorizedUser(person)) 
			authorizedUsers.add(person);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in
	 *         {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		// complete the function
		if(person == null){
			throw new IllegalArgumentException("Person object cannot be null");
		}
		for (Person p: authorizedUsers) {
			if(person.getIdNumber() != p.getIdNumber()){
				return true;
			}
		}
		return false;
	}
}
