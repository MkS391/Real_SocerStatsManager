package org.example.Player;

import java.util.Objects;

public class Defender extends Player{

    private int cleanSheets;
    private int tacklesWon;
    private int tacklesLost;
    private int blockedShots;

    /**
     * calculates the rate of successful tackles
     * @return a percentage of successful tackles
     */
    public double tacklesSuccessRate(){
        return (double) tacklesWon / (tacklesLost + tacklesWon) * 100;
    }

    /**
     * displays every stat for a defender
     */
    @Override
    public void viewStats(){
        super.viewStats();
        System.out.printf("%n%s%d%n%s%d%s%d%n%s%f","Blocked Shots: ", blockedShots,"Tackles: ", tacklesWon, "/", tacklesWon + tacklesLost,
                "Successful Tackle Percentage: ", tacklesSuccessRate());
    }

    public Defender() {
        super();
        this.cleanSheets = 0;
        this.tacklesWon = 0;
        this.tacklesLost = 0;
        this.blockedShots = 0;
    }

    public Defender(int cleanSheets, int tacklesWon, int tacklesLost, int blockedShots) {
        super();
        this.cleanSheets = cleanSheets;
        this.tacklesWon = tacklesWon;
        this.tacklesLost = tacklesLost;
        this.blockedShots = blockedShots;
    }

    public Defender(String name, String team, String position, int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed, int cleanSheets, int tacklesWon, int tacklesLost, int blockedShots) {
        super(name, team, position, goals, assists, matchesPlayed, cardsReceived, minutesPlayed);
        this.cleanSheets = cleanSheets;
        this.tacklesWon = tacklesWon;
        this.tacklesLost = tacklesLost;
        this.blockedShots = blockedShots;
    }

    @Override
    public String toString() {
        return "Defender{" +
                "cleanSheets=" + cleanSheets +
                ", tacklesWon=" + tacklesWon +
                ", tacklesLost=" + tacklesLost +
                ", blockedShots=" + blockedShots +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Defender defender = (Defender) o;
        return cleanSheets == defender.cleanSheets && tacklesWon == defender.tacklesWon && tacklesLost == defender.tacklesLost && blockedShots == defender.blockedShots;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cleanSheets, tacklesWon, tacklesLost, blockedShots);
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getTacklesWon() {
        return tacklesWon;
    }

    public void setTacklesWon(int tacklesWon) {
        this.tacklesWon = tacklesWon;
    }

    public int getTacklesLost() {
        return tacklesLost;
    }

    public void setTacklesLost(int tacklesLost) {
        this.tacklesLost = tacklesLost;
    }

    public int getBlockedShots() {
        return blockedShots;
    }

    public void setBlockedShots(int blockedShots) {
        this.blockedShots = blockedShots;
    }
}
