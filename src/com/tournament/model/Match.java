package com.tournament.model;

public class Match {
	
	private int matchId;
	
	private Team teamA;
	
	private Team teamB; 
	
	private Team winnerTeamForMatch;
	
	private int totalScoreForTeamA;
	
	private int totalScoreForTeamB;
	
	private int wicketCountForTeamA;
	
	private int wicketCountForTeamB;
	
	private int noOfFourForTeamA;
	
	private int noOfFourForTeamB;
	
	private int noOfSixForTeamA;
	
	private int noOfSixForTeamB;

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public Team getWinnerTeamForMatch() {
		return winnerTeamForMatch;
	}

	public void setWinnerTeamForMatch(Team winnerTeamForMatch) {
		this.winnerTeamForMatch = winnerTeamForMatch;
	}

	public int getTotalScoreForTeamA() {
		return totalScoreForTeamA;
	}

	public void setTotalScoreForTeamA(int totalScoreForTeamA) {
		this.totalScoreForTeamA = totalScoreForTeamA;
	}

	public int getTotalScoreForTeamB() {
		return totalScoreForTeamB;
	}

	public void setTotalScoreForTeamB(int totalScoreForTeamB) {
		this.totalScoreForTeamB = totalScoreForTeamB;
	}

	public int getWicketCountForTeamA() {
		return wicketCountForTeamA;
	}

	public void setWicketCountForTeamA(int wicketCountForTeamA) {
		this.wicketCountForTeamA = wicketCountForTeamA;
	}

	public int getWicketCountForTeamB() {
		return wicketCountForTeamB;
	}

	public void setWicketCountForTeamB(int wicketCountForTeamB) {
		this.wicketCountForTeamB = wicketCountForTeamB;
	}

	public int getNoOfFourForTeamA() {
		return noOfFourForTeamA;
	}

	public void setNoOfFourForTeamA(int noOfFourForTeamA) {
		this.noOfFourForTeamA = noOfFourForTeamA;
	}

	public int getNoOfFourForTeamB() {
		return noOfFourForTeamB;
	}

	public void setNoOfFourForTeamB(int noOfFourForTeamB) {
		this.noOfFourForTeamB = noOfFourForTeamB;
	}

	public int getNoOfSixForTeamA() {
		return noOfSixForTeamA;
	}

	public void setNoOfSixForTeamA(int noOfSixForTeamA) {
		this.noOfSixForTeamA = noOfSixForTeamA;
	}

	public int getNoOfSixForTeamB() {
		return noOfSixForTeamB;
	}

	public void setNoOfSixForTeamB(int noOfSixForTeamB) {
		this.noOfSixForTeamB = noOfSixForTeamB;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [matchId=");
		builder.append(matchId);
		builder.append(", teamA=");
		builder.append(teamA);
		builder.append(", teamB=");
		builder.append(teamB);
		builder.append(", winnerTeamForMatch=");
		builder.append(winnerTeamForMatch);
		builder.append(", totalScoreForTeamA=");
		builder.append(totalScoreForTeamA);
		builder.append(", totalScoreForTeamB=");
		builder.append(totalScoreForTeamB);
		builder.append(", wicketCountForTeamA=");
		builder.append(wicketCountForTeamA);
		builder.append(", wicketCountForTeamB=");
		builder.append(wicketCountForTeamB);
		builder.append(", noOfFourForTeamA=");
		builder.append(noOfFourForTeamA);
		builder.append(", noOfFourForTeamB=");
		builder.append(noOfFourForTeamB);
		builder.append(", noOfSixForTeamA=");
		builder.append(noOfSixForTeamA);
		builder.append(", noOfSixForTeamB=");
		builder.append(noOfSixForTeamB);
		builder.append("]");
		return builder.toString();
	}
	
}
