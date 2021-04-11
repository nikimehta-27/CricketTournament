package com.tournament.service.impl;

import java.util.List;

import com.tournament.model.Player;
import com.tournament.model.Team;
import com.tournament.service.TeamService;

public class TeamServiceImpl implements TeamService{

	@Override
	public List<Player> getPlayers(Team t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team createTeam(List<Player> p,int id) {
		Team t= new Team();
		t.setPlayers(p);
		t.setTeamId(id);
		return t;
	}
	
	@Override
	public int WinningCountForTeam(Team t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int LosingCountForTeam(Team t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
