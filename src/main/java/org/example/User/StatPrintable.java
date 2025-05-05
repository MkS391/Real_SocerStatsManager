package org.example.User;

import org.example.Player.Player;

import java.util.List;

public interface StatPrintable {
    String generateReport(Player player);
    void generateReport(List<Player> players);
}
