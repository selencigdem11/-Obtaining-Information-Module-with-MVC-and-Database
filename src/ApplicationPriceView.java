
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
public class ApplicationPriceView implements ViewInterface{
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
				int AppId = resultSet.getInt("AppId");
				int Price = resultSet.getInt("Price");
				int PaymentCheck = resultSet.getInt("PaymentCheck");
				

                                  System.out.println("Payment Details:\n");
                                  if(PaymentCheck==0){
                                      System.out.println("You have "+Price+" Turkish liras to pay");
                                  }
                                  else
                                      System.out.println("You have no debt");
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
		Integer AppId = getInteger("AppId : ", true);	
		Map<String, Object> whereParameters = new HashMap<>();
		if (AppId != null) whereParameters.put("AppId", AppId);

		return whereParameters;
	}        
        
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationPrice", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "AppId, Price,PaymentCheck");

		List<Object> rows = new ArrayList<>();
		
                Integer AppId,Price,PaymentCheck;
		
                AppId = getInteger("To Complete the Application Enter your AppId: ", true);
			
                Price=0;
                PaymentCheck=1;
					
		if (AppId != null && Price != null &&PaymentCheck != null) {
                    rows.add(new ApplicationPrice(AppId, Price,PaymentCheck));
		}
	
		parameters.put("rows", rows);
		
		return new ViewData("ApplicationPrice", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		//Integer AppId = getInteger("AppId : ", true);
		Integer Price = getInteger("Price : ", true);
                Integer PaymentCheck;
                if(Price==0)
                              PaymentCheck=1;//Ödendiyse check değerimiz 1
                else 
                              PaymentCheck=0;//Ödenmediyse check değerimiz 0
   
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
                if (Price != null) updateParameters.put("Price", Price);
                updateParameters.put("PaymentCheck", PaymentCheck);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationPrice", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationPrice", "delete", parameters);
	}

	@Override
	public String toString() {
		return "ApplicationPrice View";
	}		
    
}
