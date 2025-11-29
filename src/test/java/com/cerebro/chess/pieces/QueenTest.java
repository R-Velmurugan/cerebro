package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class QueenTest {
    Piece queen = new Queen(Constants.Color.DARK);

    @BeforeEach
    void setUp() {
        queen.setCoordinates(Position.Coordinates.of(4,4));
    }

    @DisplayName("Should return all possible moves for queen")
    @Test
    void shouldReturnAllPossibleMoves() {
        List<Position.Coordinates> actual = queen.getPossibleMoves();
        Assertions.assertEquals(27, actual.size());
    }
}