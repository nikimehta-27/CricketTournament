package com.tournament.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.tournament.model.Match;
import com.tournament.model.Player;
import com.tournament.model.Score;
import com.tournament.model.Tournament;
import com.tournament.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	@Override
	public void addPlayer(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player createPlayer(int playerId) {
		Player p=new Player() ;
		p.setPlayerId(playerId);
		return p;
	}
	
	@Override
	public int ManOfTheMatch(Match m,List<Score> scores) {
		HashMap<Integer,Integer> scoreForMatch=new HashMap<Integer, Integer>();
		for(Score s: scores)
		 {
			if(s.getMatch().getMatchId()==m.getMatchId() )
			 {
				Integer score =scoreForMatch.get(s.getPlayer().getPlayerId()) ;
				if(score!=null)
				{
					score=score+s.getScore();
					scoreForMatch.put(s.getPlayer().getPlayerId(), score);
				}
			 }
		 }
		
		 int maxValueInMap=(Collections.max(scoreForMatch.values()));  
		 for (Entry<Integer, Integer> entry : scoreForMatch.entrySet()) {  // Itrate through hashmap
	            if (entry.getValue()==maxValueInMap) {
	               return entry.getKey();     // Print the key with max value
	            }
	        }
		return 0;
	}

	@Override
	public Player ManOfTheTournament(Tournament m) {
		// TODO Auto-generated method stub
		return null;
	}

}
