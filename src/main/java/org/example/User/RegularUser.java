package org.example.User;

import org.example.Player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegularUser extends User {
    private ArrayList<Player> favoritePlayers;

    public RegularUser() {
        super();
        this.favoritePlayers = new ArrayList<>();
    }
    public RegularUser(ArrayList<Player> favoritePlayers) {
        super();
        this.favoritePlayers = favoritePlayers;
    }
    public void viewSimpleStats(Player player){
        System.out.println(player.getName());
        System.out.println("\nTeam: " + player.getTeam());
        System.out.println("\nGoals: " + player.getGoals());
        System.out.println("\nAssists: " + player.getAssists());
    }
    public void addFavoritePlayer(Player player) {
        if (!favoritePlayers.contains(player)) {
            favoritePlayers.add(player);
            System.out.println(player.getName() + " has been added to favorites.");
        } else {
            System.out.println(player.getName() + " is already a favorite.");
        }
    }

    public void viewFavoritePlayers() {
        System.out.println("Favorite Players:");
        for (Player p : favoritePlayers) {
            System.out.println(p);
        }
    }

    @Override
    public String toString() {
        return "RegularUser{" +
                "favoritePlayers=" + favoritePlayers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegularUser that = (RegularUser) o;
        return Objects.equals(favoritePlayers, that.favoritePlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), favoritePlayers);
    }

    public ArrayList<Player> getFavoritePlayers() {
        return favoritePlayers;
    }

    public void setFavoritePlayers(ArrayList<Player> favoritePlayers) {
        this.favoritePlayers = favoritePlayers;
    }
}
