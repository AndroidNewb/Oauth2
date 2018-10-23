package olbservices.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * User bean for modeling a OLB user
 */
@Entity
@Table (name="OLB_User")
public class User implements Serializable{
	@Id
	private String username;
	@Column (name="PAN")
	private String PAN;
	@Column (name="fn")
	private String firstName;
	@Column (name="ln")
	private String lastName;
	@Column (name="email")
	private String email;
	@Column (name="phone")
	private String phoneNo;
	@Column (name="address")
	private String address;
	
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,
	cascade =  CascadeType.ALL,
	mappedBy = "accountHolder")
	private SavingsAccount savingsAcc;

	public User()
	{}

	public User(String PAN,String username, String fn,String ln,String email, String phoneNo,String address)
	{
		this.PAN=PAN;
		this.username=username;
		this.firstName=fn;
		this.lastName=ln;
		this.email=email;
		this.phoneNo=phoneNo;
		this.address=address;
	}


	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public SavingsAccount getSavingsAcc() {
		return savingsAcc;
	}

	public void setSavingsAcc(SavingsAccount savingsAcc) {
		this.savingsAcc = savingsAcc;
	}

	
	public String toString()
	{
		return this.getUsername()+" | "+this.getFirstName()+" | "+this.getLastName()+" | "+this.getPAN()+" | "+this.getEmail()+" | "+this.getPhoneNo()+" | "+this.getAddress();
	}



}
