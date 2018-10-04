package olbservices.services;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BranchIFSCGenerator  implements IdentifierGenerator{

	private static final Logger LOGGER = LoggerFactory.getLogger("OLBservices");
	private GeneralServices generalServices= new GeneralServices();
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException 
	{
		LOGGER.info("Generating Branch IFSC for new branch");
		Connection connection = session.connection();


		try {
			Statement statement=connection.createStatement();

			ResultSet rs=statement.executeQuery("select count(ifsc) as Id from olb_schema.branch");

			if(rs.next())
			{
				String prefix="IBIN";
				String startValue="1000";
				System.out.println("StartValue "+startValue);
				long id=Long.parseLong(startValue)+rs.getInt(1);	
				System.out.println("Generated Id: " + prefix+id);
				return prefix+id;
			}
		} catch (SQLException e) {
			LOGGER.error(generalServices.stackTrace_to_String(e));
		}

		return null;
	}

}
