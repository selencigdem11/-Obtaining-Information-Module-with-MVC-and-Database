import com.microsoft.sqlserver.jdbc.StringUtils;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PersonInfoView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);
                case "delete": return deleteOperation(modelData);
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int PersonID = resultSet.getInt("PersonID");
                                int PersonTypeID = resultSet.getInt("PersonTypeID");
                                int CitizenNumber = resultSet.getInt("CitizenNumber");
                                int PhoneNumber = resultSet.getInt("PhoneNumber");
                                int departmentID = resultSet.getInt("PersonID");
                                int AppID = resultSet.getInt("AppID");
                                int AdressId = resultSet.getInt("AdressId");
                                int PhoneTypeId = resultSet.getInt("PhoneTypeId");
                                String FirstName = resultSet.getString("FirstName");
                                 String MiddleName = resultSet.getString("MiddleName");
                                String LastName = resultSet.getString("LastName");
                                String Address = resultSet.getString("Address");
				String Birthday = resultSet.getString("Birthday");
                                
				
				// Display values
				System.out.print(PersonID + "\t");
				System.out.print(PersonTypeID + "\t");
				System.out.print(FirstName + "\t");
                                if(MiddleName!=null){
                                    System.out.print(MiddleName + "\t"); }
				System.out.print(LastName + "\t");
				System.out.print(Birthday + "\t");
                                System.out.print(CitizenNumber + "\t");
				System.out.print(PhoneNumber + "\t");
				System.out.print(AppID + "\t");
                                System.out.print(AdressId + "\t");
				System.out.println(PhoneTypeId);
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		//Kişi kayıt edildikten sonra hangi kuruma başvuru yapacağını görmesi için kurum listesini bastırıyoruz
                return new ViewData("Organizations", "select",new HashMap<>());
	}

	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	
        
	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer PersonID = getInteger("PersonID : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (PersonID != null) whereParameters.put("PersonID", PersonID);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("PersonInformation", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", " PersonID, PersonTypeID, FirstName, MiddleName,LastName,Birthday,CitizenNumber,PhoneNumber,AppID,AddressTypeId,Address,PhoneTypeId");

		List<Object> rows = new ArrayList<>();
		String FirstName=null, MiddleName=null,LastName=null,Address=null;
                Integer  PersonTypeID=null,AdressId=null,PhoneTypeId=null;
                String tempCitizenNumber = null,tempPhoneNumber=null;
                String Birthday=null;
                Long CitizenNumber=null,PhoneNumber=null;//verilerin doğru uzunlukta girilmesini kontrol etmek için long tipini tercih ettik
		int count=0;
		do
		{       
                        count=0; //eğer istenmeyen tipte değer girilirse count artıyor ve while en baştan döndürülüyor
                        System.out.println("Please enter all required applier information:");
                        System.out.println("----------------------------------------------");
                        PersonTypeID = getInteger("PersonTypeID (1 for Legal Persons - 2 for Turkish - 3 for Foreign)  : ", true);
                        if(!(PersonTypeID==1 || PersonTypeID==2 || PersonTypeID ==3))
                        {
                            System.out.println("Please enter valid person type id ");
                            count++;
                            continue;
                        }
                        FirstName = getString("FirstName : ", true);
                         if(FirstName==null){
                            count++;
                            System.out.println("Enter your name to continue ");
                            continue;
                        }
                        MiddleName = getString("MiddleName : ", true);
                        if(MiddleName==null){
                             MiddleName="NULL";  //nullable bir değer olduğundan boş geçilirse NULL atıyoruz
                        }
                        LastName = getString("LastName : ", true);
                        if(LastName==null){
                            count++;
                            System.out.println("Enter your last name to continue ");
                            continue;
                        }
                        Birthday = getString("Birthday(Please enter date in dd-MM-yyyy format) : ", true);
                           if(Birthday==null){
                            count++;
                            System.out.println("Enter your birthday to continue ");
                            continue;
                        }
                          
                        if(PersonTypeID!=3){ //eğer FOREIGN bir kişi girdiyse CitizenNumber ı sormuyoruz ve default bir değer atıyoruz
                            tempCitizenNumber = getString("Citizen Number (11) : ", true);
                            if(tempCitizenNumber!=null){
                                  if(tempCitizenNumber.length()==11 &&StringUtils.isNumeric(tempCitizenNumber))//11 Haneli girilmesini kontrol ediyoruz
                                       CitizenNumber=Long.parseLong(tempCitizenNumber); 
                                    else{
                                        count++;
                                        System.out.println("Please enter valid Citizen number IT MUST BE 11 DIGITS");
                                        continue;
                                 }
                            }
                            else {
                                count++;
                                continue;
                            }
                       }
                        else
                        {
                            tempCitizenNumber="11111111111"; // Default tc for foreigns
                             CitizenNumber=Long.parseLong(tempCitizenNumber);
                        }
                        tempPhoneNumber = getString("PhoneNumber (10): ", true);
                        if(tempPhoneNumber!=null){
                              if(tempPhoneNumber.length()==10 && StringUtils.isNumeric(tempPhoneNumber))//10 haneli bir sayı girilmesini kontrol ediyoruz
                                  PhoneNumber=Long.parseLong(tempPhoneNumber);  
                              else{
                                   count++;
                                   System.out.println("Please enter valid phone number IT MUST BE 10 DIGITS");
                                   continue;
                             }
                         }
                        else{
                            System.out.println("Please enter valid phone number IT MUST BE 10 DIGITS");
                            count++;
                            continue;
                            
                        }
                        
                       AdressId = getInteger("AdressId (1 for Home - 2 for Work Place) : ", true);
                        if(!(AdressId==1 || AdressId==2))
                        {
                            System.out.println("Please enter valid adress id ");
                            count++;
                            continue;
                        }
                        
                        Address = getString("Address : ", true);
                        if(Address==null)
                        {
                            System.out.println("\nPlease enter valid adress ");
                            count++;
                            continue;
                        }
                        PhoneTypeId = getInteger("PhoneTypeId (1 for Mobile - 2 for Home) : ", true);
                         if(!(PhoneTypeId==1 || PhoneTypeId==2))
                        {
                            System.out.println("Please enter valid phone typeId id ");
                            count++;
                        }
                       
                }while(count!=0);	
					
		int temp=1;
                PersonInformation PerInfo=new PersonInformation(temp, PersonTypeID, FirstName, MiddleName, LastName, Birthday, CitizenNumber, PhoneNumber,temp, AdressId,Address,PhoneTypeId);
		rows.add(PerInfo);
                //kişi insert edildiğinde kullanıcıya id sini bastırıyoruz
                System.out.println("Your Person id is:"+PerInfo.getPersonID());
			
		parameters.put("rows", rows);
		
		return new ViewData("PersonInformation", "insert", parameters);
		
	}
        
        ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("PersonInformation", "delete", parameters);
	}
        
	@Override
	public String toString() {
		return "PersonInformation View";
	}		
}
