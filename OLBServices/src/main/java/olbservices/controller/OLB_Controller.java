package olbservices.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.commons.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import olbservices.FDO.CreditMoneyFDO;
import olbservices.FDO.NewUserFDO;
import olbservices.FDO.NewbranchFDO;
import olbservices.FDO.SearchUserFDO;
import olbservices.FDO.TransferMoneyFDO;
import olbservices.model.Branch;
import olbservices.model.OLBUserInfo;
import olbservices.model.SavingsAccount;
import olbservices.model.Transaction;
import olbservices.model.User;
import olbservices.repository.BranchRepository;
import olbservices.repository.SavingsAccountRepository;
import olbservices.repository.TransactionRepository;
import olbservices.repository.UserRepository;
import olbservices.services.GeneralServices;
import olbservices.services.UserDataValidator;

@RestController
public class OLB_Controller {

	@Autowired
	UserRepository userRepository;
	@Autowired
	SavingsAccountRepository accountRepository;
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	TransactionRepository transactionRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger("OLBservices");
	private GeneralServices generalServices= new GeneralServices();

	@GetMapping(value="/ui/createuser")
	public ModelAndView addUser()
	{

		return new ModelAndView("createUser");
	}

	@GetMapping(value="/ui/evaluate")
	public ModelAndView evaluateUserType()
	{
		return new ModelAndView("evaluateUser");
	}

