package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    Piece knight = new Knight(Constants.Color.DARK);

    @DisplayName("When knight is in center")
    @Nested
    class CenterKnightScenarios{
        @BeforeEach
        void setUp() {
            knight.setCoordinates(Position.Coordinates.of(3,3));
        }

        @DisplayName("Should return 8 possible moves")
        @Test
        void shouldReturn8PossibleMovesWhenKnightIsInCenter() {
            List<Position.Coordinates> expected = List.of(
                    Position.Coordinates.of(2,1),
                    Position.Coordinates.of(1,2),
                    Position.Coordinates.of(2,5),
                    Position.Coordinates.of(1,4),
                    Position.Coordinates.of(4,1),
                    Position.Coordinates.of(5,2),
                    Position.Coordinates.of(4,5),
                    Position.Coordinates.of(5,4)
            );
            List<Position.Coordinates> actual = knight.getPossibleMoves(Position.Coordinates.of(3,3));
            Assertions.assertEquals(expected.size(), actual.size());
            expected.forEach(position -> Assertions.assertTrue(actual.contains(position)));
        }
    }

    @DisplayName("When knight is in corner")
    @Nested
    class CornerKnightScenarios{
        @BeforeEach
        void setUp() {
            knight.setCoordinates(Position.Coordinates.of(0,0));
        }

        @DisplayName("Should return 2 positions")
        @Test
        void shouldReturn2Positions() {
            List<Position.Coordinates> actual = knight.getPossibleMoves(Position.Coordinates.of(0,0));
            List<Position.Coordinates> expected = List.of(
                    Position.Coordinates.of(2,1),
                    Position.Coordinates.of(1,2)
            );
            Assertions.assertEquals(expected.size(), actual.size());
            expected.forEach(position -> Assertions.assertTrue(actual.contains(position)));
        }
    }

}