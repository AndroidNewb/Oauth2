package olbservices.FDO;

import olbservices.model.User;

public class NewUserFDO {

	private String username;
	private String pan;
	private String fn;
	private String ln;
	private String email;
	private String phone;
	private String deposit;
	private String address;
	private String branch;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String breanch) {
		this.branch = breanch;
	}
	
	public User toUser()
	{
		User newUser= new User(pan, username, fn, ln, email, phone, address);
		return newUser;
	}
	
	
	@Override
	public String toString()
	{
		return this.username+" | "+this.pan+" | "+this.fn+" | "+this.ln+" | "+this.phone+" | "+this.address+" | "+this.branch+" | "+this.deposit;
	}
}