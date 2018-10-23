package olbservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olbservices.model.Branch;
import olbservices.model.SavingsAccount;
import olbservices.model.User;

public interface BranchRepository extends JpaRepository<Branch, Long>{

	public Branch findByifsc(String ifsc);
	
}
