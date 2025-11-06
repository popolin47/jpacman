package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen
 */
class OccupantTest {

    private Unit unit;

    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * A unit should not start with a square assigned.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * After occupying a square, the unit should be linked to that square,
     * and the square should contain that same unit.
     */
    @Test
    void testOccupy() {
        Square square = new BasicSquare();
        unit.occupy(square);

        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * When reoccupying another square, the unit should move to the new square.
     * The old square should no longer contain the unit.
     */
    @Test
    void testReoccupy() {
        Square first = new BasicSquare();
        Square second = new BasicSquare();

        unit.occupy(first);
        unit.occupy(second);

        assertThat(unit.getSquare()).isEqualTo(second);
        assertThat(second.getOccupants()).contains(unit);
        assertThat(first.getOccupants()).doesNotContain(unit);
    }
}
