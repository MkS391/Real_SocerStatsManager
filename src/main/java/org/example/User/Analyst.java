package org.example.User;

import org.example.Player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analyst extends User implements StatPrintable {
    private boolean canCreateReport;
    private Map<String, String> teamReports;

    /**
     *generates a report about a player during his season
     * @param player the player in question
     * @return a report of his stats
     */
    @Override
    public String generateReport(Player player) {
        if (!canCreateReport) {
            return "You can not create reports.";
        }

        StringBuilder report = new StringBuilder();
        report.append("=== Performance Report ===\n");
        report.append("Name: ").append(player.getName()).append("\n");
        report.append("Team: ").append(player.getTeam()).append("\n");
        report.append("Position: ").append(player.getPosition()).append("\n");

        int goals = player.getGoals();
        int assists = player.getAssists();
        int cards = player.getCardsReceived();

        report.append("\n--- General Stats ---\n");
        report.append("Goals: ").append(goals).append("\n");
        report.append("Assists: ").append(assists).append("\n");
        report.append("Cards Received: ").append(cards).append("\n");

        report.append("\n--- Analysis ---\n");
        if (goals >= 20) {
            report.append("Very good goal scorer\n");
        } else if (goals > 0) {
            report.append("Occasionally scores\n");
        } else {
            report.append("No goal contributions yet\n");
        }

        if (assists > goals) {
            report.append("Valuable playmaker with high assist rate\n");
        }

        if (cards >= 5) {
            report.append("Disciplinary issues, many cards received\n");
        } else {
            report.append("Good discipline on the field\n");
        }
        return report.toString();
    }

    @Override
    public void generateReport(List<Player> players) {
        Map<String, Integer> teamGoals = new HashMap<>();
        Map<String, Integer> teamAssists = new HashMap<>();
        Map<String, Player> topScorers = new HashMap<>();
        Map<String, Integer> topGoals = new HashMap<>();

        for (Player p : players) {
            String team = p.getTeam();

            teamGoals.put(team, teamGoals.getOrDefault(team, 0) + p.getGoals());
            teamAssists.put(team, teamAssists.getOrDefault(team, 0) + p.getAssists());

            if (!topScorers.containsKey(team) || p.getGoals() > topGoals.get(team)) {
                topScorers.put(team, p);
                topGoals.put(team, p.getGoals());
            }
        }

        for (String team : teamGoals.keySet()) {
            int totalGoals = teamGoals.get(team);
            int totalAssists = teamAssists.get(team);
            Player topScorer = topScorers.get(team);

            String report = "Team: " + team +
                    "\nTotal Goals: " + totalGoals +
                    "\nTotal Assists: " + totalAssists +
                    "\nTop Scorer: " + topScorer.getName() + " (" + topScorer.getGoals() + " goals)";

            teamReports.put(team, report);
        }
    }

    public void addReport(String teamName, String reportContent) {
        if (canCreateReport) {
            teamReports.put(teamName, reportContent);
        }
    }

    public void viewStats(List<Player> players) {
        for (Player player : players) {
            player.viewStats();
        }
    }


    public Analyst(String username, String password) {
        super(username, password, "Analyst");
        this.canCreateReport = true;
        this.teamReports = new HashMap<>();
    }

    public Analyst(boolean canCreateReport, Map<String, String> teamReports) {
        super();
        this.canCreateReport = canCreateReport;
        this.teamReports = teamReports;
    }

    @Override
    public String toString() {
        return "Analyst{" +
                "canCreateReport=" + canCreateReport +
                ", teamReports=" + teamReports +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Analyst analyst = (Analyst) o;
        return canCreateReport == analyst.canCreateReport && Objects.equals(teamReports, analyst.teamReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), canCreateReport, teamReports);
    }

    public boolean isCanCreateReport() {
        return canCreateReport;
    }

    public void setCanCreateReport(boolean canCreateReport) {
        this.canCreateReport = canCreateReport;
    }

    public Map<String, String> getTeamReports() {
        return teamReports;
    }

    public void setTeamReports(Map<String, String> teamReports) {
        this.teamReports = teamReports;
    }
}
