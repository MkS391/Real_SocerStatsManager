import org.example.Player.Attacker;
import org.example.Player.Defender;
import org.example.Player.Player;
import org.example.User.Analyst;
import org.example.User.RegularUser;
import org.example.User.StatsEditor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserTests {
    @Test
    public void testFavoritePlayer_RegularUser() {
        RegularUser ru = new RegularUser("John", "Pass");
        Player fav = new Player("Lily", "Otters", "Midfielder", 10, 5, 7, 1,90);
        ru.addFavoritePlayer(fav);
        assertTrue(ru.getFavoritePlayers().contains(fav));
    }

    @Test
    public void testGenerateReport_Analyst() {
        Analyst a = new Analyst("ana", "pw");
        Player player = new Player("Josh", "Wolves", "Defender", 9, 2, 3, 0,90);
        String report = a.generateReport(player);
        assertTrue(report.contains("Josh"));
        assertTrue(report.contains("Wolves"));
    }


    @Test
    public void testWritePlayersToFile() throws IOException {
        StatsEditor editor = new StatsEditor("editor", "pass");

        List<Player> players = new ArrayList<>();
        players.add(new Attacker("John", "TeamA", "Attacker", 5, 3, 20,1,90,5,30));
        players.add(new Defender("Alice", "TeamB", "Defender", 2, 4, 8, 6, 1,2,5,5,3));

        File tempFile = File.createTempFile("players", ".txt");
        String filePath = tempFile.getAbsolutePath();
        editor.writePlayersToFile(filePath, players);
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        assertEquals(2, lines.size());
        assertTrue(lines.get(0).contains("John"));
        assertTrue(lines.get(1).contains("Alice"));

        tempFile.deleteOnExit();
    }
}