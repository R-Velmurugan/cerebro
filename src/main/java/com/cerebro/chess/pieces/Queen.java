package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    private final Constants.Color color;
    private Position.Coordinates currentPosition;
    public Queen(@NonNull final Constants.Color color) {
        this.color = color;
    }

    @Override
    public Constants.Color getColor() {
        return this.color;
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
    public Constants.PieceType getType() {
        return Constants.PieceType.QUEEN;
    }

    @Override
    public boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    @NonNull
    public List<Position.Coordinates> getPossibleMoves() {
        Position.Coordinates currentPosition = this.getCoordinates();
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(Piece.getTopLeftDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getTopVertical(currentPosition));
        possibleMoves.addAll(Piece.getTopRightDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getRightHorizontal(currentPosition));
        possibleMoves.addAll(Piece.getBottomRightDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getBottomVertical(currentPosition));
        possibleMoves.addAll(Piece.getBottomLeftDiagonal(currentPosition));
        possibleMoves.addAll(Piece.getLeftHorizontal(currentPosition));
        return possibleMoves;
    }
}
