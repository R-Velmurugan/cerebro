package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    private final Constants.Color bishopColor;
    private Position.Coordinates currentPosition;

    public Bishop(Constants.Color bishopColor) {
        this.bishopColor = bishopColor;
    }

    @Override
    Constants.Color getColor() {
        return bishopColor;
    }

    @Override
    Position.Coordinates getCoordinates() {
        return this.currentPosition;
    }

    @Override
    void setCoordinates(Position.Coordinates coordinates) {
        this.currentPosition = coordinates;
    }

    @Override
    Constants.PieceType getType() {
        return Constants.PieceType.BISHOP;
    }

    @Override
    boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    List<Position.Coordinates> getPossibleMoves(Position.Coordinates currentPosition) {
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(Piece.getTopLeftDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getTopRightDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getBottomLeftDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getBottomRightDiagonal(currentPosition));
        return possibleMoves;
    }
}
