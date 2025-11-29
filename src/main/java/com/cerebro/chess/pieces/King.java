package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private final Constants.Color color;
    private Position.Coordinates currentPosition;

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

    public King(@NonNull final Constants.Color color) {
        this.color = color;
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
    @NonNull
    public List<Position.Coordinates> getPossibleMoves() {
        final Position.Coordinates currentPosition = this.getCoordinates();
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        populateKingMoves(Piece.getTopLeftDiagonal(currentPosition), possibleMoves);
        populateKingMoves(Piece.getTopVertical(currentPosition), possibleMoves);
        populateKingMoves(Piece.getTopRightDiagonal(currentPosition), possibleMoves);
        populateKingMoves(Piece.getRightHorizontal(currentPosition), possibleMoves);
        populateKingMoves(Piece.getBottomRightDiagonal(currentPosition), possibleMoves);
        populateKingMoves(Piece.getBottomVertical(currentPosition), possibleMoves);
        populateKingMoves(Piece.getBottomLeftDiagonal(currentPosition), possibleMoves);
        populateKingMoves(Piece.getLeftHorizontal(currentPosition), possibleMoves);
        return possibleMoves;
    }

    private void populateKingMoves(@NonNull final List<Position.Coordinates> allSquares, @NonNull List<Position.Coordinates> kingPossibleMoves){
        allSquares.stream()
                .findFirst()
                .ifPresent(kingPossibleMoves :: add);
    }
}
