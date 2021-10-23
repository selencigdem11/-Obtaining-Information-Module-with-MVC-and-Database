
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author selen
 */
public class RejectionReasonsView implements ViewInterface {
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
                    case "select": return selectOperation(modelData);	
		
                    case "select.gui": return selectGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				Integer RejectionId = resultSet.getInt("RejectionId");
				String Reason = resultSet.getString("Reason");				
				
				// Display values
				System.out.print("The Rejection Reason id: " +RejectionId + "\n");
				System.out.print("The Rejection Reason is: " +Reason + "\n");
				
			}
			resultSet.close();	
		}
                return new ViewData("MainMenu", "");
	}
	
	Map<String, Object> getWhereParameters() throws Exception {
		//System.out.println("Filter conditions:");
                System.out.println("Enter Your Rejection Id to See The Rejection Reason");
		Integer RejectionId = getInteger("RejectionId : ", true);
			
		Map<String, Object> whereParameters = new HashMap<>();
		if (RejectionId != null) whereParameters.put("RejectionId", RejectionId);
	
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("RejectionReasons", "select", parameters);
	}

	@Override
	public String toString() {
		return "Department View";
	}		
}
