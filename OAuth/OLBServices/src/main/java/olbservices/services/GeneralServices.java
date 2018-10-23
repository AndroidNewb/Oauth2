package olbservices.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import olbservices.model.Branch;
import olbservices.repository.BranchRepository;

public class GeneralServices {

	@Autowired
	BranchRepository branchRepository;
	
	public  List<String> getBranches()
	{
		List<Branch> branchList=branchRepository.findAll();		
		List<String> branchIFSC_List= new ArrayList<String>();
		for (Branch branch:branchList)
		{
			branchIFSC_List.add(branch.getIfsc());
		}	
		return branchIFSC_List;
	}
	
	
	public String stackTrace_to_String(Exception exception)
	{
		StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        return exceptionAsString;
	}
	
}
