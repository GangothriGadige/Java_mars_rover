import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {

    private MarsRover rover;

    @BeforeEach
    public void setUp() {
        rover = new MarsRover();
    }

    @Test
    public void shouldMoveRoverAround() {
        assertEquals("1 3 N\n", rover.run("5 5\n" + "1 1 N\n" + "MM\n"));
    }

    @Test
    public void shouldTurnRoverRight() {
        assertEquals("1 1 W\n", rover.run("5 5\n" +
                "" + "1 1 N\n" + "RRR\n"));
    }

    @Test
    public void shouldTurnRoverLeft() {
        assertEquals("1 1 E\n", rover.run("5 5\n" + "1 1 N\n" + "LLL\n"));
    }

    @Test
    public void shouldMoveMultipleRoversCorrectly() {
        String in = "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM";

        assertEquals("1 3 N\n5 1 E\n", rover.run(in));
    }

}
