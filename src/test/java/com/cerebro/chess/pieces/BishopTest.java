package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BishopTest {

    private final Piece bishop = new Bishop(Constants.Color.LIGHT);

    @BeforeEach
    void setUp() {
        bishop.setCoordinates(Position.Coordinates.of(3, 3));
    }

    @DisplayName("Should return all possible moves for bishop")
    @Test
    void shouldReturnAllPossibleMoves() {
        List<Position.Coordinates> possibleMoves = bishop.getPossibleMoves();
        Assertions.assertEquals(13, possibleMoves.size());
    }
}