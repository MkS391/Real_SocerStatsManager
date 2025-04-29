package org.example.User;

import org.example.Player.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public abstract class User {
    private String username;
    private String password;
    private String role;

    public void viewStats(){
        //TODO
    }
    public int comparePlayer(Player player1, Player player2){
        //TODO
        return 0;
    }
    public void login(){
        //TODO
    }
    public void displayLeaderboardByGoals(List<Player> players){
        //TODO
    }

    public void displayLeaderboard(List<Player> players, Comparator<Player> comparator){
        //TODO
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
