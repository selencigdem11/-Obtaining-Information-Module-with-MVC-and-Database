


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elessar
 */
public class RejectionReasons {
    private int RejectionId ;
    private String Reason ;

    public RejectionReasons(int RejectionId, String Reason) {
        this.RejectionId = RejectionId;
        this.Reason = Reason;
    }

    public int getRejectionId() {
        return RejectionId;
    }

    public void setRejectionId(int RejectionId) {
        this.RejectionId = RejectionId;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    
    
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "RejectionId": return RejectionId;
		case "Reason": return Reason;
		
		default: return null;
		}
	}
	
    

    @Override
    public String toString() {
        return "RejectionReasons{" + "RejectionId=" + RejectionId + ", Reason=" + Reason + '}';
    }
    
    
    
    
    
}
