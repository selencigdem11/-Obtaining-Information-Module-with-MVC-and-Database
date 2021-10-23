
public class AppReport {
    
        
        private int OrgID;
        private int EmpID;
        private int TotalAppCount;
        private int AcceptedAppCount;
        private int RejectedAppCount;
        private int TopSecretApps;
        private int ObjectionDemandCount;

    public AppReport(int OrgID, int EmpID, int TotalAppCount, int AcceptedAppCount, int RejectedAppCount, int TopSecretApps, int ObjectionDemandCount) {
        this.OrgID = OrgID;
        this.EmpID = EmpID;
        this.TotalAppCount = TotalAppCount;
        this.AcceptedAppCount = AcceptedAppCount;
        this.RejectedAppCount = RejectedAppCount;
        this.TopSecretApps = TopSecretApps;
        this.ObjectionDemandCount = ObjectionDemandCount;
    }

    public AppReport() {
    }

    public void setOrgID(int OrgID) {
        this.OrgID = OrgID;
    }

    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
    }

    public void setTotalAppCount(int TotalAppCount) {
        this.TotalAppCount = TotalAppCount;
    }

    public void setAcceptedAppCount(int AcceptedAppCount) {
        this.AcceptedAppCount = AcceptedAppCount;
    }

    public void setRejectedAppCount(int RejectedAppCount) {
        this.RejectedAppCount = RejectedAppCount;
    }

    public void setTopSecretApps(int TopSecretApps) {
        this.TopSecretApps = TopSecretApps;
    }

    public void setObjectionDemandCount(int ObjectionDemandCount) {
        this.ObjectionDemandCount = ObjectionDemandCount;
    }

    public int getOrgID() {
        return OrgID;
    }

    public int getEmpID() {
        return EmpID;
    }

    public int getTotalAppCount() {
        return TotalAppCount;
    }

    public int getAcceptedAppCount() {
        return AcceptedAppCount;
    }

    public int getRejectedAppCount() {
        return RejectedAppCount;
    }

    public int getTopSecretApps() {
        return TopSecretApps;
    }

    public int getObjectionDemandCount() {
        return ObjectionDemandCount;
    }
        
        
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "OrgID": return OrgID;
		case "EmpID": return EmpID;
                case "TotalAppCount": return TotalAppCount;
                case "AcceptedAppCount": return AcceptedAppCount;
                case "RejectedAppCount": return RejectedAppCount;
                case "TopSecretApps": return TopSecretApps;
                case "ObjectionDemandCount": return ObjectionDemandCount;
		
		default: return null;
		}
	}
	

    @Override
    public String toString() {
        return "EmployeeID:"+ EmpID ;
    }
    
    
}
