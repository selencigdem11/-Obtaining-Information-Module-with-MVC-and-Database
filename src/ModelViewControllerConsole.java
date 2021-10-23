import java.util.*;


public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {
		// Connect to database
		connectToDatabase();

		
		// Model View Controller (MVC)
		// Router knows all the controllers
		Map<String, Controller> router = new HashMap<>();		
		router.put("MainMenu", new Controller(new ApplierOrEmployeeView(), new NopModel()));
                router.put("ApplicationInformation", new Controller(new ApplicationInfoView(), new ApplicationInfoModel()));
                router.put("Organizations", new Controller(new OrganizationView(), new OrganizationModel()));
                router.put("PersonInformation", new Controller(new PersonInfoView(), new PersonInfoModel()));
                router.put("EmployeeInformation", new Controller(new EmployeeInfoView(), new EmployeeInfoModel()));
                router.put("AppReport", new Controller(new AppReportView(), new AppReportModel()));
                router.put("RejectionReasons", new Controller(new RejectionReasonsView(), new RejectionReasonsModel()));
                router.put("ApplicationPrice", new Controller(new ApplicationPriceView(), new ApplicationPriceModel()));
                router.put("NotOnline", new Controller(new NotOnlineView(), new NotOnlineModel()));
                router.put("Online", new Controller(new OnlineView(), new OnlineModel()));
                
                
		ViewData viewData = new ViewData("MainMenu", "");		
		do {
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
		}
		while (viewData.functionName != null);
		
		System.out.println();
		System.out.println();
		System.out.println("Program is ended...");


		// Disconnect from database
		disconnectFromDatabase();
	}

	
	public static void connectToDatabase() {
		DatabaseUtilities.host = "localhost:64034";     
		DatabaseUtilities.databaseName = "301_Project";	
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
	
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}
	
}
