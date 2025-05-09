import org.example.Player.Attacker;
import org.example.Player.Defender;
import org.example.Player.Goalkeeper;
import org.example.Player.Midfielder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    @Test
    public void ViewStatsTest_Normal() {
        Attacker attacker = new Attacker("Leo Messi","Inter Miami","Forward",12,5,10,1,90,30,100);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        attacker.viewStats();

        String expectedOutput = "Name: Leo Messi" +
                "\nTeam: Inter Miami" +
                "\nPosition: Forward" +
                "\nGoals: 12" +
                "\nAssists: 5" +
                "\nMatches Played: 10" +
                "\nCards Received: 1" +
                "\nTotal Minutes Played: 90" +
                "\nShots Taken: 30" +
                "\nPasses Made: 100" +
                "\nGoal conversion rate: 40.00";

        // Reset System.out
        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testUpdateStats_Attacker() {
        Attacker attacker = new Attacker("Max", "Waves","Attacker", 9, 1, 5, 1, 10,10,30);
        attacker.updateStats(10, 2, 6, 0, 5);
        assertEquals(6, attacker.getMatchesPlayed());
        assertEquals(10, attacker.getGoals());
        assertEquals(2, attacker.getAssists());
        assertEquals(0, attacker.getCardsReceived());
        assertEquals(5, attacker.getMinutesPlayed());
        assertEquals(10, attacker.getShotsTaken());
        assertEquals(30, attacker.getPassesMade());
    }
    @Test
    public void testUpdateStats_Midfielder() {
        Midfielder mid = new Midfielder("Sam", "Storm", "Midfielder", 6, 3, 6, 1, 12, 8,30,35);
        mid.updateStats(2, 1, 2, 0, 8);
        assertEquals(2, mid.getMatchesPlayed());
        assertEquals(2, mid.getGoals());
        assertEquals(1, mid.getAssists());
        assertEquals(0, mid.getCardsReceived());
        assertEquals(8, mid.getRecoveries());
    }
    @Test
    public void testUpdateStats_Defender() {
        Defender def = new Defender("Liam", "Guards", "Defender", 7, 1, 7, 0, 15, 3, 4,2,5);
        def.updateStats(1, 0, 1, 1, 5);
        assertEquals(1, def.getMatchesPlayed());
        assertEquals(1, def.getGoals());
        assertEquals(0, def.getAssists());
        assertEquals(1, def.getCardsReceived());
        assertEquals(4, def.getTacklesWon());
        assertEquals(2, def.getTacklesLost());
        assertEquals(5, def.getBlockedShots());
    }
    @Test
    public void testUpdateStats_Goalkeeper() {
        Goalkeeper gk = new Goalkeeper("Nina", "Keepers", "Goalkeeper", 0, 0, 13, 1, 6, 2,5,6);
        gk.updateStats(0, 0, 1, 0, 1);
        assertEquals(1, gk.getMatchesPlayed());
        assertEquals(0, gk.getGoals());
        assertEquals(0, gk.getAssists());
        assertEquals(0, gk.getCardsReceived());
        assertEquals(2, gk.getCleanSheets());
        assertEquals(5, gk.getSavesMade());
    }
}
