package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

class PieceTest {

    @DisplayName("Should return all 4 diagonals")
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
            List<Position.Coordinates> expectedBottomLeft = List.of(
                    Position.Coordinates.of(5,3),
                    Position.Coordinates.of(6,2),
                    Position.Coordinates.of(7,1)
            );
            List<Position.Coordinates> expectedBottomRight = List.of(
                    Position.Coordinates.of(5,5),
                    Position.Coordinates.of(6,6),
                    Position.Coordinates.of(7,7)
            );
            Assertions.assertEquals(expectedTopLeft, Piece.getTopLeftDiagonal(currentPosition));
            Assertions.assertEquals(expectedTopRight, Piece.getTopRightDiagonal(currentPosition));
            Assertions.assertEquals(expectedBottomLeft, Piece.getBottomLeftDiagonal(currentPosition));
            Assertions.assertEquals(expectedBottomRight, Piece.getBottomRightDiagonal(currentPosition));
        }

        @DisplayName("Should return only one diagonal when piece is in corner")
        @Nested
        class CornerScenarios {
            @DisplayName("Should return bottom right diagonal when piece is in top left corner")
            @Test
            void shouldReturnBottomRightDiagonalWhenPieceIsInTopLeftCorner() {
                Position.Coordinates currentPosition = Position.Coordinates.of(0,0);
                Assertions.assertTrue(Piece.getTopLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getTopRightDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomLeftDiagonal(currentPosition).isEmpty());

                List<Position.Coordinates> actualBottomRight = Piece.getBottomRightDiagonal(currentPosition);
                Assertions.assertEquals(7, actualBottomRight.size());

                IntStream.range(1, 8)
                        .forEach(i -> {
                            Assertions.assertEquals(i, actualBottomRight.get(i-1).getRow());
                            Assertions.assertEquals(i, actualBottomRight.get(i-1).getColumn());
                        });
            }

            @DisplayName("Should return bottom left diagonal when piece is in top right corner")
            @Test
            void shouldReturnBottomLeftWhenPieceIsInTopRightCorner() {
                Position.Coordinates currentPosition = Position.Coordinates.of(0,7);
                Assertions.assertTrue(Piece.getTopLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getTopRightDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomRightDiagonal(currentPosition).isEmpty());

                List<Position.Coordinates> actualBottomLeft = Piece.getBottomLeftDiagonal(currentPosition);
                Assertions.assertEquals(7, actualBottomLeft.size());
                Assertions.assertEquals(Position.Coordinates.of(1,6), actualBottomLeft.getFirst());
                Assertions.assertEquals(Position.Coordinates.of(7,0), actualBottomLeft.getLast());
            }

            @DisplayName("Should return top right diagonal when piece is in bottom left corner")
            @Test
            void shouldReturnTopRightDiagonalWhenPieceIsInBottomLeftCorner() {
                Position.Coordinates currentPosition = Position.Coordinates.of(7,0);
                Assertions.assertTrue(Piece.getTopLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomRightDiagonal(currentPosition).isEmpty());

                List<Position.Coordinates> actualTopRight = Piece.getTopRightDiagonal(currentPosition);
                Assertions.assertEquals(7, actualTopRight.size());
                Assertions.assertEquals(Position.Coordinates.of(6,1), actualTopRight.getFirst());
                Assertions.assertEquals(Position.Coordinates.of(0,7), actualTopRight.getLast());
            }

            @DisplayName("Should return top left diagonal when piece is in bottom right corner")
            @Test
            void shouldReturnTopLeftDiagonalWhenPieceIsInBottomRightCorner() {
                Position.Coordinates currentPosition = Position.Coordinates.of(7,7);
                Assertions.assertTrue(Piece.getTopRightDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomRightDiagonal(currentPosition).isEmpty());

                List<Position.Coordinates> actualTopLeft = Piece.getTopLeftDiagonal(currentPosition);
                Assertions.assertEquals(7, actualTopLeft.size());
                Assertions.assertEquals(Position.Coordinates.of(6,6), actualTopLeft.getFirst());
                Assertions.assertEquals(Position.Coordinates.of(0,0), actualTopLeft.getLast());
            }
        }

        @DisplayName("Should return 2 rows when piece is in end row")
        @Nested
        class EndRowScenarios {
            @DisplayName("Should return bottom left and right diagonals only when piece is in top row")
            @Test
            void shouldReturnBottomLeftAndRightDiagonalsWhenPieceIsInTopRow() {
                Position.Coordinates currentPosition = Position.Coordinates.of(0,3);
                Assertions.assertTrue(Piece.getTopLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getTopRightDiagonal(currentPosition).isEmpty());
                List<Position.Coordinates> expectedBottomLeftDiagonal = List.of(
                        Position.Coordinates.of(1, 2),
                        Position.Coordinates.of(2,1),
                        Position.Coordinates.of(3,0)
                );
                Assertions.assertEquals(expectedBottomLeftDiagonal, Piece.getBottomLeftDiagonal(currentPosition));
                List<Position.Coordinates> expectedBottomRightDiagonal = List.of(
                        Position.Coordinates.of(1,4),
                        Position.Coordinates.of(2,5),
                        Position.Coordinates.of(3,6),
                        Position.Coordinates.of(4,7)
                );
                Assertions.assertEquals(expectedBottomRightDiagonal, Piece.getBottomRightDiagonal(currentPosition));
            }

            @DisplayName("Should return top right and bottom right diagonals when piece is in left row")
            @Test
            void shouldReturnTopRightAndBottomRightDiagonalsWhenPieceIsInLeftRow() {
                Position.Coordinates currentPosition = Position.Coordinates.of(1,0);
                Assertions.assertTrue(Piece.getTopLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertTrue(Piece.getBottomLeftDiagonal(currentPosition).isEmpty());
                Assertions.assertEquals(List.of(Position.Coordinates.of(0,1)), Piece.getTopRightDiagonal(currentPosition));
                List<Position.Coordinates> actualBottomRightDiagonal = Piece.getBottomRightDiagonal(currentPosition);
                Assertions.assertEquals(6, actualBottomRightDiagonal.size());
                Assertions.assertEquals(Position.Coordinates.of(7,6), actualBottomRightDiagonal.getLast());
            }
        }
    }

    @DisplayName("Should return all 4 directions")
    @Nested
    class HorizontalScenarios {

        @DisplayName("Should return all 4 directions when piece is in center")
        @Test
        void shouldReturnAll4DiagonalsWhenPieceIsInCenter() {
            Position.Coordinates currentPosition = Position.Coordinates.of(4,4);
            Assertions.assertEquals(4, Piece.getTopVertical(currentPosition).size());
            Assertions.assertEquals(3, Piece.getBottomVertical(currentPosition).size());
            Assertions.assertEquals(4, Piece.getLeftHorizontal(currentPosition).size());
            Assertions.assertEquals(3, Piece.getRightHorizontal(currentPosition).size());
        }

        @DisplayName("Should return right and bottom when piece is in corner")
        @Test
        void shouldReturnRightAndBottomWhenPieceIsInTopLeftCorner() {
            Position.Coordinates currentPosition = Position.Coordinates.of(0,0);
            Assertions.assertEquals(0, Piece.getTopVertical(currentPosition).size());
            Assertions.assertEquals(0, Piece.getLeftHorizontal(currentPosition).size());
            Assertions.assertEquals(7, Piece.getRightHorizontal(currentPosition).size());
            Assertions.assertEquals(7, Piece.getBottomVertical(currentPosition).size());
        }

        @DisplayName("Should return left and bottom when piece is in corner")
        @Test
        void shouldReturnLeftAndBottomWhenPieceIsInTopRightCorner() {
            Position.Coordinates currentPosition = Position.Coordinates.of(0,7);
            Assertions.assertEquals(0, Piece.getTopVertical(currentPosition).size());
            Assertions.assertEquals(7, Piece.getLeftHorizontal(currentPosition).size());
            Assertions.assertEquals(0, Piece.getRightHorizontal(currentPosition).size());
            Assertions.assertEquals(7, Piece.getBottomVertical(currentPosition).size());
        }

        @DisplayName("Should return right and top when piece is in corner")
        @Test
        void shouldReturnRightAndTopWhenPieceIsInBottomLeftCorner() {
            Position.Coordinates currentPosition = Position.Coordinates.of(7,0);
            Assertions.assertEquals(7, Piece.getTopVertical(currentPosition).size());
            Assertions.assertEquals(0, Piece.getLeftHorizontal(currentPosition).size());
            Assertions.assertEquals(7, Piece.getRightHorizontal(currentPosition).size());
            Assertions.assertEquals(0, Piece.getBottomVertical(currentPosition).size());
        }

        @DisplayName("Should return left and top when piece is in corner")
        @Test
        void shouldReturnLeftAndTopWhenPieceIsInBottomRightCorner() {
            Position.Coordinates currentPosition = Position.Coordinates.of(7,7);
            Assertions.assertEquals(7, Piece.getTopVertical(currentPosition).size());
            Assertions.assertEquals(7, Piece.getLeftHorizontal(currentPosition).size());
            Assertions.assertEquals(0, Piece.getRightHorizontal(currentPosition).size());
            Assertions.assertEquals(0, Piece.getBottomVertical(currentPosition).size());
        }
    }
}