package javaClasses;

import CircularLinkedLIst.CreateCircularLinkedList;

public class Department {
	String name;
	String description;
	CreateCircularLinkedList agents =  new CreateCircularLinkedList();
	public Department(String name, String description) {
		
		this.name = name;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", description=" + description + ", agents=" + agents + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CreateCircularLinkedList getAgents() {
		return agents;
	}
	public void setAgents(CreateCircularLinkedList agents) {
		this.agents = agents;
	}
	
	
}
