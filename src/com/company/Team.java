package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team<T extends Sport> {
    private String teamName;
    private List<Player<T>> players;
    private Map<String, Integer> results;
    private final double baseElo = 1000;
    private double elo;
    public Team(String teamName) {
        this.teamName = teamName;
        this.elo = baseElo;
        this.results = new HashMap<>();
        this.results.put("Wins", 0);
        this.results.put("Loses", 0);
        this.results.put("Ties", 0);
        this.results.put("Played", 0);
        this.players = new ArrayList<>();
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player<T>> getPlayers() {
        return players;
    }

    public double getElo() {
        return elo;
    }

    public boolean addPlayer(Player<T> player) {
        if(player == null || this.players.contains(player)) {
            return false;
        } else {
            this.players.add(player);
            return true;
        }
    }

    public boolean updateRanking() {
        int wins = this.getResults().get("Wins");
        int loses = this.getResults().get("Loses");
        int ties = this.getResults().get("Ties");
        int played = this.getResults().get("Played");

        double updated = (this.baseElo * 0.025) + ((((wins * 0.5) + 10 - (ties * 0.2)) / (loses * 0.6 + 1)) / played);
        this.elo += updated;
        return true;
    }

    public void teamMembers() {
        for(Player x : this.players) {
            System.out.println(x.getName());
        }
    }
}

