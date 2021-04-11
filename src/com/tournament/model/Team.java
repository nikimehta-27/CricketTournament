package com.tournament.model;

import java.util.List;

public class Team {
	
	private int teamId;
	
	private List<Player> players;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [teamId=");
		builder.append(teamId);
		builder.append(", players=");
		builder.append(players);
		builder.append("]");
		return builder.toString();
	}
	
	

}
