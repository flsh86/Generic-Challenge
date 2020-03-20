package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class League<T extends Team> implements Comparator<T> {
    private String leagueName;
    private List<T> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    public boolean addTeamToLeague(T team) {
        if(team == null || this.teams.contains(team) || team.getPlayers().isEmpty()) {
            return false;
        } else {
            this.teams.add(team);
            return true;
        }
    }

    public void setTeams(List<T> teams) {
        this.teams = teams;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public List<T> getTeams() {
        return teams;
    }

    public void teams() {
        for(T x: this.teams) {
            System.out.println(x.getTeamName());
        }
    }

    public boolean match(T team1, T team2, int score1, int score2) {
        boolean areTeamsInLeague = (this.teams.contains(team1) && this.teams.contains(team2));
        boolean areNulls = (team1 == null && team2 == null);
        boolean isScoreValid = (score1 >= 0 && score2 >= 0);
        if(areNulls || !areTeamsInLeague || !isScoreValid) {
            System.out.println("Something went wrong");
            return false;
        } else {
            Map<String, Integer> results1 = team1.getResults();
            Map<String, Integer> results2 = team2.getResults();
            results1.put("Played", results1.get("Played") + 1);
            results2.put("Played", results2.get("Played") + 1);
            if(score1 > score2) {
                results1.put("Wins", results1.get("Wins") + 1);
                results2.put("Loses", results2.get("Loses") + 1);
            } else if(score1 < score2) {
                results1.put("Loses", results1.get("Loses") + 1);
                results2.put("Wins", results2.get("Wins") + 1);
            } else {
                results1.put("Ties", results1.get("Ties") + 1);
                results2.put("Ties", results2.get("Ties") + 1);
            }
            team1.updateRanking();
            team2.updateRanking();
            return true;
        }
    }

    public double getRanking(T team) {
        return team.getElo();
    }

    private boolean sortTable() {
        if(this.teams.isEmpty()) {
            return false;
        } else {
            this.teams.sort(this::compare);
            return true;
        }
    }

    public void results(){
        int i = 0;
        for(T x: this.teams){
            System.out.println(++i + ". " + x.getElo());
        }
    }

    @Override
    public int compare(T o1, T o2) {
        return ((Double) o1.getElo()).compareTo(o2.getElo());
    }

}
