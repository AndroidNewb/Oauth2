package olbservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import olbservices.model.Branch;
import olbservices.model.SavingsAccount;
import olbservices.model.User;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long>{

	public SavingsAccount findByaccountHolder(User accountholder);
	
	public SavingsAccount findBysavingsAccountNumber(long accountNo);
	
}
