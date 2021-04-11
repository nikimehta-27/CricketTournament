package com.tournament.model;

public class Score {
	
	private int scoreId;
	
	private int score;
	
	private Player  player;
	
	private Team team;
	
	private Match match;

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Score [scoreId=");
		builder.append(scoreId);
		builder.append(", score=");
		builder.append(score);
		builder.append(", player=");
		builder.append(player);
		builder.append(", team=");
		builder.append(team);
		builder.append(", match=");
		builder.append(match);
		builder.append("]");
		return builder.toString();
	}
	
}
