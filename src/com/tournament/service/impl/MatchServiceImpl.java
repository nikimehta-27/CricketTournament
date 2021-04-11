package com.tournament.service.impl;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Team;
import com.tournament.service.MatchService;

public class MatchServiceImpl implements MatchService{

	@Override
	public List<Match> listOfMatchForTeam(Team t) {
		
		return null;
	}

	@Override
	public Team getMatchWinner(Match m) {
		
		return m.getWinnerTeamForMatch();
	}

	@Override
	public Match getMatchTeamDetails(int matchId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Match createMatch(Team a,Team b,int matchid)
	 {
		Match m = new Match();
		m.setMatchId(matchid);
		m.setTeamA(a);
		m.setTeamB(b);
		m.setTotalScoreForTeamA(0);
		m.setTotalScoreForTeamB(0);
		m.setWicketCountForTeamA(0);
		m.setWicketCountForTeamB(0);
		return m;
	 }
	

}
