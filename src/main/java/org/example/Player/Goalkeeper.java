package org.example.Player;

import java.util.Objects;

public class Goalkeeper extends Player {
    private int cleanSheets;
    private int savesMade;
    private int totalShotsFaced;

    public double savePercentage() {
        //TODO
        return 0.0;
    }

    @Override
    public void viewStats() {
        //TODO
    }

    public Goalkeeper() {
        super();
        this.cleanSheets = 0;
        this.savesMade = 0;
        this.totalShotsFaced = 0;
    }

    public Goalkeeper(int cleanSheets, int savesMade, int totalShotsFaced) {
        super();
        this.cleanSheets = cleanSheets;
        this.savesMade = savesMade;
        this.totalShotsFaced = totalShotsFaced;
    }

    public Goalkeeper(String name, String team, String position, int goals, int assists, int matchesPlayed, int cardsReceived, int minutesPlayed, int cleanSheets, int savesMade, int totalShotsFaced) {
        super(name, team, position, goals, assists, matchesPlayed, cardsReceived, minutesPlayed);
        this.cleanSheets = cleanSheets;
        this.savesMade = savesMade;
        this.totalShotsFaced = totalShotsFaced;
    }

    @Override
    public String toString() {
        return "Goalkeeper{" +
                "cleanSheets=" + cleanSheets +
                ", savesMade=" + savesMade +
                ", totalShotsFaced=" + totalShotsFaced +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Goalkeeper that = (Goalkeeper) o;
        return cleanSheets == that.cleanSheets && savesMade == that.savesMade && totalShotsFaced == that.totalShotsFaced;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cleanSheets, savesMade, totalShotsFaced);
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public int getSavesMade() {
        return savesMade;
    }

    public void setSavesMade(int savesMade) {
        this.savesMade = savesMade;
    }

    public int getTotalShotsFaced() {
        return totalShotsFaced;
    }

    public void setTotalShotsFaced(int totalShotsFaced) {
        this.totalShotsFaced = totalShotsFaced;
    }
}