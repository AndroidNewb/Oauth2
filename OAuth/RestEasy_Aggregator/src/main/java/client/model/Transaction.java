package client.model;



import java.time.LocalDateTime;




public class Transaction implements Comparable<Transaction>{

	private String transactionID;
	private String transactionTime;
	private String fromAccount;
	private String toAccount;
	private int amount;

	
	public Transaction()
	{}
	
	public Transaction(String transactionID, String transactionTime,String fromAccount, String toAccount, int amount) 
	{
		this.transactionID = transactionID;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.transactionTime=transactionTime;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString()
	{
		return "Transaction ID: "+this.getTransactionID()+" | Transaction Time: "+this.getTransactionTime()+" | Sender "+this.getFromAccount()+" | Receiver "+this.getToAccount()+" | Amount "+this.getAmount();
	}
	
	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	public int compareTo(Transaction transaction) {
		
		 return getTransactionTime().compareTo(transaction.getTransactionTime());
	}




	
}
