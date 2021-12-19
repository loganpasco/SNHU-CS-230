package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator; //import iterator tool to help with traversing the data.
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/* Making a class a singleton 
	 * This will ensure that only one instance of the GameService class will exist 
	 * Create an object of GamerService.*/

	private static GameService instance = new GameService();
	
	//This is a private constructor so the class cannot be instantiated 
	
	private GameService() {}
	
	//Get the only object available 
	
	public static GameService getInstance() {
		return instance;
		}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		Iterator<Game>gamesIterator = games.iterator(); // create iterator
		
		/*This while loop will go through the game list to check if an entry exist
		 * If game variable has the same name of the new game the loop will exit and 
		 * return existing game if it does not it will set game to null and add new game to list
		 */
		
		while(gamesIterator.hasNext()) {
			game = gamesIterator.next();
			if (game.getName().equals((name))) {
				break;
			}
			game = null;
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		Iterator<Game>gamesIterator= games.iterator(); // create iterator 
		
		/* Set the game variable with the next game in the iterator 
		 * by checking to see if the game has a matching ID if so return to game 
		 * else return null
		 */
		
		while(gamesIterator.hasNext()) {
			game = gamesIterator.next();
			if(game.getId() == id)
				return game;
		}
		
		return null;
}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
		Iterator<Game>gamesIterator = games.iterator(); // Create iterator
		
		/* This will see if the game has a matching name 
		 * if one exists this will return to existing game 
		 * else return null
		 */
		
		while(games.iterator().hasNext()) {
			game = gamesIterator.next();
			if(game.getName().equals(name))
				return game;
		}
		
		return null;
				
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