	@PostMapping(value="/api/saveNewuser",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView newUser( NewUserFDO newUser)
	{
		LOGGER.debug("Creating new OLB user");
		ModelAndView view= new ModelAndView("status");

		LOGGER.info("New User entry  {}",newUser.toString());
		LOGGER.debug("Validating User details ...  ");
		boolean isNameValid=false;
		boolean isPANvalid=false;
		boolean isPhoneValid=false;
		boolean isDepositValid=false;
		UserDataValidator dataValidator= new UserDataValidator();

		if (dataValidator.isNameValid(newUser.getFn()) && dataValidator.isNameValid(newUser.getLn()))
		{
			LOGGER.debug("Username -> VALID");
			isNameValid=true;
		}
		else
		{
			view.addObject("userErrorStatus", "Username is invalid. It should contain only alphabets");
			LOGGER.debug("Username -> INVALID");
		}

		if(dataValidator.isPANValid(newUser.getPan()))
		{
			LOGGER.info("PAN -> VALID");
			isPANvalid=true;
		}
		else
		{
			view.addObject("PANErrorStatus", "PAN is invalid.");
			LOGGER.debug("PAN -> INVALID");
		}

		EmailValidator emailValidator=EmailValidator.getInstance();
		boolean isEmailValid=false;
		isEmailValid=emailValidator.isValid(newUser.getEmail());

		if (isEmailValid)
		{
			LOGGER.debug("EMAIL -> VALID");
		}
		else
		{
			view.addObject("emailErrorStatus", "email is invalid.");
			LOGGER.debug("EMAIL -> INVALID");
			isEmailValid=false;
		}

		if (dataValidator.isPhoneNumberValid(newUser.getPhone()))
		{
			LOGGER.debug("PHONE NO -> VALID");
			isPhoneValid=true;
		}
		else
		{
			view.addObject("phoneErrorStatus", "phone number is invalid.");
			LOGGER.debug("Phone Number -> INVALID");
		}

		if (dataValidator.isDepositValid(newUser.getDeposit()))
		{
			LOGGER.debug("DEPOSIT -> VALID");
			isDepositValid=true;
		}
		else
		{
			view.addObject("depositErrorStatus", "Deposit amout should be numeric and greater than or equal to 1000");
			LOGGER.debug("Deposit -> INVALID");
		}

		if(isNameValid && isPANvalid && isEmailValid && isPhoneValid && isDepositValid)
		{
			LOGGER.info("User {} is Valid, it can be persisted",newUser.getUsername());
			try 
			{
				Branch branch=branchRepository.findByifsc(newUser.getBranch());
				if (branch==null)
				{
					LOGGER.debug("Branch "+newUser.getBranch()+"  does not exist ");
					view.addObject("branchErrorStatus", "Branch is invalid");
				}
				else
				{
					SavingsAccount savingsAccount= new SavingsAccount(Integer.parseInt(newUser.getDeposit()));
					userRepository.save(newUser.toUser());
					savingsAccount.setAccountBranch(branch);
					savingsAccount.setAccountHolder(newUser.toUser());
					accountRepository.save(savingsAccount);
					view.addObject("status", "User "+newUser.getUsername()+" created with AccountNo "+savingsAccount.getSavingsAccountNumber());
				}


			} catch (Exception e) {
				LOGGER.error(generalServices.stackTrace_to_String(e));
			}


		}
		else 
			LOGGER.debug("User {} is Invalid",newUser.getUsername());

		return view;
	}



	/*
	@RequestMapping(value="/showAllUsers", method=RequestMethod.GET)
	public String getAllUsers(Model model)
	{
		List<User> olbUsers= userRepository.findAll();
		LOGGER.info("User count {}",olbUsers.size()+"");
		model.addAttribute("olbusers", olbUsers);

		return "showAllUsers";
	}*/



	@GetMapping(value="/ui/home/{userid}")	
	public ModelAndView getUserByUserId(@PathVariable ("userid")String userid, HttpSession session)
	{
		System.out.println("HOME --> "+userid);
		if(userid.equalsIgnoreCase("null"))
		{
			return sessionTimeout();
		}
		else
		{
			session.setAttribute("olbuser", userid);
			LOGGER.info("Home page called for user {}",userid);
			User olbUser=userRepository.findByusername(userid);
			LOGGER.info("User {} found in records",olbUser.getUsername());

			SavingsAccount userAccount=accountRepository.findByaccountHolder(olbUser);
			LOGGER.info("Linked Account-> {}",userAccount.getSavingsAccountNumber());

			Branch branch=userAccount.getAccountBranch();
			LOGGER.info("Home branch-> {}",branch.toString());


			ModelAndView model1= new ModelAndView();
			model1.setViewName("home");
			model1.addObject("user", olbUser);
			model1.addObject("account", userAccount);
			model1.addObject("branch", branch);
			List<Transaction> userTransactions=getTransactions(userAccount.getSavingsAccountNumber()+"");
			model1.addObject("transactions", userTransactions);
			//session.setAttribute("transactions", userTransactions);
			session.setAttribute("accountno",olbUser.getSavingsAcc().getSavingsAccountNumber());
			return model1;
		}
	}

	public List<Transaction> getTransactions(String accountNo)
	{
		List<Transaction> myTransactions=new ArrayList<Transaction>();
		myTransactions=transactionRepository.findAllByfromAccount(accountNo);
		List<Transaction> myTransactions1=transactionRepository.findAllBytoAccount(accountNo);
		myTransactions.addAll(myTransactions1);
		LOGGER.info("Retrieving transactions for Account {}",accountNo);
		Collections.sort(myTransactions);
		for (Transaction transaction:myTransactions)
		{
			LOGGER.info(transaction.toString());
		}

		return myTransactions;
	}

	@GetMapping(value="/ui/createbranch")
	public ModelAndView createNewUser()
	{
		return new ModelAndView("createBranch");
	}

	@PostMapping(value="/api/saveNewBranch",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView persistNewBranch(NewbranchFDO newBranchFDO)
	{
		ModelAndView model= new ModelAndView("status");
		LOGGER.info("New branch -> {}",newBranchFDO.toString());
		Branch branch=newBranchFDO.toBranch();
		branchRepository.save(branch);
		return model;
	}

	@GetMapping(value="/ui/creditmoney")
	public ModelAndView addMoneyView(HttpSession session)
	{

		if (session.getAttribute("olbuser")==null)
			return sessionTimeout();
		else
		{
			ModelAndView model= new ModelAndView("creditMoney");
			return model;
		}
	}

	@PostMapping(value="/api/saveCreditedMoney",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView addMoney(CreditMoneyFDO moneyFDO,HttpSession session)
	{
		LOGGER.debug("Staring Money credit persist");
		ModelAndView model= new ModelAndView("status");
		LOGGER.info("Persisting money credit {}",moneyFDO.toString());

		SavingsAccount account=accountRepository.findBysavingsAccountNumber(Long.parseLong(moneyFDO.getAccountNo()));
		int previousBalance=account.getSavingsAvailableBalance();
		int newAmount=previousBalance+Integer.parseInt(moneyFDO.getAmount());
		account.setSavingsAvailableBalance(newAmount);
		LOGGER.info("New balance  -> "+newAmount);
		accountRepository.save(account);

		String transactionID=generateTransactionID()+"";
		model.addObject("status", "Transaction ID: "+transactionID+" Account "+moneyFDO.getAccountNo()+" credited with "+moneyFDO.getAmount()+" Available balance -"+account.getSavingsAvailableBalance());
		LocalDateTime timeOfTransaction=LocalDateTime.now();

		Transaction creditMoneyTransaction= new Transaction(transactionID,timeOfTransaction, "CASH_DEPOSIT", moneyFDO.getAccountNo(), Integer.parseInt( moneyFDO.getAmount()));
		transactionRepository.save(creditMoneyTransaction);

		return model;
	}

	@GetMapping(value="/ui/transfermoney")
	public ModelAndView transferMoney(HttpSession session)
	{
		if (session.getAttribute("accountno")==null)
			return sessionTimeout();
		else
			return new ModelAndView("transferMoney");
	}

	@PostMapping(value="/api/saveTransaction",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView saveMoneyTransaction(TransferMoneyFDO transferFDO)
	{
		LOGGER.debug("Saving new transaction initiated by {}",transferFDO.getAccountNo());
		ModelAndView model= new ModelAndView("status");
		LOGGER.info("Transaction -> {}",transferFDO.toString());

		SavingsAccount fromAccount=accountRepository.findBysavingsAccountNumber(Long.parseLong(transferFDO.getAccountNo()));
		SavingsAccount toAccount=accountRepository.findBysavingsAccountNumber(Long.parseLong(transferFDO.getToAccountNo()));

		/*System.out.println("From Account "+fromAccount.getSavingsAccountNumber());
		System.out.println("To account "+toAccount.getSavingsAccountNumber());*/

		Boolean transactionStatus=doTransaction(fromAccount, toAccount, transferFDO.getAmount());

		if(transactionStatus)
			LOGGER.info("Transaction successful");
		else
			LOGGER.info("Transaction failed");

		return model;
	}


	private Boolean doTransaction(SavingsAccount fromAcc, SavingsAccount toAcc,int amount)
	{
		LOGGER.debug("Transaction starting");
		String transactionStatus="";
		long transID=generateTransactionID();
		// true if transaction was successful
		boolean status=false;

		if (fromAcc.getSavingsAvailableBalance() >=  amount)
		{
			LOGGER.info("Sender Account {} has sufficient amount {} for transaction",fromAcc.getSavingsAccountNumber(),amount);
			int SenderBalance=fromAcc.getSavingsAvailableBalance();
			fromAcc.setSavingsAvailableBalance(SenderBalance-amount);

			int ReceiverBalance=toAcc.getSavingsAvailableBalance();
			toAcc.setSavingsAvailableBalance(ReceiverBalance+amount);
			status=true;
		}

		transactionStatus="TransactionID="+transID+" |From "+fromAcc.getSavingsAccountNumber()+" |To "+toAcc.getSavingsAccountNumber()+"| amount= "+amount+"|status="+status;	

		LOGGER.info("Transaction Status : {}",transactionStatus);

		accountRepository.save(fromAcc);
		accountRepository.save(toAcc);

		LocalDateTime timeOfTransaction=LocalDateTime.now();
		Transaction transaction=new Transaction(transID+"", timeOfTransaction,fromAcc.getSavingsAccountNumber()+"", toAcc.getSavingsAccountNumber()+"", amount);
		transactionRepository.save(transaction);

		return status;
	}

	private long generateTransactionID() {
		long LIMIT = 10000000000L;
		long last = 0;
		long id = System.currentTimeMillis() % LIMIT;
		if ( id <= last ) {
			id = (last + 1) % LIMIT;
		}
		return last = id;
	}

	@GetMapping(value="/ui/searchuser")
	public ModelAndView searchUserPage()
	{
		return new ModelAndView("searchUser");
	}

	@PostMapping(value="/api/searchUserfromDB",consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView searchUser(SearchUserFDO searchUserFDO)
	{
		LOGGER.debug("Admin searching for user with username {} ", searchUserFDO.getUsername());
		ModelAndView model= new ModelAndView("userSearchResult");

		if(searchUserFDO.getUsername()!=null)
		{
			User user=userRepository.findByusername(searchUserFDO.getUsername());
			if (user!=null)
			{
				LOGGER.info("User found {}"+user.toString());
				User olbUser=userRepository.findByusername(searchUserFDO.getUsername());
				LOGGER.info("User {} found in records",olbUser.getUsername());

				SavingsAccount userAccount=accountRepository.findByaccountHolder(olbUser);
				LOGGER.info("Linked Account-> {}",userAccount.getSavingsAccountNumber());
				Branch branch=userAccount.getAccountBranch();
				LOGGER.info("Home branch-> {}",branch.toString());
				String userPAN=olbUser.getPAN();
				String maskedPAN = userPAN.substring(0, 2) + "XXXXXX" + userPAN.substring(8);
				olbUser.setPAN(maskedPAN);
				model.addObject("user", olbUser);
				model.addObject("account", userAccount);
				model.addObject("branch", branch);
				List<Transaction> userTransactions=getTransactions(userAccount.getSavingsAccountNumber()+"");
				model.addObject("transactions", userTransactions);			
			}
			else
				LOGGER.error("User with username {} not found",searchUserFDO.getUsername());

		}
		return model;
	}

	@GetMapping(value="/sessiontimeout")
	public ModelAndView sessionTimeout()
	{
		return new ModelAndView("sessionTimeOut");
	}

	@GetMapping(value="/oauth/getuserinfo/{username}")
	public OLBUserInfo getUserInfo(@PathVariable ("username")String userid)
	{
		if(userid!=null && userid!="")
		{
			OLBUserInfo olbuserinfo= new OLBUserInfo();
			User user=userRepository.findByusername(userid);
			SavingsAccount account=accountRepository.findByaccountHolder(user);

			olbuserinfo.setAccountNo(account.getSavingsAccountNumber()+"");
			olbuserinfo.setBalance(account.getSavingsAvailableBalance()+"");

			return olbuserinfo;
		}
		else
			return null;
	}
}