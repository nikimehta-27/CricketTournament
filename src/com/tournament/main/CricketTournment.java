package com.tournament.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tournament.model.Match;
import com.tournament.model.Player;
import com.tournament.model.Team;
import com.tournament.model.Tournament;
import com.tournament.service.PlayerService;
import com.tournament.service.ScoreService;
import com.tournament.service.TeamService;
import com.tournament.service.TournamentService;
import com.tournament.service.impl.PlayerServiceImpl;
import com.tournament.service.impl.ScoreServiceImpl;
import com.tournament.service.impl.TeamServiceImpl;
import com.tournament.service.impl.TournamentServiceImpl;

public class CricketTournment {


	public static void main(String[] args) throws Exception {
		PlayerService playerService = new PlayerServiceImpl();
		TeamService teamService = new TeamServiceImpl();
		CricketTournment cricketTournment = new CricketTournment();
		TournamentService tournamentService = new TournamentServiceImpl();
		List<Team> teams = new ArrayList<Team>();
		try {
			int noOfTeams=0;	
			int noOfTeamsCounter=0;	
			System.out.println("*****************Welcome to Cricket tournament 2021******************\n");
			BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Enter even number of teams for tournament ->");
			noOfTeams=Integer.parseInt(br.readLine());
			noOfTeamsCounter=noOfTeams;
			int playerId=1;
			int teamId=1;
			if(noOfTeams<=0)
			{
				throw new Exception("Invalid Number of team");
			}
			while(noOfTeamsCounter!=0)
			{
				List<Player> players = new ArrayList<Player>();
				noOfTeamsCounter=noOfTeamsCounter-1;
				for(int i=1;i<=11;i++)
				{
					Player p = playerService.createPlayer(playerId);
					players.add(p);
					playerId=playerId+1;
				}
				Team t=teamService.createTeam(players, teamId);
				teams.add(t);
				teamId=teamId+1;
			}

			Tournament t = new Tournament();
			
			List<Match> matches = tournamentService.createMatchListForTournament(t, teams);
			Map<Integer, Match> matchDetails=new HashMap<Integer, Match>();
			System.out.println("--------Match List for Tournament------\n");
			for(Match m : matches)
			{
				System.out.println("Match-"+m.getMatchId()+" => Team-"+m.getTeamA().getTeamId()+" VS Team-"+m.getTeamB().getTeamId());
				matchDetails.put(m.getMatchId(), m);
			}
			tournamentMatches(matchDetails,br,cricketTournment);
		} catch (NumberFormatException  e) {
			// TODO Auto-generated catch block
			throw new Exception("Invalid Number of team");
		}
	}

