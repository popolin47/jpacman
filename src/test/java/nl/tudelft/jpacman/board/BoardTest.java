package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class BoardTest {

    @Test
    void testValidBoardInvariant() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();


        Board board = new Board(grid);

        assertThat(board.invariant()).isTrue();
    }

    @Test
    void testInvalidBoardInvariantAndSquareAt() {

        Square[][] grid = new Square[1][1];
        grid[0][0] = null; // 💥 break the board on purpose

        assertThatThrownBy(() -> new Board(grid))
            .isInstanceOf(AssertionError.class)
            .hasMessageContaining("Initial grid cannot contain null squares");
    }
}
