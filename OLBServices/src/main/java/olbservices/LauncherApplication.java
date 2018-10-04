package olbservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import olbservices.model.Branch;
import olbservices.model.SavingsAccount;
import olbservices.model.User;
import olbservices.repository.BranchRepository;
import olbservices.repository.SavingsAccountRepository;
import olbservices.repository.UserRepository;


@SpringBootApplication
public class LauncherApplication implements CommandLineRunner{

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SavingsAccountRepository accountRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger("OLBservices");
	
	public static void main(String[] args) {
		SpringApplication.run(LauncherApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		LOGGER.warn("----------------------------------------------------------------------------");
		LOGGER.warn("----------------------------------------------------------------------------");

	/*	branchRepository.deleteAllInBatch();
		
		Branch branch1= new Branch("45 downing St, Miluwakee town", "Bangalore", "686989", "Karnataka");
		Branch branch2= new Branch("470 Robert St, Samsonshire", "London", "123456", "London");
		Branch branch3= new Branch("2089,7 cross, Vijayanagar", "Mysore", "665261", "Karnataka");
		Branch branch4= new Branch("142, 6th Cross, Evergreen terrace", "Springfield", "778945", "Illinois");
		
		branchRepository.save(branch1);
		branchRepository.save(branch2);
		branchRepository.save(branch3);
		branchRepository.save(branch4);
	*/
		/*accountRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();
		branchRepository.deleteAllInBatch();

		//Creating a new user
		User olbUser= new User("ABD1237","olbuser7","John","Doe7","johndoe7@yahoo.com","787487","asd, aa, 789187");
		userRepository.save(olbUser);
		Branch branch= new Branch("IB00143", "as, dfg, sdf 889978", "Mysore", "Karnataka");
		branchRepository.save(branch);




	    SavingsAccount account= new SavingsAccount(5000L);

	    account.setAccountHolder(olbUser);
	    account.setAccountBranch(branch);


	    accountRepository.save(account);*/

	}

}
