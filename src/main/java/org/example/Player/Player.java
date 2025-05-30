package org.example.Player;

import java.util.Objects;

public class Player implements Comparable<Player> {
    protected String name;
    protected String team;
    protected String position;
    protected int goals;
    protected int assists;
    protected int matchesPlayed;
    protected int cardsReceived;
    protected int minutesPlayed;

    public void updateStats(int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed) {
       this.goals = goals;
       this.assists = assists;
       this.matchesPlayed = matchesPlayed;
       this.cardsReceived = cardsReceived;
       this.minutesPlayed = minutesPlayed;
    }

    public void viewStats() {
        System.out.printf("%s%s%s%s%s%s%s%d%s%d%s%d%s%d%s%d",
                "Name: ", name, "\nTeam: ", team, "\nPosition: ", position, "\nGoals: ", goals,
                "\nAssists: ", assists, "\nMatches Played: ", matchesPlayed,
                "\nCards Received: ",cardsReceived, "\nTotal Minutes Played: ", minutesPlayed);
    }

    public int compareTo(Player other) {
        return Integer.compare(goals,other.getGoals());
    }

    public Player() {
        this.name = "";
        this.team = "";
        this.position = "";
        this.goals = 0;
        this.assists = 0;
        this.matchesPlayed = 0;
        this.cardsReceived = 0;
        this.minutesPlayed = 0;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String team, String position, int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.matchesPlayed = matchesPlayed;
        this.cardsReceived = cardsReceived;
        this.minutesPlayed = minutesPlayed;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", goals=" + goals +
                ", assists=" + assists +
                ", matchesPlayed=" + matchesPlayed +
                ", cardsReceived=" + cardsReceived +
                ", minutesPlayed=" + minutesPlayed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return goals == player.goals && assists == player.assists && matchesPlayed == player.matchesPlayed && cardsReceived == player.cardsReceived && minutesPlayed == player.minutesPlayed && Objects.equals(name, player.name) && Objects.equals(team, player.team) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, team, position, goals, assists, matchesPlayed, cardsReceived, minutesPlayed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getCardsReceived() {
        return cardsReceived;
    }

    public void setCardsReceived(int cardsReceived) {
        this.cardsReceived = cardsReceived;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }
}
