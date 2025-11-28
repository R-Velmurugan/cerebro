package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BishopTest {

    private final Piece bishop = new Bishop(Constants.Color.LIGHT);

    @DisplayName("Should return all possible moves for bishop")
    @Test
    void shouldReturnAllPossibleMoves() {
        List<Position.Coordinates> possibleMoves = bishop.getPossibleMoves(Position.Coordinates.of(3, 3));
        Assertions.assertEquals(13, possibleMoves.size());
    }
}