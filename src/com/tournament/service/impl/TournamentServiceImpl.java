package com.tournament.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Team;
import com.tournament.model.Tournament;
import com.tournament.service.MatchService;
import com.tournament.service.TournamentService;

public class TournamentServiceImpl implements TournamentService{

	@Override
	public List<Match> createMatchListForTournament(Tournament t, List<Team> t1) throws Exception {
		int MatchId=0 ;
		List<Match> matches = new ArrayList<Match>();
		if(t1.size()%2!=0)
		 {
			throw new Exception("No of Teams should be even.") ;
		 }
		else
		{
			for(int i=0;i<t1.size();i+=2)
			{
				MatchId=MatchId+1;
				MatchService m = new MatchServiceImpl();
				Match mm=m.createMatch(t1.get(i), t1.get(i+1), MatchId);
				matches.add(mm);
			}
		}
		return matches;
	}

	@Override
	public List<Match> getMatchListForTournament(Tournament t) {
		// TODO Auto-generated method stub
		return null;
	}

}
