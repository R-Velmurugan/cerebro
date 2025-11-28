package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QueenTest {
    Piece queen = new Queen(Constants.Color.DARK);
    @Test
    void getPossibleMoves() {
        List<Position.Coordinates> actual = queen.getPossibleMoves(Position.Coordinates.of(4,4));
        Assertions.assertEquals(27, actual.size());
    }
}