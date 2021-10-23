
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;


public class ApplicationInformation {
        
        private static AtomicInteger count = new AtomicInteger(2); 
        static private int AppID;
        private int RequestPathID=0;
        private String ApplicationText;
        private int InstitutionID;
        private String PathName;
        private String Process="Begin";
        private int Document;
        private String AppLastResponseDate;
        private Integer RejectionID;

    public ApplicationInformation(int AppID, int RequestPathID, String ApplicationText, int InstitutionID, String PathName, String Process, int Document, String AppLastResponseDate, Integer RejectionID) throws ParseException {
        this.AppID=count.incrementAndGet();
        this.RequestPathID = 1;
        this.ApplicationText = ApplicationText;
        this.InstitutionID = InstitutionID;
        this.PathName = PathName;
        this.Process = "Begin";
        this.Document = Document;
         String pattern = "MM-dd-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         String currentDate = simpleDateFormat.format(new Date());
         Calendar c = Calendar.getInstance();
	 c.setTime(simpleDateFormat.parse(currentDate));
	   
	//Number of Days to add
	c.add(Calendar.DAY_OF_MONTH, 15);  
	//Date after adding the days to the given date
	String newDate = simpleDateFormat.format(c.getTime());  
        
    this.AppLastResponseDate = newDate;
        this.RejectionID = 0;
    }

    public void setAppID(int AppID) {
        this.AppID = AppID;
    }

    public int getAppID() {
        return AppID;
    }

    public void setRequestPathID(int RequestPathID) {
        this.RequestPathID = RequestPathID;
    }

    public int getRequestPathID() {
        return RequestPathID;
    }

    public void setApplicationText(String ApplicationText) {
        this.ApplicationText = ApplicationText;
    }

    public String getApplicationText() {
        return ApplicationText;
    }

    public void setInstitutionID(int InstitutionID) {
        this.InstitutionID = InstitutionID;
    }

    public int getInstitutionID() {
        return InstitutionID;
    }

    public void setPathName(String PathName) {
        this.PathName = PathName;
    }

    public String getPathName() {
        return PathName;
    }

    public void setProcess(String Process) {
        this.Process = Process;
    }

    public String getProcess() {
        return Process;
    }

    public void setDocument(int Document) {
        this.Document = Document;
    }

    public void setAppLastResponseDate(String AppLastResponseDate) {
        this.AppLastResponseDate = AppLastResponseDate;
    }

    public String getAppLastResponseDate() {
        return AppLastResponseDate;
    }

    public void setRejectionID(Integer RejectionID) {
        this.RejectionID = RejectionID;
    }

    public Integer getRejectionID() {
        return RejectionID;
    }
        
        
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "AppID": return AppID;
		case "ApplicationText": return ApplicationText;
		case "RequestPathID": return RequestPathID;
		case "InstitutionID": return InstitutionID;
                case "PathName": return PathName;
                case "Process": return Process;
                case "Document": return Document;
                 case "AppLastResponseDate": return AppLastResponseDate;
                case "RejectionID": return RejectionID;
		default: return null;
		}
	}

    @Override
    public String toString() {
        return  RequestPathID + ", " + ApplicationText + ", " + InstitutionID + ", " + PathName + ", " + Process + ", " + Document + ", " + AppLastResponseDate + ", " + RejectionID;
    }
   
        
}
