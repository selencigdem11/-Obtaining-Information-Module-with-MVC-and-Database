import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class AppReportView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch (operationName) {
            case "select":
                return selectOperation(modelData);
            case "update":
                return updateOperation(modelData);
            case "select.gui":
                return selectGUI(modelData);
            case "update.gui":
                return updateGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int OrgID = resultSet.getInt("OrgID");
                int TotalAppCount = resultSet.getInt("TotalAppCount");
                int RejectedAppCount = resultSet.getInt("RejectedAppCount");
                int TopSecretApps = resultSet.getInt("TopSecretApps");
                int AcceptedAppCount = resultSet.getInt("AcceptedAppCount");
                // Display values
                System.out.print(" Organization ID: "+OrgID);
                System.out.print(" Total App Count: "+TotalAppCount);
                System.out.print(" Rejected App Count: "+RejectedAppCount);
                System.out.print(" TopSecret Apps Count: "+TopSecretApps);
                System.out.println(" Accepted App Count: "+AcceptedAppCount);
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

  

    ViewData updateOperation(ModelData modelData) throws Exception {
     	
        System.out.println("Number of updated rows is " + modelData.recordCount);
		
	return new ViewData("MainMenu", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");
        Integer OrgID = getInteger("Organizations ID : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (OrgID != null) {
            whereParameters.put("OrgID", OrgID);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AppReport", "select", parameters);
    }
    
     ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer TotalAppCount = getInteger("Enter Total Application Count : ", true);
        Integer RejectedAppCount = getInteger("Enter Rejected Application Count : ", true);
        Integer TopSecretCount = getInteger("Enter TopSecret Application Count : ", true);
        Integer AcceptedCount = getInteger("Enter Accepted Application Count : ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
	if (TotalAppCount != null) updateParameters.put("TotalAppCount", TotalAppCount);
	if (RejectedAppCount != null) updateParameters.put("RejectedAppCount", RejectedAppCount);
        if (TopSecretCount != null) updateParameters.put("TopSecretApps", TopSecretCount);
        if (AcceptedCount != null) updateParameters.put("AcceptedAppCount", AcceptedCount);
        
        Map<String, Object> parameters = new HashMap<>();      
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("AppReport", "update", parameters);
    }

   

    @Override
    public String toString() {
        return "AppReport View";
    }
}
