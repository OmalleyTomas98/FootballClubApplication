package ie.gmit.sw;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Agent implements Serializable {

	// Member Variables
	private static final long serialVersionUID = 1L;
	public String AgentName;
	public String AgentID;
	public String Agentemail;

	// A list of all registeredAgents

	private List<Agent> registeredAgents = Collections.synchronizedList(new LinkedList<Agent>());

	// A list of all users that are currently logged in
	private List<Agent> loggedInAgents = Collections.synchronizedList(new LinkedList<Agent>());

	// ToString Method
	@Override
	public String toString() {
		return "Agent [AgentName=" + AgentName + ", AgentID=" + AgentID + ", Agentemail=" + Agentemail + "]";
	}

	// Constructor
	public Agent(String agentName, String agentID, String agentemail) {

		super();

		AgentName = agentName;
		AgentID = agentID;
		Agentemail = agentemail;
	}

	// Getters and Setters
	public String getAgentName() {
		return AgentName;
	}

	public void setAgentName(String agentName) {
		AgentName = agentName;
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

	public String getAgentemail() {
		return Agentemail;
	}

	public void setAgentemail(String agentemail) {
		Agentemail = agentemail;
	}

	public void registerUser(Agent agentToRegister) {
		registeredAgents.add(agentToRegister);
	}

	// Return true if the user is in the collection of registered users
	public boolean isAgentRegistered(Agent agentToCheck) {
		// This is also an O(n) operation which might cause performance problems when
		// there are many registered users
		return registeredAgents.contains(agentToCheck);
	}

	public Agent loginAgent(Agent agentToLogin) throws Exception {
		Agent agent = null;
		boolean isSuccessful = false;
		int registeredIndex = registeredAgents.indexOf(agentToLogin);
		int loggedInIndex = loggedInAgents.indexOf(agentToLogin);

		if (registeredIndex == -1) { // If not registered
			throw new Exception("The credentials you entered do not match any registered account!");
		} else if (loggedInIndex != -1) { // If logged in
			throw new Exception("You are already logged in!");
		} else { // Check if credentials match a registered account
			isSuccessful = registeredAgents.get(registeredIndex).getAgentName().equals(agentToLogin.getAgentName())
					&& registeredAgents.get(registeredIndex).getAgentID().equals(agentToLogin.getAgentID());
		}

		// Check if the login was successful
		if (isSuccessful) {
			agent = registeredAgents.get(registeredIndex);
			loggedInAgents.add(agent);
		}

		return agent;
	}

	// Remove the user from the collection of logged in users
	public void logoutAgent(Agent agentToLogout) {
		loggedInAgents.remove(agentToLogout);
	}
}
