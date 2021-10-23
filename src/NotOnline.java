
public class NotOnline {
        
       
        static private int TypeID;
        private int PathID;
        private String Address;
        private int FaxNumber;

    public NotOnline(int TypeID,int PathID,String Address, int FaxNumber) {
        
        this.TypeID = TypeID;
        this.PathID = PathID;
        this.Address = Address;
        this.FaxNumber = FaxNumber;
         
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public void setFaxNumber(int FaxNumber) {
        this.FaxNumber = FaxNumber;
    }

    public int getFaxNumber() {
        return FaxNumber;
    }

    public void setPathID(int PathID) {
        this.PathID = PathID;
    }

    public int getPathID() {
        return PathID;
    }

    public static void setTypeID(int TypeID) {
        NotOnline.TypeID = TypeID;
    }

    public static int getTypeID() {
        return TypeID;
    }
      
        

        
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "TypeID": return TypeID;
		case "PathID": return PathID;
		case "Address": return Address;
		case "FaxNumber": return FaxNumber;
               
		default: return null;
		}
	}

    @Override
    public String toString() {
        return  TypeID + ", " + PathID + ", " + Address + ", " + FaxNumber ;
    }
   
        
}
