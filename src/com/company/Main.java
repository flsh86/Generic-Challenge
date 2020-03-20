package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //Football players
        Player<Football> lionelMessi = new Player<>("Messi", 33);
        Player<Football> benzema = new Player<>("Benzema", 50);

        //BasketBall players
        Player<Basketball> michaelJordan = new Player<>("Michael Jordan", 45);

        //Football teams
        Team<Football> barcelona = new Team<>("Barcelona");
        Team<Football> realMadrit = new Team<>("Real Madrit");

        //BasketBall teams
        Team<Basketball> losAngelesLakers = new Team<>("Los Angeles Lakers");

        //Football teams adding players to teams
        barcelona.addPlayer(lionelMessi);
        realMadrit.addPlayer(benzema);

        //Basketball teams adding players to teams
        losAngelesLakers.addPlayer(michaelJordan);

        //Football league
        League<Team<Football>> laLiga = new League<>("La Liga");

        //Basketball league
        League<Team<Basketball>> nBA = new League<>("NBA");

        //Football league adding teams to league
        laLiga.addTeamToLeague(barcelona);
        laLiga.addTeamToLeague(realMadrit);
        //Basketball league adding teams to league
        nBA.addTeamToLeague(losAngelesLakers);

        //
//        Map<String, Integer> a = new HashMap<>();
//        a.put("A", 1);
//        a.put("B", 2);
//        a.put("A", a.get("A") + 1);
//        System.out.println(a.get("A"));

        System.out.println(barcelona.getElo());
        System.out.println(realMadrit.getElo());

        laLiga.match(barcelona, realMadrit, 1, 0);
        System.out.println(barcelona.getResults());
        System.out.println(realMadrit.getResults());

        System.out.println(barcelona.getElo());
        System.out.println(realMadrit.getElo());

        laLiga.results();
    }

}
