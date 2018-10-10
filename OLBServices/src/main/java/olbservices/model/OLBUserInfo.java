package olbservices.model;

import java.io.Serializable;

public class OLBUserInfo implements Serializable{

	private String accountNo;
	private String balance;
	
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
	
	
	
}