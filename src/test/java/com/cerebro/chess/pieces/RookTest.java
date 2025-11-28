package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RookTest {
    private final Piece rook = new Rook(Constants.Color.LIGHT);

    @DisplayName("Should return possible moves for rook")
    @Test
    void shouldReturnPossibleMovesForRook() {
        List<Position.Coordinates> possibleMoves = rook.getPossibleMoves(Position.Coordinates.of(5,5));
        Assertions.assertEquals(14, possibleMoves.size());
    }
}