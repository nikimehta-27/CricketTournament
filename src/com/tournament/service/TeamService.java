package com.tournament.service;

import java.util.List;

import com.tournament.model.Player;
import com.tournament.model.Team;

public interface TeamService {
	
	public List<Player> getPlayers(Team t);
	
	public int WinningCountForTeam(Team t);
	
	public int LosingCountForTeam(Team t);

	Team createTeam(List<Player> p, int id);

}
