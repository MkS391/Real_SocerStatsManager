import org.example.Player.Attacker;
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
}
