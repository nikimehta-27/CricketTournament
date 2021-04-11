package com.tournament.model;

public class Player {
	
	private int playerId;
	
	private String playerName;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [playerId=");
		builder.append(playerId);
		builder.append(", playerName=");
		builder.append(playerName);
		builder.append("]");
		return builder.toString();
	}

}
