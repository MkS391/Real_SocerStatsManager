package org.example.User;

import org.example.Player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Analyst extends User implements StatPrintable {
    private boolean canCreateReport;
    private Map<String, String> teamReports;

    public String generateReport(){
        return "";
    }

    @Override
    public String generateReport(Player player) {
        return "";
    }

    public void viewStats(){
    }

    public Analyst() {
        super();
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
