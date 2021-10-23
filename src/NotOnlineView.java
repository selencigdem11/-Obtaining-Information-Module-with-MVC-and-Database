import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class NotOnlineView implements ViewInterface {

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
				String Address = resultSet.getString("Address");
				int FaxNumber = resultSet.getInt("FaxNumber");
				
				// Display values
				System.out.print(TypeID + "\t");
				System.out.print(PathID + "\t");
				System.out.print(Address + "\t");
				System.out.println(FaxNumber);
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
		String Address = getString("Address: ", true);
		Integer FaxNumber = getInteger("FaxNumber : ", true);
                
		Map<String, Object> whereParameters = new HashMap<>();
		if (TypeID != null) whereParameters.put("TypeID", TypeID);
		if (PathID != null) whereParameters.put("PathID", PathID);
		if (Address != null) whereParameters.put("Address", Address);
		if (FaxNumber != null) whereParameters.put("FaxNumber", FaxNumber);
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("NotOnline", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "TypeID, PathID, Address, FaxNumber");

		List<Object> rows = new ArrayList<>();
		int  TypeID,PathID,FaxNumber;
		String Address;
		do
		{
			System.out.println("Fields to insert:");
			TypeID = getInteger("TypeID : ", true);
                        PathID = getInteger("PathID : ", true);
                        FaxNumber = getInteger("FaxNumber : ", true);
			Address = getString("Address : ", true);
			System.out.println();
					
			if (TypeID != 0&& PathID != 0) {
				rows.add(new NotOnline(TypeID, PathID,Address,FaxNumber));
			}
		}
		while (TypeID != 0 && PathID != 0 );
		
		parameters.put("rows", rows);
		
		return new ViewData("NotOnline", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Filter conditions:");
		Integer TypeID = getInteger("TypeID : ", true);
		Integer PathID = getInteger("PathID : ", true);
		String Address = getString("Address: ", true);
		Integer FaxNumber = getInteger("FaxNumber : ", true);
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (TypeID != null) updateParameters.put("TypeID", TypeID);
		if (PathID != null) updateParameters.put("PathID", PathID);
		if (Address != null) updateParameters.put("Address", Address);
		if (FaxNumber != null) updateParameters.put("FaxNumber", FaxNumber);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("NotOnline", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("NotOnline", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Department View";
	}		
}
