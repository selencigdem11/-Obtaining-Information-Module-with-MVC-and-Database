import java.util.concurrent.atomic.AtomicInteger;


class PersonInformation {
private static AtomicInteger count = new AtomicInteger(2); 
	private int PersonID;
	private int PersonTypeID;
	private String FirstName;
	//private Date modifiedDate;	
	private String MiddleName;
        private String LastName;
        private String Birthday;
        private long CitizenNumber;
        private long PhoneNumber;
        private int AppID;
        private int AddressTypeId;
        private String Address ;
        private int PhoneTypeId;

public PersonInformation(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
	}
    public PersonInformation(int PersonID, int PersonTypeID, String FirstName, String MiddleName, String LastName, String Birthday, long CitizenNumber, long PhoneNumber, int AppID,int AddressTypeId, String Address, int PhoneTypeId) {
        
        this.PersonID=count.incrementAndGet();
        this.PersonTypeID = PersonTypeID;
        this.FirstName = FirstName;
        this.MiddleName = MiddleName ;
        this.LastName = LastName;
        this.Birthday  = Birthday;
        this.CitizenNumber= CitizenNumber;
        this.PhoneNumber =PhoneNumber;
        this.AppID =AppID;
        this.AddressTypeId =AddressTypeId;
        this.PhoneTypeId =PhoneTypeId;
        this.Address = Address;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public void setPersonTypeID(int PersonTypeID) {
        this.PersonTypeID = PersonTypeID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public void setCitizenNumber(long CitizenNumber) {
        this.CitizenNumber = CitizenNumber;
    }

    public void setPhoneNumber(long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setAppID(int AppID) {
        this.AppID = AppID;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setAdressId(int AdressId) {
        this.AddressTypeId = AdressId;
    }

    public void setPhoneTypeId(int PhoneTypeId) {
        this.PhoneTypeId = PhoneTypeId;
    }

    public int getPersonID() {
        return PersonID;
    }

    public int getPersonTypeID() {
        return PersonTypeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getBirthday() {
        return Birthday;
    }

    public long getCitizenNumber() {
        return CitizenNumber;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public int getAppID() {
        return AppID;
    }

    public int getAdressId() {
        return AddressTypeId;
    }

    public int getPhoneTypeId() {
        return PhoneTypeId;
    }	
	
	public Object getByName(String attributeName) {
        switch (attributeName) {
        case "PersonID": return PersonID;
        case "FirstName": return FirstName;
        case "MiddleName": return MiddleName;
        case "PersonTypeID": return PersonTypeID;
        case "LastName": return LastName;
        case "Birthday": return Birthday;
        case "CitizenNumber": return CitizenNumber;
        case "PhoneNumber": return PhoneNumber;
        case "AppID": return AppID;
        case "AddressTypeId": return AddressTypeId;
        case "PhoneTypeId": return PhoneTypeId;
        case "Address": return Address;
        default: return null;
        }
    }


    @Override
    public String toString() {
        return PersonID + ", " + PersonTypeID + ", " + FirstName + ", " + MiddleName + ", " + LastName + ", " + Birthday + ", " + CitizenNumber + ", " + PhoneNumber + ", " + AppID + ", " + AddressTypeId + ", " + PhoneTypeId + ", " + Address ;
    }
	
}



