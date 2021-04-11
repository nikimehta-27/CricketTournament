package com.tournament.service;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Team;

public interface MatchService {
	
	public List<Match> listOfMatchForTeam(Team t);
	
	public Team getMatchWinner(Match m);
	
	public Match getMatchTeamDetails(int matchId);

	Match createMatch(Team a, Team b, int matchid);

}
