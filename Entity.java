package com.gamingroom;

public class Entity {
	
	//Properties
	private long id;
	private String name;
	
	//Default  Private Constructor 
	private Entity() {
		// TODO Auto-generated constructor stub
	}
	
	//Parameter Constructor 
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Entity[id =" + id + ", name="+ name +"]";
	}

	
	

}
