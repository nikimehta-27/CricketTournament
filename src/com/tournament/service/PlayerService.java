package com.tournament.service;

import java.util.List;

import com.tournament.model.Match;
import com.tournament.model.Player;
import com.tournament.model.Score;
import com.tournament.model.Tournament;

public interface PlayerService {
	
	public void addPlayer(Player p);
	public int ManOfTheMatch(Match m,List<Score> scores);
	public Player ManOfTheTournament(Tournament m);
	public Player createPlayer(int playerId);
}
