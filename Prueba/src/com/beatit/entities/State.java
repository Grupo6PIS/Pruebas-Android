package com.beatit.entities;

import com.beatit.datatypes.DTDateTime;
import com.beatit.datatypes.TState;

public class State {
	
	private TState state;
	private Integer score;
	private DTDateTime dateTimeStart;
	
	public State(){
		
	}
	
	public TState getState() {
		return state;
	}
	public void setState(TState state) {
		this.state = state;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public DTDateTime getDateTimeStart() {
		return dateTimeStart;
	}
	public void setDateTimeStart(DTDateTime dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}
	
	

}
