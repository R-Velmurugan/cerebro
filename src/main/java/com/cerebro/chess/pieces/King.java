package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private Constants.Race race;

    @Override
    public Constants.Race getColor() {
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
    public List<Position.Coordinates> getPossibleMoves(@NonNull final Position.Coordinates from) {
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        populateKingMoves(Piece.getTopLeftDiagonal(from), possibleMoves);
        populateKingMoves(Piece.getTopVertical(from), possibleMoves);
        populateKingMoves(Piece.getTopRightDiagonal(from), possibleMoves);
        populateKingMoves(Piece.getRightHorizontal(from), possibleMoves);
        populateKingMoves(Piece.getBottomRightDiagonal(from), possibleMoves);
        populateKingMoves(Piece.getBottomVertical(from), possibleMoves);
        populateKingMoves(Piece.getBottomLeftDiagonal(from), possibleMoves);
        populateKingMoves(Piece.getLeftHorizontal(from), possibleMoves);
        return possibleMoves;
    }

    private void populateKingMoves(@NonNull final List<Position.Coordinates> allSquares, @NonNull List<Position.Coordinates> kingPossibleMoves){
        allSquares.stream()
                .findFirst()
                .ifPresent(kingPossibleMoves :: add);
    }
}
