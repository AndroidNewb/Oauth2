package olbservices.model;



import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Transaction {

	@Id
	private String transactionID;
	private String fromAccount;
	private String toAccount;
	private int amount;

	
	public Transaction()
	{}
	
	public Transaction(String transactionID, String fromAccount, String toAccount, int amount) 
	{
		this.transactionID = transactionID;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}

	@Override
	public String toString()
	{
		return "Transaction ID: "+this.getTransactionID()+" | Sender "+this.getFromAccount()+" | Receiver "+this.getToAccount()+" | Amount "+this.getAmount();
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




	
}
