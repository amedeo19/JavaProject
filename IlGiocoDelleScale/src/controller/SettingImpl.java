package controller;

import model.data.Data;

public class SettingImpl implements Setting {

	private final int NumPlayers;
	private int turn;
	private final static int Start=0;
	
	public SettingImpl(final int NumPlayers) {
		this.NumPlayers = NumPlayers;
		this.turn=Start;
	}
	
	@Override
	public int getNumPlayers() {
		return this.NumPlayers;
	}
	
	@Override
	public void moveTurn() {
		this.turn=this.turn++;
		this.turn=(this.turn % this.NumPlayers);
	}


	@Override
	public int getTurn() {
		return this.turn;
	}
	
}
