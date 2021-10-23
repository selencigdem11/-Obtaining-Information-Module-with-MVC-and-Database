
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


class EmployeeInfoView implements ViewInterface {

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
		int count=0;
                System.out.println("                                                    Employee Information                                                 ");
                System.out.println("Employee ID   FirstName   MiddleName  LastName    Birthday           EMail             Address       EducationState     StartDay    ManagerID   Authority");
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
                                int EmployeeID = resultSet.getInt("EmployeeID");
                                int ManagerID = resultSet.getInt("ManagerID");
                                Integer Authority = resultSet.getInt("Authority");
                                if(Authority!=0)//Çalışan için yetki kontrolü
                                   count++;
				String FirstName = resultSet.getString("FirstName");
                                String MiddleName = resultSet.getString("MiddleName");
                                String LastName = resultSet.getString("LastName");
                                String Birthday = resultSet.getString("Birthday");
                                String Email = resultSet.getString("Email");
                                String Address = resultSet.getString("Address");
				String EducationState = resultSet.getString("EducationState");
				String StartDay = resultSet.getString("StartDay");
                                
				// Display values
				System.out.print( "\t"+EmployeeID + "\t");
				System.out.print(FirstName + "\t");
				if(MiddleName!= null)System.out.print(MiddleName + "\t");else System.out.print("\t\t");
                                System.out.print(LastName + "\t");
				System.out.print(" "+Birthday + "\t");
				System.out.print(Email + "\t\t");
                                System.out.print(Address + "\t\t");
				System.out.print(EducationState + "\t");
                                System.out.print(StartDay + "\t");
                                System.out.print(ManagerID + "\t   ");
				System.out.println(Authority);
			}
			resultSet.close();	
		}
		if(count==0){//Eğer yetkisi yoksa ana menüye gönderiyoruz
                    System.out.println("You have no authorization to continue");
                    return new ViewData("MainMenu", "");
                }
                else{//Yetki varsa çalışanın işlem menüsü geliyor
                    Integer choice3;
                    String operationName;
                            do {
                                    
                                    System.out.println("\n1. Update Application");//Çalışan başvuruyu değerlendirerek, belirli değerleri update eder
                                    System.out.println("2. Delete Person");//Belirli bir kişiyi silebilir
                                    System.out.println("3. Application Reports");//Başvuru rapor tablosunu görüntüleyebilir
                                    System.out.println("4. Update Payments");//Başvuru ücreti üzerinde değişiklik yapabilir ve buna göre ödenip ödenmedi bilgisi değiştirilir
                                    System.out.println("5. Update Application Report");
                                    System.out.println("6. Quit");
                                    System.out.println();
                               
                                    choice3 = getInteger("Enter your choice : ", false);
                            } 
                            while (choice3 == null || choice3 < 1 || choice3 > 6);
                            
                            switch (choice3.intValue()) {
                                case 1: operationName = "update.gui";   break;
                                case 2: operationName = "delete.gui";	break;
                                case 3: operationName = "select";	break;
                                case 4: operationName = "update.gui";	break;
                                case 5: operationName = "selectApp.gui";	break;
                                default: return new ViewData(null, null);
                            }
                            if (choice3 == 2) {
                                 return new ViewData("PersonInformation", operationName, new HashMap<>());
                            }
                            if (choice3 == 3) {
                                 return new ViewData("AppReport", operationName, new HashMap<>());
                            }
                            if (choice3 == 4) {
                                 return new ViewData("ApplicationPrice", operationName, new HashMap<>());
                            }
                            else 
                                return new ViewData("ApplicationInformation", operationName, new HashMap<>());
     
                }
	}


	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("--- Employee Entry ---:");
		Integer EmployeeID = getInteger("Your Employee ID: ", true);
     
		Map<String, Object> whereParameters = new HashMap<>();
		if (EmployeeID != null) whereParameters.put("EmployeeID", EmployeeID);
       
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("EmployeeInformation", "select", parameters);
	}

	@Override
	public String toString() {
		return "EmployeeInformation View";
	}		
}