	void playMatch(Match currentMatch)
	{
		try {
			ScoreService scoreService = new ScoreServiceImpl();
			BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
			System.out.println("For Team-"+currentMatch.getTeamA().getTeamId()+ " Enter "+currentMatch.getTeamA().getTeamId());
			System.out.println("For Team-"+currentMatch.getTeamB().getTeamId()+ " Enter "+currentMatch.getTeamB().getTeamId());
			int teamIdCurrentlyDoingBatting=Integer.parseInt(br.readLine());
			Team currentTeamBatting=null;
			Team currentTeamBowling=null;
			if(teamIdCurrentlyDoingBatting==currentMatch.getTeamA().getTeamId())
			{
				System.out.println("Team-"+teamIdCurrentlyDoingBatting +" has won the toss and will do batting");
				currentTeamBatting=currentMatch.getTeamA();
				currentTeamBowling=currentMatch.getTeamB();
			}
			else if(teamIdCurrentlyDoingBatting==currentMatch.getTeamB().getTeamId())
			{
				System.out.println("Team-"+teamIdCurrentlyDoingBatting +" has won the toss and will do batting");
				currentTeamBatting=currentMatch.getTeamB();
				currentTeamBowling=currentMatch.getTeamA();
			}
			else
			{
				System.out.println("Please verify and enter correct option ");
			}
			
			if(currentTeamBatting!=null && currentTeamBowling!=null) {
				int scoreTeamA = scoreUpdate(currentTeamBatting,currentMatch,scoreService,br);


				//Batting for opposite team who was bowling starts
				int scoreTeamB = scoreUpdate(currentTeamBowling,currentMatch,scoreService,br);

				//Result of match
				System.out.println("\n-------------------WINNER OF THE MATCH" +currentMatch.getMatchId()+"--------------- ");
				if(scoreTeamA > scoreTeamB) {
					System.out.println("Team "+currentTeamBatting.getTeamId()+" wins the match");
					currentMatch.setWinnerTeamForMatch(currentTeamBatting);
				}else if(scoreTeamA < scoreTeamB) {
					System.out.println("Team "+currentTeamBowling.getTeamId()+" wins the match");
					currentMatch.setWinnerTeamForMatch(currentTeamBowling);
				}else {
					System.out.println("Its a tie between 2 teams");
				}
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int scoreUpdate(Team currentBatting,Match currentMatch,ScoreService  scoreService, BufferedReader br) {
		int score =0;
		int runsForThisBall = 0;
		try {
			System.out.println("--------------------------*Team "+currentBatting.getTeamId()+" Batting Starts"+"*-----------------------------\n");

			System.out.println("Game will be for 20 balls for team "+currentBatting.getTeamId());
			System.out.println("For each ball either you need to enter run or wicket");
			System.out.println("For wicket enter '-1' or else enter run for the ball");
			for(int numOfBall=1;numOfBall<=20;numOfBall++)
			{
				System.out.println("Enter run or wicket for ball " +numOfBall);
				runsForThisBall=Integer.parseInt(br.readLine());
				
				if(runsForThisBall==-1)
				{
					scoreService.downWicket(currentMatch, currentBatting);
				}
				else if((runsForThisBall>=0 && runsForThisBall<=4) || runsForThisBall==6)
				{
					scoreService.score(currentMatch, currentBatting, new Player(), runsForThisBall);
				}
				else
				{
					System.out.println("Please Enter Proper Runs !!!! ");
				}
			}
			
			if(currentBatting.getTeamId()==currentMatch.getTeamA().getTeamId())
			{
				score = currentMatch.getTotalScoreForTeamA();
				System.out.println("Total Score for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getTotalScoreForTeamA());
				System.out.println("Total Wicket for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getWicketCountForTeamA());
				System.out.println("Total 4's for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getNoOfFourForTeamA());
				System.out.println("Total 6's for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getNoOfSixForTeamA());

			}else if(currentBatting.getTeamId()==currentMatch.getTeamB().getTeamId())
			{
				score = currentMatch.getTotalScoreForTeamB();
				System.out.println("Total Score for Team-"+currentBatting.getTeamId()+"-"+currentMatch.getTotalScoreForTeamB());
				System.out.println("Total Wicket for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getWicketCountForTeamB());
				System.out.println("Total 4's for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getNoOfFourForTeamB());
				System.out.println("Total 6's for Team-"+currentBatting.getTeamId()+"--->"+currentMatch.getNoOfSixForTeamB());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
		
	}
	
	static void tournamentMatches(Map<Integer, Match> matchDetails,BufferedReader br,CricketTournment cricketTournment) {

		try {
			System.out.println("-----------------------------------------------------------------\n");
			System.out.println("Select which Match you want to Start =>");
			for(Integer m : matchDetails.keySet())
			{
				System.out.println("For Match-"+m+ " Enter "+m);
			}
			List<Integer> keyOfMatch = matchDetails.keySet().stream().collect(Collectors.toList());

			int matchId=Integer.parseInt(br.readLine());

			if(keyOfMatch.contains(matchId)) {
				System.out.println("Starting Match for Match-"+matchId);
				
				System.out.println("-----------------------------------------------------------------\n");
				System.out.println("Select which team will do Batting first for Match-"+matchId);
				Match currentMatch=matchDetails.get(matchId);
				cricketTournment.playMatch(currentMatch);
				matchDetails.remove(matchId);
				if(matchDetails != null && !matchDetails.isEmpty()) {
					tournamentMatches(matchDetails,br,cricketTournment);
				}
				
			}else {
				System.out.println("Please verify and enter correct option ");
			}
			

		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
