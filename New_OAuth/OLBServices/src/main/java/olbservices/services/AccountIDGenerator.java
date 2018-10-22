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

public class AccountIDGenerator implements IdentifierGenerator{

	private static final Logger LOGGER = LoggerFactory.getLogger("OLBservices");
	private GeneralServices generalServices= new GeneralServices();
	/*
	 * Below method generates a custom account number for the savings Account. The staring value will be 00000555100 
	 */

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		LOGGER.info("Generating AccountID for new account");
		
		Connection connection = session.connection();
		

		try {
			Statement statement=connection.createStatement();

			ResultSet rs=statement.executeQuery("select count(savings_account_number) as Id from olb_schema.olb_sav_account");

			if(rs.next())
			{
				String startValue="5000555100";
				long id=Long.parseLong(startValue)+rs.getInt(1);	
				LOGGER.info("Generated Account Id: {}", id);
				return id;
			}
		} catch (SQLException e) {
			LOGGER.error(generalServices.stackTrace_to_String(e));
		}

		return null;
	}

}
