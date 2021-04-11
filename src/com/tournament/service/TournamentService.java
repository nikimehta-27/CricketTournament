package com.tournament.service;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Team;
import com.tournament.model.Tournament;

public interface TournamentService {
	
	public List<Match> createMatchListForTournament(Tournament t,List<Team> t1) throws Exception;
	
	public List<Match> getMatchListForTournament(Tournament t);

}
