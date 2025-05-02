package org.example.Player;

import java.util.Objects;

public class Attacker extends Player {
    private int shotsTaken;
    private int passesMade;

    /**
     * calculates the rate goal conversion (goals / shots taken)
     * @return a percentage of how many goals a player has scored over the number of shots he has taken
     */
    public double goalConversionRate() {
        return (double) goals /shotsTaken * 100;
    }

    /**
     * displays every stat for an attacker
     */
    @Override
    public void viewStats() {
        super.viewStats();
        System.out.printf("%n%s%d%n%s%d%n%s%.2f","Shots Taken: ", shotsTaken,"Passes Made: ", passesMade,"Goal conversion rate: ", goalConversionRate());

    }

    public Attacker(int shotsTaken, int passesMade) {
        super();
        this.shotsTaken = shotsTaken;
        this.passesMade = passesMade;
    }

    public Attacker(String name, String team, String position, int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed, int shotsTaken, int passesMade) {
        super(name, team, position, goals, assists, matchesPlayed, cardsReceived, minutesPlayed);
        this.shotsTaken = shotsTaken;
        this.passesMade = passesMade;
    }

    @Override
    public String toString() {
        return "Attacker{" +
                "shotsTaken=" + shotsTaken +
                ", passesMade=" + passesMade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Attacker attacker = (Attacker) o;
        return shotsTaken == attacker.shotsTaken && passesMade == attacker.passesMade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shotsTaken, passesMade);
    }

    public int getShotsTaken() {
        return shotsTaken;
    }

    public void setShotsTaken(int shotsTaken) {
        this.shotsTaken = shotsTaken;
    }

    public int getPassesMade() {
        return passesMade;
    }

    public void setPassesMade(int passesMade) {
        this.passesMade = passesMade;
    }

}
