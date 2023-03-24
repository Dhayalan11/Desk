package javaClasses;

public class History {
   private String historyContent;
   private String time;
   private String id;
public History(String historyContent ,String id) {
	
	this.historyContent = historyContent;
	this.id = id;
}
public History(String historyContent,String time ,String id) {
	
	this.historyContent = historyContent;
	this.time = time;
	this.id = id;
}

public String getHistoryContent() {
	return historyContent;
}
public void setHistoryContent(String historyContent) {
	this.historyContent = historyContent;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
   
}
