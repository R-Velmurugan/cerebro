package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Piece {
    abstract Constants.Color getColor();
    abstract Position.Coordinates getCoordinates();
    abstract void setCoordinates(Position.Coordinates coordinates);
    abstract Constants.PieceType getType();
    abstract boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to);
    abstract List<Position.Coordinates> getPossibleMoves();

    @NonNull
    protected static List<Position.Coordinates> getTopLeftDiagonal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getRow()-i >= 0 && currentPosition.getColumn()-i >=0, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()-i, currentPosition.getColumn()-i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getTopRightDiagonal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i-> currentPosition.getRow()-i >=0 && currentPosition.getColumn()+i <= 7, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()-i, currentPosition.getColumn()+i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getBottomLeftDiagonal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i-> currentPosition.getRow()+i <= 7 && currentPosition.getColumn()-i >= 0, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()+i, currentPosition.getColumn()-i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getBottomRightDiagonal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getRow()+i <= 7 && currentPosition.getColumn()+i <= 7, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()+i, currentPosition.getColumn()+i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getTopVertical(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getRow()-i >= 0, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()-i, currentPosition.getColumn()))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getBottomVertical(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getRow()+i <= 7, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow()+i, currentPosition.getColumn()))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getLeftHorizontal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getColumn()-i >= 0, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow(), currentPosition.getColumn()-i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected static List<Position.Coordinates> getRightHorizontal(@NonNull final Position.Coordinates currentPosition) {
        return IntStream
                .iterate(1, i -> currentPosition.getColumn()+i <= 7, i -> i+1)
                .mapToObj(i -> Position.Coordinates.of(currentPosition.getRow(), currentPosition.getColumn()+i))
                .collect(Collectors.toList());
    }

    @NonNull
    protected Optional<Position.Coordinates> getPosition(final int rowIncrements, final int columnIncrements ) {
        final int finalRow = this.getCoordinates().getRow() + rowIncrements;
        final int finalColumn = this.getCoordinates().getColumn() + columnIncrements;

        if(finalRow < 0 || finalColumn < 0 || finalRow > 7 || finalColumn > 7) {
            return Optional.empty();
        }
        return Optional.of(Position.Coordinates.of(finalRow, finalColumn));
    }
}
