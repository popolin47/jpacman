package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * Unit tests for the Board class, verifying board construction and tile behavior.
 */
public class BoardTest {
    /**
     * Tests if the board correctly initializes with given dimensions.
     */
    @Test
    void testValidBoardInvariant() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();


        Board board = new Board(grid);

        assertThat(board.invariant()).isTrue();
    }

    /**
     * Tests whether tiles are correctly connected on the board.
     */
    @Test
    void testInvalidBoardInvariantAndSquareAt() {

        Square[][] grid = new Square[1][1];
        grid[0][0] = null; // 💥 break the board on purpose

        assertThatThrownBy(() -> new Board(grid))
            .isInstanceOf(AssertionError.class)
            .hasMessageContaining("Initial grid cannot contain null squares");
    }
}
