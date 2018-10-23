package authz_server.model;

import java.io.Serializable;
import java.util.List;

public class OLBUserInfo implements Serializable{

	private String username;
	private String accountNo;
	private String balance;
	private List<Transaction> transactions;
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString()
	{
		return this.getUsername()+" | "+this.getAccountNo()+" | "+this.getBalance()+" | "+this.getTransactions().size();
	}

	
	
	
}