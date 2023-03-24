package javaClasses;

public class Description {
      private String name;
      private String desp;
      private String time;
      private String who;
	public Description(String name, String desp, String time,String who) {
	
		this.name = name;
		this.desp = desp;
		this.time = time;
		this.who = who;
	}
	
	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
      
}
