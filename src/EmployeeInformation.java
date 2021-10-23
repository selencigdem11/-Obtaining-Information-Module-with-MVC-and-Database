
import java.util.Date;


    class EmployeeInformation {
    
        private int EmployeeID;
	private String FirstName;	
	private String MiddleName;
        private String LastName;
        private String Birthday;
        private String Email;
        private String Address;
        private String EducationState;
        private String StartDay;
        private int ManagerID;
        private int Authority;

    public EmployeeInformation(int EmployeeID, String FirstName, String MiddleName, String LastName, String Birthday, String Email, String Address, String EducationState, String StartDay, int ManagerID, int Authority) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.Birthday = Birthday;
        this.Email = Email;
        this.Address = Address;
        this.EducationState = EducationState;
        this.StartDay = StartDay;
        this.ManagerID = ManagerID;
        this.Authority = Authority;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setEducationState(String EducationState) {
        this.EducationState = EducationState;
    }

    public String getEducationState() {
        return EducationState;
    }

    public void setStartDay(String StartDay) {
        this.StartDay = StartDay;
    }

    public String getStartDay() {
        return StartDay;
    }

    public void setManagerID(int ManagerID) {
        this.ManagerID = ManagerID;
    }

    public int getManagerID() {
        return ManagerID;
    }

    public void setAuthority(int Authority) {
        this.Authority = Authority;
    }

    public int getAuthority() {
        return Authority;
    }
 
        
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "EmployeeID": return EmployeeID;
		case "FirstName": return FirstName;
                case "MiddleName": return MiddleName;
                case "LastName": return LastName;
                case "Birthday": return Birthday;
                case "Email": return Email;
                case "Address": return Address;
                case "EducationState": return EducationState;
                case "StartDay": return StartDay;
                case "ManagerID": return ManagerID;
                case "Authority": return Authority;

		default: return null;
		}
	}

    @Override
    public String toString() {
        return   EmployeeID  + ", " +
                FirstName + ", " + MiddleName + ", " +
                LastName + ", " + Birthday + ", " + Email 
                + ", " + EducationState + ", "  + Address + ", " + StartDay +
                ", " + ManagerID + ", " + Authority ;
    }
    
        
        
        
}