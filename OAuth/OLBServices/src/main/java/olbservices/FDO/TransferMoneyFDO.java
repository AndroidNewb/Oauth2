package olbservices.FDO;

public class TransferMoneyFDO {

	public String accountNo;
	public String toAccountNo;
	public int amount;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getToAccountNo() {
		return toAccountNo;
	}
	public void setToAccountNo(String toAccountNo) {
		this.toAccountNo = toAccountNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String toString()
	{
		return this.getAccountNo()+" | "+this.toAccountNo+" | "+this.amount;
	}
	
}
