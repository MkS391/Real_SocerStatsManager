package org.example.User;

import org.example.Player.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class StatsEditor extends User {
    private boolean statsEditable;
    private Stack<String> statUpdateHistory;

    /**
     * adds stats to a player directly
     * @param player the player itself
     * @param statType the type of stat you want to add
     * @param value the value of the stat
     */
    public void addstats(Player player, String statType, int value) {
        if (!statsEditable) {
            System.out.println("Stats editing is disabled.");
            return;
        }

        switch (statType.toLowerCase()) {
            case "goals":
                player.setGoals(player.getGoals() + value);
                break;
            case "assists":
                player.setAssists(player.getAssists() + value);
                break;
            case "cards":
                player.setCardsReceived(player.getCardsReceived() + value);
                break;
            default:
                System.out.println("Unknown stat type.");
                return;
        }

        statUpdateHistory.push("Updated " + statType + " for " + player.getName() + " by " + value);
    }

    /**
     * shows older updates
     */
    public void viewUpdateHistory() {
        if (statUpdateHistory.isEmpty()) {
            System.out.println("No updates yet.");
        } else {
            for (String update : statUpdateHistory) {
                System.out.println(update);
            }
        }
    }

    /**
     * displays stats of a player
     * @param players the player in question
     */
    public void viewStats(List<Player> players) {
        for (Player player : players){
            player.viewStats();
        }
    }

    /**
     * takes data from a csv file and puts in the variables to store them
     * @param filename the file that is getting read
     * @return a player with new stats
     */
    public List<Player> readStatsFromFile(String filename) {
        List<Player> players = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                String team = data[1];
                String position = data[2];
                int goals = Integer.parseInt(data[3]);
                int assists = Integer.parseInt(data[4]);
                int matchesPlayed = Integer.parseInt(data[5]);
                int cards = Integer.parseInt(data[6]);
                int minutesPlayed = Integer.parseInt(data[7]);

                Player player = null;

                if (position.equalsIgnoreCase("Attacker")) {
                    int shotsTaken = Integer.parseInt(data[8]);
                    int passesMade = Integer.parseInt(data[9]);
                    player = new Attacker(name, team, position, goals, assists, matchesPlayed, cards, minutesPlayed, shotsTaken, passesMade);
                } else if (position.equalsIgnoreCase("Midfielder")) {
                    int recoveries = Integer.parseInt(data[8]);
                    int passes = Integer.parseInt(data[9]);
                    int passesAttempted = Integer.parseInt(data[10]);
                    player = new Midfielder(name, team, position, goals, assists, matchesPlayed, cards, minutesPlayed, recoveries, passes, passesAttempted);
                } else if (position.equalsIgnoreCase("Defender")) {
                    int cleanSheets = Integer.parseInt(data[8]);
                    int tacklesWon = Integer.parseInt(data[9]);
                    int tacklesLost = Integer.parseInt(data[10]);
                    int blockedShots = Integer.parseInt(data[11]);
                    player = new Defender(name, team, position, goals, assists, matchesPlayed, cards, minutesPlayed, cleanSheets, tacklesWon, tacklesLost, blockedShots);
                } else if (position.equalsIgnoreCase("Goalkeeper")) {
                    int cleanSheets = Integer.parseInt(data[8]);
                    int savesMade = Integer.parseInt(data[9]);
                    int totalShotFaced = Integer.parseInt(data[10]);
                    player = new Goalkeeper(name, team, position, goals, assists, matchesPlayed, cards, minutesPlayed, cleanSheets, savesMade, totalShotFaced);
                }

                players.add(player);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return players;
    }

    /**
     * puts the stats of a player in a csv file to store it
     * @param filename the file where the stats are stored
     * @param players the players whose stats are stored
     */
    public void writePlayersToFile(String filename, List<Player> players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Player p : players) {
                StringBuilder line = new StringBuilder();
                line.append(p.getName()).append(",");
                line.append(p.getTeam()).append(",");
                line.append(p.getPosition()).append(",");
                line.append(p.getGoals()).append(",");
                line.append(p.getAssists()).append(",");
                line.append(p.getMatchesPlayed()).append(",");
                line.append(p.getCardsReceived());

                if (p instanceof Attacker) {
                   Attacker a = (Attacker) p;
                   line.append(",").append(a.getShotsTaken())
                           .append(",").append(a.getPassesMade());
                } else if (p instanceof Midfielder) {
                    Midfielder m = (Midfielder) p;
                    line.append(",").append(m.getRecoveries())
                            .append(",").append(m.getPassesMade())
                            .append(",").append(m.getPassesAttempted());
                } else if (p instanceof Defender) {
                    Defender d = (Defender) p;
                    line.append(",").append(d.getCleanSheets())
                            .append(",").append(d.getTacklesWon())
                            .append(",").append(d.getTacklesLost())
                            .append(",").append(d.getBlockedShots());
                } else if (p instanceof Goalkeeper) {
                    Goalkeeper g = (Goalkeeper) p;
                    line.append(",").append(g.getCleanSheets())
                            .append(",").append(g.getSavesMade())
                            .append(",").append(g.getTotalShotsFaced());
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public StatsEditor() {
        super();
        this.statsEditable = true;
        this.statUpdateHistory = new Stack<>();
    }

    public StatsEditor(String username, String password) {
        super(username, password, "Stat editor");
        this.statsEditable = true;
        this.statUpdateHistory = new Stack<>();
    }

    public StatsEditor(boolean statsEditable, Stack<String> statUpdateHistory) {
        super();
        this.statsEditable = statsEditable;
        this.statUpdateHistory = statUpdateHistory;
    }

    public StatsEditor(String username, String password, String role, boolean statsEditable, Stack<String> statUpdateHistory) {
        super(username, password, role);
        this.statsEditable = statsEditable;
        this.statUpdateHistory = statUpdateHistory;
    }

    @Override
    public String toString() {
        return "StatsEditor{" +
                "statsEditable=" + statsEditable +
                ", statUpdateHistory=" + statUpdateHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StatsEditor that = (StatsEditor) o;
        return statsEditable == that.statsEditable && Objects.equals(statUpdateHistory, that.statUpdateHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), statsEditable, statUpdateHistory);
    }

    public boolean isStatsEditable() {
        return statsEditable;
    }

    public void setStatsEditable(boolean statsEditable) {
        this.statsEditable = statsEditable;
    }

    public Stack<String> getStatUpdateHistory() {
        return statUpdateHistory;
    }

    public void setStatUpdateHistory(Stack<String> statUpdateHistory) {
        this.statUpdateHistory = statUpdateHistory;
    }
}
