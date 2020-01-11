package ie.gmit.sw;

import java.io.Serializable;

public class Club  implements Serializable {

	//Member Variables
    private static final long serialVersionUID = 1L;
    String Clubname;
    String clubID;
    String email;
    String funds;
    
    
    //Constructor
	public Club(String clubname, String clubID, String email, String funds) {
		super();
		Clubname = clubname;
		this.clubID = clubID;
		this.email = email;
		this.funds = funds;
	}
	
	//ToString method
	@Override
	public String toString() {
		return "Club [Clubname=" + Clubname + ", clubID=" + clubID + ", email=" + email + ", funds=" + funds + "]";
	}

	//Getters and Setters
	public String getClubname() {
		return Clubname;
	}
	public void setClubname(String clubname) {
		Clubname = clubname;
	}
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFunds() {
		return funds;
	}
	public void setFunds(String funds) {
		this.funds = funds;
	}
    
 
 
}
