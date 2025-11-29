package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class KingTest {

    Piece king = new King(Constants.Color.DARK);

    @DisplayName("Should return all possible moves when King is in center")
    @Test
    void shouldReturnAllPossibleMovesWhenKingIsInCenter() {
        king.setCoordinates(Position.Coordinates.of(4, 4));
        List<Position.Coordinates> expected = List.of(
                Position.Coordinates.of(3,3),
                Position.Coordinates.of(3,4),
                Position.Coordinates.of(3,5),
                Position.Coordinates.of(4,5),
                Position.Coordinates.of(5,5),
                Position.Coordinates.of(5,4),
                Position.Coordinates.of(5,3),
                Position.Coordinates.of(4,3)
        );
        Assertions.assertEquals(expected, king.getPossibleMoves());
    }

    @DisplayName("Should return 3 positions when King is in corner")
    @Test
    void shouldReturn3PositionsWhenKingIsInCorner() {
        king.setCoordinates(Position.Coordinates.of(0,0));
        Assertions.assertEquals(3, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(0,7));
        Assertions.assertEquals(3, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(7,7));
        Assertions.assertEquals(3, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(7,0));
        Assertions.assertEquals(3, king.getPossibleMoves().size());
    }

    @DisplayName("Should return 5 positions when King is in border row")
    @Test
    void shouldReturn5PositionsWhenKingIsInBorderRow() {
        king.setCoordinates(Position.Coordinates.of(4,0));
        Assertions.assertEquals(5, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(0,4));
        Assertions.assertEquals(5, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(4,7));
        Assertions.assertEquals(5, king.getPossibleMoves().size());
        king.setCoordinates(Position.Coordinates.of(7,4));
        Assertions.assertEquals(5, king.getPossibleMoves().size());
    }
}