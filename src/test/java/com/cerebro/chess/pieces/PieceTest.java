package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class PieceTest {

    @Nested
    class DiagonalScenarios {
        @DisplayName("Should return all diagonals when piece is in center")
        @Test
        void testGetDiagonalsWhenPieceIsInCenter() {
            Position.Coordinates currentPosition = Position.Coordinates.of(4,4);
            List<Position.Coordinates> expectedTopLeft = List.of(
                    Position.Coordinates.of(3,3),
                    Position.Coordinates.of(2,2),
                    Position.Coordinates.of(1,1),
                    Position.Coordinates.of(0,0));
            List<Position.Coordinates> expectedTopRight = List.of(
                    Position.Coordinates.of(3,5),
                    Position.Coordinates.of(2,6),
                    Position.Coordinates.of(1,7)
            );
            List<Position.Coordinates> actualTopLeft = Piece.getTopLeftDiagonal(currentPosition);
            Assertions.assertEquals(expectedTopLeft, actualTopLeft);

            List<Position.Coordinates> actualTopRight = Piece.getTopRightDiagonal(currentPosition);
            Assertions.assertEquals(expectedTopRight, actualTopRight);
        }

        @DisplayName("Should return bottom right diagonal when piece is in top left corner")
        @Test
        void getTopLeftDiagonalForTopLeftCorner(){
            Position.Coordinates currentPosition = Position.Coordinates.of(0,0);
            List<Position.Coordinates> actualTopLeft = Piece.getTopLeftDiagonal(currentPosition);
            Assertions.assertTrue(actualTopLeft.isEmpty());

            List<Position.Coordinates> actualTopRight = Piece.getTopRightDiagonal(currentPosition);
            Assertions.assertTrue(actualTopRight.isEmpty());
        }

        @DisplayName("Should return bottom left and right diagonals only when piece is in top row")
        @Test
        void getTopLeftDiagonalForTopRow(){
            Position.Coordinates currentPosition = Position.Coordinates.of(0,3);
            List<Position.Coordinates> actualTopLeft = Piece.getTopLeftDiagonal(currentPosition);
            Assertions.assertTrue(actualTopLeft.isEmpty());

            List<Position.Coordinates> actualTopRight = Piece.getTopRightDiagonal(currentPosition);
            Assertions.assertTrue(actualTopRight.isEmpty());
        }
    }
}