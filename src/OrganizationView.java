
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


class OrganizationView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		          System.out.println("ID      Organization Names\n");
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int OrganizationID = resultSet.getInt("OrganizationID");
				String OrganizationName = resultSet.getString("OrganizationName");
				
				// Display values
				System.out.print(OrganizationID + "\t");
				System.out.print(OrganizationName + "\n");
			
			}
			resultSet.close();	
		}
		//Organizasyon tablosunu bastırdıktan sonra başvuru yapması için yönlendiriyoruz
                return new ViewData("ApplicationInformation", "applierInsert.gui", new HashMap<>());
	}
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer OrganizationID = getInteger("OrganizationID  : ", true);
                Integer RelatedOrgID = getInteger("RelatedOrgID: ", true);
                Integer OrgTypeID = getInteger("OrgTypeID : ", true);
                Integer PhoneNumber = getInteger("PhoneNumber : ", true);
		String OrganizationName = getString("OrganizationName : ", true);
		String Address = getString("Address : ", true);
                String eMail = getString("eMail : ", true);
                String PresidentName = getString("PresidentName : ", true);
                String EstablishDate = getString("EstablishDate : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (OrganizationID != null) whereParameters.put("OrganizationID", OrganizationID);
		if (RelatedOrgID != null) whereParameters.put("RelatedOrgID", RelatedOrgID);
		if (OrgTypeID != null) whereParameters.put("Process", OrgTypeID);
                if (PhoneNumber != null) whereParameters.put("PhoneNumber", PhoneNumber);
		if (OrganizationName != null) whereParameters.put("OrganizationName", OrganizationName);
                if (Address != null) whereParameters.put("Address", Address);
		if (eMail != null) whereParameters.put("eMail", eMail);
		if (PresidentName != null) whereParameters.put("PresidentName", PresidentName);
                if (EstablishDate != null) whereParameters.put("EstablishDate", EstablishDate);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Organizations", "select", parameters);
	}



	@Override
	public String toString() {
		return "Organizations View";
	}		
}
