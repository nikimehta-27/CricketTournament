package com.tournament.service;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Player;
import com.tournament.model.Score;
import com.tournament.model.Team;

public interface ScoreService {
	
	public Score score(Match m,Team t,Player p,int runs) throws Exception;
	
	public Match downWicket(Match m,Team t) throws Exception;
	
	public int getScore(Match m,Team t,List<Score> s); 

}
