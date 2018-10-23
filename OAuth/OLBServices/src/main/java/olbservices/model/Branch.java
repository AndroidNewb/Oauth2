package olbservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;



@Entity
public class Branch implements Serializable{
	@Id
	@GenericGenerator(name = "branchifsc_Sequence", strategy="olbservices.services.BranchIFSCGenerator" )
    @GeneratedValue(generator = "branchifsc_Sequence")
	private String ifsc;
	
	private String branchLocation;
	private String branchCity;
	@Size(min=6 , max=6)
	@Column(name="branch_pin")
	private String branchPIN;
	
	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranchPIN() {
		return branchPIN;
	}

	public void setBranchPIN(String branchPIN) {
		this.branchPIN = branchPIN;
	}

	private String branchState;
	
	/*@JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "olbUser", nullable = false)
	private User olbUser;*/
	
	
	
	


	public Branch()
	{}

	public Branch(String BranchLocation, String branchCity, String branchPIN,String branchState)
	{
		this.branchLocation=BranchLocation;
		this.branchCity=branchCity;
		this.branchPIN=branchPIN;
		this.branchState=branchState;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchState() {
		return branchState;
	}

	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}

	@Override
	public String toString()
	{
		return this.getIfsc()+" | "+this.getBranchLocation()+" | "+this.getBranchCity()+" | "+this.getBranchState()+" | "+this.getBranchPIN();
	}
	
	
}