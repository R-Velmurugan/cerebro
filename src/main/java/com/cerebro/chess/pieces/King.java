package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import com.cerebro.chess.utils.BoardUtils;

import java.util.List;

public class King extends Piece{
    private Constants.Race race;
    @Override
    public Constants.Race getRace() {
        return this.race;
    }

    @Override
    public Constants.PieceType getType() {
        return Constants.PieceType.KING;
    }

    @Override
    public boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    public List<Position.Coordinates> getPossibleMoves(Position.Coordinates from) {
        return List.of(
//                BoardUtils.getTopLeftDiagonalSquares(from).
        );
    }

    private static List<Position.Coordinates> getPossibleMovesForCorners(Position.Coordinates from){
        return List.of();
    }

}
