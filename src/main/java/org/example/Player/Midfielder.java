package org.example.Player;

import java.util.Objects;

public class Midfielder extends Player {
    private int recoveries;
    private int passesMade;
    private int passesAttempted;

    /**
     * calculates the pass accuracy of the players
     * @return a percentage of the pass accuracy
     */
    public double passAccuracy(){
        return (double) passesMade / passesAttempted * 100;
    }

    /**
     * displays every stat for a midfielder
     */
    @Override
    public void viewStats(){
        super.viewStats();
        System.out.printf("%n%s%d%n%s%d%n%s%f", "Recoveries: ", recoveries, "Passes: ", passesMade, "Pass Accuracy: ", passAccuracy());
    }

    public Midfielder() {
        super();
        this.recoveries = 0;
        this.passesMade = 0;
        this.passesAttempted = 0;
    }
    public Midfielder(int recoveries, int passesMade, int passesAttempted) {
        super();
        this.recoveries = recoveries;
        this.passesMade = passesMade;
        this.passesAttempted = passesAttempted;
    }

    public Midfielder(String name, String team, String position, int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed, int recoveries, int passesMade, int passesAttempted) {
        super(name, team, position, goals, assists, matchesPlayed, cardsReceived, minutesPlayed);
        this.recoveries = recoveries;
        this.passesMade = passesMade;
        this.passesAttempted = passesAttempted;
    }

    @Override
    public String toString() {
        return "Midfielder{" +
                "recoveries=" + recoveries +
                ", passesMade=" + passesMade +
                ", passesAttempted=" + passesAttempted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Midfielder that = (Midfielder) o;
        return recoveries == that.recoveries && passesMade == that.passesMade && passesAttempted == that.passesAttempted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recoveries, passesMade, passesAttempted);
    }

    public int getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(int recoveries) {
        this.recoveries = recoveries;
    }

    public int getPassesMade() {
        return passesMade;
    }

    public void setPassesMade(int passesMade) {
        this.passesMade = passesMade;
    }

    public int getPassesAttempted() {
        return passesAttempted;
    }

    public void setPassesAttempted(int passesAttempted) {
        this.passesAttempted = passesAttempted;
    }
}

