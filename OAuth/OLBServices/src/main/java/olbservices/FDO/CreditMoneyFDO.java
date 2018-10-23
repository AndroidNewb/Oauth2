package olbservices.FDO;

public class CreditMoneyFDO {

	private String username;
	private String accountNo;
	private String amount;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString()
	{
		return "Add Money -"+this.getUsername()+" | "+this.getAccountNo()+" | "+this.getAmount();
	}
	
}
