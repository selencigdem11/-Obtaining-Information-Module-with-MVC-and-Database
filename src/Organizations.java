

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elessar
 */
public class Organizations {

    private int OrganizationID;
    private String OrganizationName;
    private int RelatedOrgID ;
    private int OrgTypeID ;
    private String Address ;
    private String eMail ;
    private int PhoneNumber ;
    //private Date EstablishDate ;
     String  EstablishDate ;
    private String PresidentName ;

    public Organizations(int OrganizationID, String OrganizationName, int RelatedOrgID, int OrgTypeID, String Address, String eMail, int PhoneNumber, String EstablishDate, String PresidentName) {
        this.OrganizationID = OrganizationID;
        this.OrganizationName = OrganizationName;
        this.RelatedOrgID = RelatedOrgID;
        this.OrgTypeID = OrgTypeID;
        this.Address = Address;
        this.eMail = eMail;
        this.PhoneNumber = PhoneNumber;
        String pattern = "MM-dd-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.EstablishDate = simpleDateFormat.format(new Date());
        this.PresidentName = PresidentName;
    }

    public int getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(int OrganizationID) {
        this.OrganizationID = OrganizationID;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String OrganizationName) {
        this.OrganizationName = OrganizationName;
    }

    public int getRelatedOrgID() {
        return RelatedOrgID;
    }

    public void setRelatedOrgID(int RelatedOrgID) {
        this.RelatedOrgID = RelatedOrgID;
    }

    public int getOrgTypeID() {
        return OrgTypeID;
    }

    public void setOrgTypeID(int OrgTypeID) {
        this.OrgTypeID = OrgTypeID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEstablishDate() {
        return EstablishDate;
    }

    public void setEstablishDate(String EstablishDate) {
        this.EstablishDate = EstablishDate;
    }

    public String getPresidentName() {
        return PresidentName;
    }

    public void setPresidentName(String PresidentName) {
        this.PresidentName = PresidentName;
    }
  
   
    
    
    public Object getByName(String attributeName) {
		switch (attributeName) {
		case "OrganizationID": return OrganizationID;
		case "OrganizationName": return OrganizationName;
		case "RelatedOrgID": return RelatedOrgID;
		case "OrgTypeID": return OrgTypeID;
                case "Address": return Address;
                case "eMail": return eMail;
                case "PhoneNumber": return PhoneNumber;
                case "EstablishDate": return EstablishDate;
                case "PresidentName": return PresidentName;
		default: return null;
		}
	}
	
    

    @Override
    public String toString() {
        return "Organizations{" + "OrganizationID=" + OrganizationID + ", OrganizationName=" + OrganizationName + ", RelatedOrgID=" + RelatedOrgID + ", OrgTypeID=" + OrgTypeID + ", Address=" + Address + ", eMail=" + eMail + ", PhoneNumber=" + PhoneNumber + ", EstablishDate=" + EstablishDate + ", PresidentName=" + PresidentName + '}';
    }
    
    
    
    
    
    
    
    
    
}
