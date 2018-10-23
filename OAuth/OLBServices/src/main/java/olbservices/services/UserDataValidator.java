package olbservices.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import olbservices.services.GeneralServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDataValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger("OLBservices");
	private GeneralServices generalServices= new GeneralServices();
	
	public boolean isPhoneNumberValid(String phoneNo)
	{
		Pattern phonePattern = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		Matcher matcher = phonePattern.matcher(phoneNo); 
		return (matcher.matches()); 
	}

	public boolean isPANValid(String userPAN)
	{
		Pattern panPattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
		Matcher matcher = panPattern.matcher(userPAN);
		return matcher.matches();
	}

	public boolean isNameValid(String name)
	{
		Pattern namePattern=Pattern.compile("[a-zA-Z]+");
		Matcher matcher=namePattern.matcher(name);
		return matcher.matches()&&(name.length()>=2);
	}

	public boolean isDepositValid(String deposit)
	{
		boolean status=false;

		try {
			Integer depositAmt=Integer.parseInt(deposit);
			if (depositAmt==null || depositAmt<1000)
				status=false;
			else if (depositAmt!=null && depositAmt>=1000)
				status=true;
		} catch (Exception e) {
			LOGGER.error(generalServices.stackTrace_to_String(e));
		}

		return status;
	}


}