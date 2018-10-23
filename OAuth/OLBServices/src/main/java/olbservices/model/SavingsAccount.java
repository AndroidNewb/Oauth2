package olbservices.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="OLB_SavAccount")
public class SavingsAccount implements Serializable{
	@Id
	@GenericGenerator(name = "accountNo_Sequence", strategy="olbservices.services.AccountIDGenerator" )
    @GeneratedValue(generator = "accountNo_Sequence")
	private long savingsAccountNumber;
	@Column(name="Balance")
	private int savingsAvailableBalance;
	
	
	
	@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
	private User accountHolder;
	

	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "homeBranch", nullable = false)
	private Branch homeBranch;
	
	public Branch getAccountBranch() {
		return homeBranch;
	}

	public void setAccountBranch(Branch accountBranch) {
		this.homeBranch = accountBranch;
	}

	public User getAccountHolder() {
		return accountHolder;
	}

	public SavingsAccount()
	{}
	
	public SavingsAccount(int balance)
	{
		this.savingsAvailableBalance=balance;
	}
	
	/*private Branch accountBranch;
	private float savingsIntRate;
	
	public float getSavingsIntRate() {
		return savingsIntRate;
	}
	public void setSavingsIntRate(float savingsIntRate) {
		this.savingsIntRate = savingsIntRate;
	}
	public Branch getAccountBranch() {
		return accountBranch;
	}
	public void setAccountBranch(Branch accountBranch) {
		this.accountBranch = accountBranch;
	}
	public User getAccountHolder() {
		return accountHolder;
	}*/
	public void setAccountHolder(User accountHolder) {
		this.accountHolder = accountHolder;
	}
	public long getSavingsAccountNumber() {
		return savingsAccountNumber;
	}
	public void setSavingsAccountNumber(long savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}
	public int getSavingsAvailableBalance() {
		return savingsAvailableBalance;
	}
	public void setSavingsAvailableBalance(int savingsAvailableBalance) {
		this.savingsAvailableBalance = savingsAvailableBalance;
	}
	
	
}
