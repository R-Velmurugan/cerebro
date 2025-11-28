package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    private final Constants.Color color;

    public Rook(Constants.Color color) {
        this.color = color;
    }

    @Override
    Constants.Color getColor() {
        return color;
    }

    @Override
    Constants.PieceType getType() {
        return Constants.PieceType.ROOK;
    }

    @Override
    boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    @NonNull
    public List<Position.Coordinates> getPossibleMoves(Position.Coordinates currentPosition) {
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(Piece.getTopVertical(currentPosition));
        possibleMoves.addAll(Piece.getBottomVertical(currentPosition));
        possibleMoves.addAll(Piece.getLeftHorizontal(currentPosition));
        possibleMoves.addAll(Piece.getRightHorizontal(currentPosition));
        return possibleMoves;
    }
}
