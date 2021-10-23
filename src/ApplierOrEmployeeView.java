import java.util.HashMap;
import java.util.Map;

public class ApplierOrEmployeeView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

		Integer choice;
		do {
			System.out.println("1. Applier");
			System.out.println("2. Employee");
			System.out.println("3. Quit");
			System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 3);
		
	
                Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: {   
                            Integer choice2;
                            do {
                                    System.out.println("\n1. Old Application"); //Kullanıcı eski başvurusunu görüntüleyecek
                                    System.out.println("2. New Application"); //Kullanıcı önce kayıt yapıp, daha sonra başvuru yapabilecek
                                    System.out.println("3. Payment Check"); //Kullanıcı yaptığı başvuru ücretini görüntüleyecek
                                    System.out.println("4. Quit");
                                    System.out.println();

                                    choice2 = getInteger("Enter your choice : ", false);
                            } 
                            while (choice2 == null || choice2 < 1 || choice2 > 4);
                            
                            switch (choice2.intValue()) {
                                case 1: operationName = "select.gui";   break;
                                case 2: operationName = "applierInsert.gui"; break;
                                case 3: operationName = "select.gui"; break;
                                default: return new ViewData(null, null);
                            }
                            if (choice2 == 2) {
                               return new ViewData("PersonInformation", "insert.gui", new HashMap<>());
                            }
                            if (choice2 == 3) {
                               return new ViewData("ApplicationPrice", "select.gui", new HashMap<>());
                            }
                            else 
                                return new ViewData("ApplicationInformation", operationName, new HashMap<>());
                 
                
                }
                    
                     
		case 2: {
                            
                            operationName = "select.gui"; //Çalışanın veri tabanındaki bilgilerini bastırıyoruz
                                                            //Ayrıca select fonksiyonunda yetki kontrolü yapılacak
                            return new ViewData("EmployeeInformation", operationName, new HashMap<>());
                } 
		default: return new ViewData(null, null);
		}
	}
	@Override
	public String toString() {
		return "ApplierorEmployee View";
	}		
}