package com.tournament.service.impl;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Player;
import com.tournament.model.Score;
import com.tournament.model.Team;
import com.tournament.service.ScoreService;

public class ScoreServiceImpl implements ScoreService {

	@Override
	public Score score(Match m, Team t, Player p, int runs) throws Exception {
		if(runs<0 || runs>6)
		 {
			throw new Exception("Score is invalid .");
		 }
		else
		 {
			if(runs==4 && t.getTeamId()==m.getTeamA().getTeamId())
			{
				m.setNoOfFourForTeamA(m.getNoOfFourForTeamA()+1);
			}
			else if (runs==6 && t.getTeamId()==m.getTeamA().getTeamId())
			{
				m.setNoOfSixForTeamA(m.getNoOfSixForTeamA()+1);
			}
			else if (runs==4 && t.getTeamId()==m.getTeamB().getTeamId())
			{
				m.setNoOfFourForTeamB(m.getNoOfFourForTeamB()+1);
			}
			else if (runs==6 && t.getTeamId()==m.getTeamB().getTeamId())
			{
				m.setNoOfSixForTeamB(m.getNoOfSixForTeamB()+1);
			}
			
			
			if(t.getTeamId()==m.getTeamA().getTeamId())
			{
				m.setTotalScoreForTeamA(m.getTotalScoreForTeamA()+runs);
			}
			else 
			{
				m.setTotalScoreForTeamB(m.getTotalScoreForTeamB()+runs);
			}
			Score r = new Score();
			r.setMatch(m);
			r.setPlayer(p);
			r.setTeam(t);
			r.setScore(runs);
			return r;
		 }
		
	}

	@Override
	public Match downWicket(Match m, Team t) throws Exception {
	if(m.getTeamA().getTeamId()==t.getTeamId() && m.getWicketCountForTeamA()<10)
	{
		m.setWicketCountForTeamA(m.getWicketCountForTeamA()+1);
		return m;
		
	}
	else if(m.getTeamA().getTeamId()==t.getTeamId() && m.getWicketCountForTeamA()==10)
	{
		throw new Exception("Wicket Count is already 10");
		
	}	
	else if(m.getTeamB().getTeamId()==t.getTeamId() && m.getWicketCountForTeamB()==10)
	{
		throw new Exception("Wicket Count is already 10");
		
	}
	else if(m.getTeamB().getTeamId()==t.getTeamId() && m.getWicketCountForTeamB()<10)
	{
		m.setWicketCountForTeamB(m.getWicketCountForTeamB()+1);
		return m;
		
	}
		return null;
		
	}

	@Override
	public int getScore(Match m, Team t,List<Score> scores) {
		int totalRuns=0;
		
		for(Score s: scores)
		 {
			if(s.getMatch().getMatchId()==m.getMatchId() && s.getTeam().getTeamId()==t.getTeamId())
			 {
				totalRuns=totalRuns+s.getScore();
			 }
		 }
			
		return totalRuns;
	}

}
