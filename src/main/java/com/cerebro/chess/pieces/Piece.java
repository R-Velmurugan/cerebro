package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import jakarta.annotation.Nonnull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Piece {
    abstract Constants.Race getRace();
    abstract Constants.PieceType getType();
    abstract boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to);
    abstract List<Position.Coordinates> getPossibleMoves(Position.Coordinates from);

    protected static List<Position.Coordinates> getTopLeftDiagonal(@Nonnull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getRow()-i >= 0 && currentPosition.getColumn()-i >=0, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()-i, currentPosition.getColumn()-i))
                .collect(Collectors.toList());
    }

    protected static List<Position.Coordinates> getTopRightDiagonal(@Nonnull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i-> currentPosition.getRow()-i >=0 && currentPosition.getColumn()+i <= 7, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()-i, currentPosition.getColumn()+i))
                .collect(Collectors.toList());
    }
}
