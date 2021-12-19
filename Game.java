package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	// Array list will hold all the existing teams 	
	private static List <Team> teams = new ArrayList<Team>();
	
	/* Parameter constructor that will call the parent class Entity constructor 
	 * The Id and Name will be inherited from the Entity base class*/ 
	public Game(long id, String name) {
		
		super(id,name); // Reference to parent class object 
	}

	/*This will call the methods from the Entity class
	 * And return them in the string */ 
	public String toString()
	{
		
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}
	
	public Team addTeam(String name) {
		
		Team team = null; //Local team instance 
		
		
		Iterator<Team>teamiterator = teams.iterator(); // Create iterator 
		
		/* This will loop through the list and see if there is a name that is already in use
		 * If name is in use the loop will break if not Team name will be added to list */  
		while(teamiterator.hasNext()){
			team = teamiterator.next();
			if(team.getName().equals(name)) {
			break;
			}
		}
		
		team = null;
		
		/*If no team is found and new team to list */
		if(team == null) {
			team = new Team(teams.size()+1,name);
			teams.add(team);
		}
		return team;
	}

}
