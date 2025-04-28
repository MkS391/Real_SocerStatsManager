package org.example.User;

import java.util.Objects;
import java.util.Stack;

public class StatsEditor extends User {
    private boolean statsEditable;
    private Stack<String> statUpdateHistory;

    public void addstats() {
    }

    public void updateStats() {
    }

    public void viewStats() {
    }

    public void readStatsFromFile() {
    }

    public void writeStatsToFile() {
    }

    public StatsEditor() {
        super();
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
