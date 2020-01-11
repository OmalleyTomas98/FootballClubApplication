package ie.gmit.sw;

import java.io.Serializable;

public class Player  implements Serializable{
	
	//Member Variables
	private static final long serialVersionUID = 1L;
	String Playername;
	String PlayerAge;
	String PlayerID;
	String AgentID;
	String Valuation;
	String PlayerStatus;
	String Position;
	
	
	
	//Constructor 
	public Player(String playername, String playerAge, String playerID, String agentID, String valuation,
			String playerStatus, String position) {
		super();
		Playername = playername;
		PlayerAge = playerAge;
		PlayerID = playerID;
		AgentID = agentID;
		Valuation = valuation;
		PlayerStatus = playerStatus;
		Position = position;
	}

	//ToString method
	@Override
	public String toString() {
		return "Player [Playername=" + Playername + ", PlayerAge=" + PlayerAge + ", PlayerID=" + PlayerID + ", AgentID="
				+ AgentID + ", Valuation=" + Valuation + ", PlayerStatus=" + PlayerStatus + ", Position=" + Position
				+ "]";
	}
	
	//Getters and Setters
	public String getPlayername() {
		return Playername;
	}
	public void setPlayername(String playername) {
		Playername = playername;
	}
	
	public String getPlayerAge() {
		return PlayerAge;
	}
	public void setPlayerAge(String playerAge) {
		PlayerAge = playerAge;
	}
	public String getPlayerID() {
		return PlayerID;
	}
	public void setPlayerID(String playerID) {
		PlayerID = playerID;
	}
	public String getAgentID() {
		return AgentID;
	}
	public void setAgentID(String agentID) {
		AgentID = agentID;
	}
	public String getValuation() {
		return Valuation;
	}
	public void setValuation(String valuation) {
		Valuation = valuation;
	}
	public String getPlayerStatus() {
		return PlayerStatus;
	}
	public void setPlayerStatus(String playerStatus) {
		PlayerStatus = playerStatus;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
}
