package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.*;

import java.util.List;

class PawnTest {
    private final Piece lightPawn = new Pawn(Constants.Color.LIGHT);
    private final Piece darkPawn = new Pawn(Constants.Color.DARK);

    @DisplayName("When pawn is in center")
    @Nested
    class CenterPawnScenarios{
        @BeforeEach
        void setUp() {
            lightPawn.setCoordinates(Position.Coordinates.of(3, 0));
            darkPawn.setCoordinates(Position.Coordinates.of(3, 0));
        }

        @DisplayName("Should return possible move for light pawn")
        @Test
        void shouldReturnPossibleMoveWhenPawnIsLight() {
            List<Position.Coordinates> actual = lightPawn.getPossibleMoves();
            Assertions.assertEquals(1, actual.size());
            Assertions.assertEquals(Position.Coordinates.of(4, 0), actual.getFirst());
        }

        @DisplayName("Should return possible move for dark pawn")
        @Test
        void shouldReturnPossibleMoveWhenPawnIsDark() {
            List<Position.Coordinates> actual = darkPawn.getPossibleMoves();
            Assertions.assertEquals(1, actual.size());
            Assertions.assertEquals(Position.Coordinates.of(2, 0), actual.getFirst());
        }
    }

    @DisplayName("When pawn is in starting position")
    @Nested
    class PawnInStartingPositionScenario{
        @BeforeEach
        void setUp() {
            lightPawn.setCoordinates(Position.Coordinates.of(1, 4));
            darkPawn.setCoordinates(Position.Coordinates.of(7, 3));
        }

        @DisplayName("Should return 2 positions when light pawn is in starting")
        @Test
        void shouldReturn2PositionsWhenLightPieceIsStarting() {
            List<Position.Coordinates> actual = lightPawn.getPossibleMoves();
            Assertions.assertEquals(2, actual.size());
            Assertions.assertEquals(Position.Coordinates.of(3, 4), actual.getFirst());
            Assertions.assertEquals(Position.Coordinates.of(2, 4), actual.getLast());
        }

        @DisplayName("Should return 2 positions when dark pawn is in starting")
        @Test
        void shouldReturn2PositionsWhenDarkPieceIsStarting() {
            List<Position.Coordinates> actual = darkPawn.getPossibleMoves();
            Assertions.assertEquals(2, actual.size());
            Assertions.assertEquals(Position.Coordinates.of(5, 3), actual.getFirst());
            Assertions.assertEquals(Position.Coordinates.of(6, 3), actual.getLast());
        }
    }
}