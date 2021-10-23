import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Calendar;
import java.util.Date;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ApplicationInfoView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
                case "applierInsert.gui": return insertGUI(modelData);
                case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
                case "selectApp.gui": return selectAppGUI(modelData);
                case "selectApp": return selectApp(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
        //Date tipindeki değeri String tipine çevireceğiz
	static Date date;
        static String pattern = "MM-dd-yyyy";
        
	ViewData selectOperation(ModelData modelData) throws Exception {
            ResultSet resultSet = modelData.resultSet;
            int RejectionID=0;
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int AppID = resultSet.getInt("AppID");
                                int InstitutionID = resultSet.getInt("InstitutionID");
                                RejectionID = resultSet.getInt("RejectionID");
				String ApplicationText = resultSet.getString("ApplicationText");
                                String PathName = resultSet.getString("PathName");
                                int RequestPathID = resultSet.getInt("RequestPathID");
                                String Process = resultSet.getString("Process");
                                int Document = resultSet.getInt("Document");
				String AppLastResponseDate = resultSet.getString("AppLastResponseDate");
				
				// Display values
                                System.out.println("App ID: "+ AppID);
				System.out.println("Application Text : " +ApplicationText);
                                System.out.println("Institution ID: "+InstitutionID);
                                System.out.print("Request Path Type: : ");
                                if(RequestPathID==1)
                                    System.out.println("Online");else System.out.println("Not - Online");
				System.out.println("Path for the Information: " +PathName);
				System.out.println("Process:" + Process);
                                System.out.print("Information Type: ");
                                if(Document==1)
                                    System.out.println("Document");else System.out.println("Information");                                
				System.out.println("App Last Response Date: " +AppLastResponseDate);
                                if(RejectionID!=0){
                                    System.out.println("RejectionID: "+RejectionID);
                                }
				
				pattern = AppLastResponseDate;
			}
			resultSet.close();	
		}
		
		if(RejectionID != 0) //Eğer reddedilme durumu varsa veri tabanından sebebini çekiyoruz
		    return new ViewData("RejectionReasons", "select.gui", new HashMap<>());
                else 
                    return new ViewData("MainMenu", "");
	}
	
        //Raporlama yapacağımızdan gerekli parametrelere sahip ikinci select fonksiyonunu oluşturduk
         ViewData selectApp(ModelData modelData) throws Exception {
            ResultSet resultSet = modelData.resultSet;
            int RejectedAppCount=0;
            int TotalAppCount=0;
            int TopSecretCount=0;
            int AcceptedCount=0;
            
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
                               String ApplicationText = resultSet.getString("ApplicationText");
                               
                               if(!(ApplicationText.equals("NULL")))
                                   TotalAppCount++;
                               
                                int RejectionID = resultSet.getInt("RejectionID");
				if(RejectionID!=0)
                                    RejectedAppCount++;
                                if(RejectionID==2)
                                    TopSecretCount++;
                                
                                String Process = resultSet.getString("Process");
                                if(Process.equals("Done"))
                                    AcceptedCount++;
								
				// Display values
                        }
			resultSet.close();	
                       
		}
                 System.out.println("\nTotal Application is "+TotalAppCount);
                 System.out.println("\nTotal Rejected Application is "+RejectedAppCount);
                 System.out.println("\nTotal TopSecret Application is "+TopSecretCount);
                 System.out.println("\nTotal Accepted Application is "+AcceptedCount);
                 
                 return new ViewData("AppReport", "update.gui", new HashMap<>());
           
	}
        
	ViewData insertOperation(ModelData modelData) throws Exception {
            System.out.println("Number of inserted rows is " + modelData.recordCount);
            //
            return new ViewData("ApplicationPrice", "insert.gui", new HashMap<>());
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
		Integer AppID = getInteger("Application ID : ", true);

		
		Map<String, Object> whereParameters = new HashMap<>();
		if (AppID != null) whereParameters.put("AppID", AppID);
		

		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationInformation", "select", parameters);
	}
        
      
	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
                 List<Object> rows = new ArrayList<>();
                           
                    parameters.put("fieldNames", "AppID,RequestPathID,ApplicationText,InstitutionID,PathName,Process,Document,AppLastResponseDate,RejectionID");

                    String ApplicationText,PathName;
                    int Document, InstitutionID ,RequestPathID;
         
			System.out.println("Your Application Information:");
                        
			ApplicationText = getString("ApplicationText : ", true);
                        
                        RequestPathID = getInteger("(1) Online Request - (2) Not Online Request : ", true);
                        //Kullanıcıdan hangi yol ile başvuru yapmak istediğini soruyoruz 
                        if(RequestPathID==1){
                            System.out.println("Path Names: EMail - Web ");
                            PathName = getString("PathName : ", true);
                        }
                        else {
                            System.out.println("Path Names: Fax - Address ");
                            PathName = getString("PathName : ", true);
                        }
                        
                        Document = getInteger("Information(0) or Document(1) ? : ", true);
                      
                        InstitutionID = getInteger("InstitutionID : ", true);
			System.out.println();
					
			if (ApplicationText != null && PathName != null ) {
                            int temp=0;
                            String tempStr="";
                            ApplicationInformation app=new ApplicationInformation(temp, RequestPathID, ApplicationText, InstitutionID, PathName, tempStr, Document, tempStr, temp);
			    rows.add(app);
                            //Oluşturulan başvurunun id sini bastırıyoruz
                            System.out.println("Your application id is:"+app.getAppID());
                                  
			}
		parameters.put("rows", rows);
		
		return new ViewData("ApplicationInformation", "insert", parameters);
	}   
                
        
	ViewData updateGUI(ModelData modelData) throws Exception {
                //Çalışanın başvuruları değerlendirirken yaptığı değişiklikleri alıyoruz
		System.out.println("Fields to update:");
                String Process = getString("Process Updating(Fail-Done): ", true);
		System.out.println();
                Integer RejectionID = null, InstitutionID= null;
                String AppLastResponseDate= null;
                    //Eğer başvuru reddedildiyse reddedilme nedeni burda seçiliyor    
                    if(Process.equals("Fail")){
                            do
                            {       
                                 RejectionID = getInteger("\n(1)Wrong Organization\n(2)Top Secret\n(3)No Such Information\n(4)No Such Document\n Rejected ID : ", true);
                                 //Eğer yanlış kuruma başvuru yapıldıysa doğru kuruma yönlendiriyoruz
                                if(RejectionID == 1){
                                    InstitutionID = getInteger("\nDirected Organization ID  : ", true);
                                    //Process = "Rejected due to !!Wrong Organization!! and Directed";
                                    
                                    //Yönlendirilen başvurunun son cevap tarihini o günden itibaren 15 gün artırıyoruz    
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                    String currentDate = simpleDateFormat.format(new Date());
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(simpleDateFormat.parse(currentDate));
                                    c.add(Calendar.DAY_OF_MONTH, 15); 
                                    String newDate = simpleDateFormat.format(c.getTime()); 
                                    AppLastResponseDate = newDate;
                                    System.out.println("App Last Response Date After Rejection Date(+15) ----  "+newDate );
                                }
                 
                    }while(RejectionID <1 && RejectionID>4);
                                    
                            }
                    else if(Process.equals("Done")){
                        Process = "!!!DONE!!!";//Başvurunun değerlendirilmesi bitti ise process e done değerini atıyoruz
                    }
		Map<String, Object> updateParameters = new HashMap<>();
		if (Process != null) updateParameters.put("Process", Process);
		if (RejectionID != null) updateParameters.put("RejectionID", RejectionID);
                if (InstitutionID != null) updateParameters.put("InstitutionID", InstitutionID);
                if (AppLastResponseDate != null) updateParameters.put("AppLastResponseDate", AppLastResponseDate);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationInformation", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {//Yetkisi olan çalışanlar silme işlemini gerçekleştirir
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ApplicationInformation", "delete", parameters);
	}
        
        Map<String, Object> getWhereParametersForOrganization() throws Exception {
		System.out.println("Filter conditions:");
		Integer InstitutionID = getInteger("Institution ID : ", true);

		
		Map<String, Object> whereParameters = new HashMap<>();
		if (InstitutionID != null) whereParameters.put("InstitutionID", InstitutionID);
		

		return whereParameters;
	}
        
        ViewData selectAppGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParametersForOrganization());
		
		return new ViewData("ApplicationInformation", "selectApp", parameters);
	}

	@Override
	public String toString() {
		return "ApplicationInformation View";
	}		
}
