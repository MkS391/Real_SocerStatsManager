import org.example.Player.Attacker;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    @Test
    public void ViewStatsTest_Normal() {
        // Create an attacker with some data
        Attacker attacker = new Attacker("Leo Messi","Inter Miami","Forward",12,5,10,1,90,30,100);

        // Capture system output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call viewStats()
        attacker.viewStats();

        // Expected output (match your actual viewStats method formatting)
        String expectedOutput = "Name: Leo Messi\n" +
                "Team: Inter Miami\n" +
                "Position: Forward\n" +
                "Goals: 12\n" +
                "Assists: 5\n" +
                "Matches Played: 10\n" +
                "Cards Received: 1\n" +
                "Total Minutes Played: 90\n" +
                "Shots Taken: 30\n";

        // Reset System.out
        System.setOut(System.out);

        // Assert that output matches
        assertEquals(expectedOutput, outContent.toString());
    }
}
