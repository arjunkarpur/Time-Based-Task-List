package com.appsysstudios.timebasedtasklist;

public class Task {
	
	String taskName;
	int taskTime;
	
	public Task(){
	}
	
	public Task(String taskName, int taskTime){
	    this.taskName = taskName;
	    this.taskTime = taskTime;
	}
	
	public String getTaskName() {
		return this.taskName;
	}
	
	public int getTaskTime() {
		return this.taskTime;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
	}
}
