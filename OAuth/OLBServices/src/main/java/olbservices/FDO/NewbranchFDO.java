package olbservices.FDO;

import olbservices.model.Branch;

public class NewbranchFDO {

	private String branchLocation;
	private String branchCity;
	private String branchPIN;
	private String branchState;
	
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
	public String getBranchPIN() {
		return branchPIN;
	}
	public void setBranchPIN(String branchPIN) {
		this.branchPIN = branchPIN;
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
		return this.getBranchLocation()+" | "+this.getBranchCity()+" | "+this.getBranchPIN()+" | "+this.getBranchState();
	}
	
	public Branch toBranch()
	{
		return new Branch(this.getBranchLocation(), this.getBranchCity(), this.getBranchPIN(), this.getBranchState());
	}
	
}
