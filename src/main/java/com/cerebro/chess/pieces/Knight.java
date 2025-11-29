package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    private final Constants.Color knightColor;
    private Position.Coordinates currentPosition;

    public Knight(Constants.Color knightColor) {
        this.knightColor = knightColor;
    }

    @Override
    public Constants.Color getColor() {
        return knightColor;
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
    @NonNull
    public Constants.PieceType getType() {
        return Constants.PieceType.KNIGHT;
    }

    @Override
    public boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    @NonNull
    public List<Position.Coordinates> getPossibleMoves(@NonNull final Position.Coordinates currentPosition) {
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        this.getPosition(-2, -1).ifPresent(possibleMoves::add);
        this.getPosition(-1, -2).ifPresent(possibleMoves::add);
        this.getPosition(2, -1).ifPresent(possibleMoves::add);
        this.getPosition(1, -2).ifPresent(possibleMoves::add);
        this.getPosition(-2, 1).ifPresent(possibleMoves::add);
        this.getPosition(-1, 2).ifPresent(possibleMoves::add);
        this.getPosition(2, 1).ifPresent(possibleMoves::add);
        this.getPosition(1, 2).ifPresent(possibleMoves::add);
        return possibleMoves;
    }
}
