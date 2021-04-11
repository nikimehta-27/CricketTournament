package com.tournament.model;

import java.util.List;

public class Tournament {
	
	private int tournamentId;
	private List<Match> matches;
	private Team winnerTeamForTournament;
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	public Team getWinnerTeamForTournament() {
		return winnerTeamForTournament;
	}
	public void setWinnerTeamForTournament(Team winnerTeamForTournament) {
		this.winnerTeamForTournament = winnerTeamForTournament;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tournament [tournamentId=");
		builder.append(tournamentId);
		builder.append(", matches=");
		builder.append(matches);
		builder.append(", winnerTeamForTournament=");
		builder.append(winnerTeamForTournament);
		builder.append("]");
		return builder.toString();
	} 
	

}
