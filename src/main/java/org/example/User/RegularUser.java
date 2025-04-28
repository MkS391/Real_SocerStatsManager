package org.example.User;

import org.example.Player.Player;

import java.util.ArrayList;
import java.util.Objects;

public class RegularUser extends User {
    private ArrayList<Player> favoritePlayers;

    public void viewSimpleStats(Player player){
    }
    public void favoritePlayer(){
    }

    public RegularUser() {
        super();
        this.favoritePlayers = new ArrayList<>();
    }
    public RegularUser(ArrayList<Player> favoritePlayers) {
        super();
        this.favoritePlayers = favoritePlayers;
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
