package org.example.User;

import org.example.Player.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class User {
    private String username;
    private String password;
    private String role;

    /**
     * displays the stats of a player
     * @param player the player in question
     */
    public void viewStats(Player player){
       player.viewStats();
    }

    /**
     * compares 2 players based on some simple stats
     * @param player1 the first player who is compared
     * @param player2 the second player who is compared
     * @param stat the stat on which they are compared
     * @return the players in a new order
     */
    public int comparePlayer(Player player1, Player player2, String stat){
        return switch (stat.toLowerCase()) {
            case "goals" -> Integer.compare(player2.getGoals(), player1.getGoals());
            case "assists" -> Integer.compare(player2.getAssists(), player1.getAssists());
            case "cards" -> Integer.compare(player2.getCardsReceived(), player1.getCardsReceived());
            case "matches played" -> Integer.compare(player2.getMinutesPlayed(), player1.getMatchesPlayed());
            default -> throw new IllegalArgumentException("Stat not recognized");
        };
    }

    /**
     * a way to access the app
     * @param inputUsername your username
     * @param inputPassword your password
     * @return true if you are allowed to login, false if not
     */
    public boolean login(String inputUsername, String inputPassword){
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    /**
     * displays a leaderboard of players ranked on their goals
     * @param players the players who get ranked
     */
    public void displayLeaderboardByGoals(List<Player> players){
        players.sort((p1, p2) -> Integer.compare(p2.getGoals(),p1.getGoals()));

        System.out.println("Goals Leaderboard: ");
        for (int i = 0; i < players.size(); i++){
            Player p = players.get(i);
            System.out.println((i + 1) + "." + p.getName() + ", " + p.getGoals() + "Goals");
        }
    }

    /**
     * displays leaderboard based on a comparing method
     * @param players the players who get compared
     * @param comparator the method of comparison
     */
    public void displayLeaderboard(List<Player> players, Comparator<Player> comparator){
        Collections.sort(players, comparator);

        System.out.println("Leaderboard: ");

        for (int i = 0; i < players.size(); i++){
            System.out.println((i +1) + "." + players.get(i).toString());
        }
    }

    public User() {
        this.username = "";
        this.password = "";
        this.role = "";
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
