import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class OnlineView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int TypeID = resultSet.getInt("TypeID");
				int PathID = resultSet.getInt("PathID");
				String eMail = resultSet.getString("eMail");
				String WebSiteLink = resultSet.getString("WebSiteLink");
				
				// Display values
				System.out.print(TypeID + "\t");
				System.out.print(PathID + "\t");
				System.out.print(eMail + "\t");
				System.out.println(WebSiteLink);
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	
	
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer TypeID = getInteger("TypeID : ", true);
		Integer PathID = getInteger("PathID : ", true);
		String eMail = getString("eMail: ", true);
		String WebSiteLink = getString("WebSiteLink : ", true);
                
		Map<String, Object> whereParameters = new HashMap<>();
		if (TypeID != null) whereParameters.put("TypeID", TypeID);
		if (PathID != null) whereParameters.put("PathID", PathID);
		if (eMail != null) whereParameters.put("eMail", eMail);
		if (WebSiteLink != null) whereParameters.put("WebSiteLink", WebSiteLink);
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Online", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "TypeID, PathID, eMail, WebSiteLink");

		List<Object> rows = new ArrayList<>();
		int  TypeID,PathID;
               String WebSiteLink,eMail;
		do
		{
			System.out.println("Fields to insert:");
			TypeID = getInteger("TypeID : ", true);
                        PathID = getInteger("PathID : ", true);
                        eMail = getString("eMail : ", true);
			WebSiteLink = getString("WebSiteLink : ", true);
			System.out.println();
					
			if (TypeID != 0&& PathID != 0) {
				rows.add(new Online(TypeID, PathID,eMail,WebSiteLink));
			}
		}
		while (TypeID != 0 && PathID != 0 );
		
		parameters.put("rows", rows);
		
		return new ViewData("Online", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Filter conditions:");
		Integer TypeID = getInteger("TypeID : ", true);
		Integer PathID = getInteger("PathID : ", true);
		String eMail = getString("eMail: ", true);
		String WebSiteLink = getString("WebSiteLink : ", true);
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (TypeID != null) updateParameters.put("TypeID", TypeID);
		if (PathID != null) updateParameters.put("PathID", PathID);
		if (eMail != null) updateParameters.put("eMail", eMail);
		if (WebSiteLink != null) updateParameters.put("WebSiteLink", WebSiteLink);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Online", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Online", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Online View";
	}		
}
