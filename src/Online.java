
public class Online {
        
       
        static private int TypeID;
        private int PathID;
        private String eMail;
        private String WebSiteLink;

    public Online(int TypeID,int PathID,String eMail, String WebSiteLink) {
        
        this.TypeID = TypeID;
        this.PathID = PathID;
        this.eMail = eMail;
        this.WebSiteLink = WebSiteLink;
         
    }

    public void setWebSiteLink(String WebSiteLink) {
        this.WebSiteLink = WebSiteLink;
    }

    public String getWebSiteLink() {
        return WebSiteLink;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

  
    public void setPathID(int PathID) {
        this.PathID = PathID;
    }

    public int getPathID() {
        return PathID;
    }

    public static void setTypeID(int TypeID) {
        Online.TypeID = TypeID;
    }

  
    public static int getTypeID() {
        return TypeID;
    }
      
        

        
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "TypeID": return TypeID;
		case "PathID": return PathID;
		case "WebSiteLink": return WebSiteLink;
		case "eMail": return eMail;
               
		default: return null;
		}
	}

    @Override
    public String toString() {
        return  TypeID + ", " + PathID + ", " + WebSiteLink + ", " + eMail ;
    }
   
        
}
