/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ec.jorgetorres.bowling;

import ec.jorgetorres.bowling.entities.NormalFrame;
import ec.jorgetorres.bowling.entities.Player;
import ec.jorgetorres.bowling.entities.Roll;
import ec.jorgetorres.bowling.exceptions.ExceededPinFallException;
import ec.jorgetorres.bowling.exceptions.NotAllowedPinFallException;
import org.junit.Test;
import static org.junit.Assert.*;

public class TenPinBowlingTestCase {
    @Test public void testIfFrameIsSpare() throws ExceededPinFallException {
        Roll roll = new Roll(5);
        NormalFrame frame = new NormalFrame(roll);
        frame.setLatestRoll(new Roll(5));
        assertTrue(frame.isSpare());
    }

    @Test public void testIfFrameIsStrike() {
        Roll roll = new Roll(10);
        NormalFrame frame = new NormalFrame(roll);
        assertTrue(frame.isStrike());
    }

    @Test public void testPlayerScoreWithoutBonus() throws ExceededPinFallException, NotAllowedPinFallException {
        Player player = new Player("Jorge", 5);
        player.addResult(4);
        player.calculateScore();
        assertEquals(9, player.getScore());
    }

    @Test public void testPlayerScoreWithSpareBonus() throws NotAllowedPinFallException, ExceededPinFallException {
        Player player = new Player("Jorge", 5);
        player.addResult(5);
        player.addResult(5);
        player.addResult(3);
        player.calculateScore();
        assertEquals(23, player.getScore());
    }

    @Test public void testPlayerScoreWithStrikeBonus() throws NotAllowedPinFallException, ExceededPinFallException {
        Player player = new Player("Jorge", 10);
        player.addResult(5);
        player.addResult(3);
        player.calculateScore();
        assertEquals(26, player.getScore());
    }
}