package com.cerebro.chess.pieces;

import com.cerebro.chess.model.Constants;
import com.cerebro.chess.model.Position;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private final Constants.Color color;

    public Pawn(Constants.Color color) {
        this.color = color;
    }

    @Override
    Constants.Color getColor() {
        return color;
    }

    private Position.Coordinates currentPosition;

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
        return Constants.PieceType.PAWN;
    }

    @Override
    boolean moveIfPossible(Position.FenPosition from, Position.FenPosition to) {
        return false;
    }

    @Override
    @NonNull
    public List<Position.Coordinates> getPossibleMoves() {
        Position.Coordinates currentPosition = this.getCoordinates();
        List<Position.Coordinates> possibleMoves = new ArrayList<>();
        if(this.getColor().equals(Constants.Color.DARK)){
            if(currentPosition.getRow() == 7) possibleMoves.add(Position.Coordinates.of(5, currentPosition.getColumn()));
            if(currentPosition.getRow() > 0) possibleMoves.add(Position.Coordinates.of(currentPosition.getRow()-1, currentPosition.getColumn()));
        }
        else if(this.getColor().equals(Constants.Color.LIGHT)){
            if(currentPosition.getRow() == 1) possibleMoves.add(Position.Coordinates.of(3, currentPosition.getColumn()));
            if(currentPosition.getRow() < 8) possibleMoves.add(Position.Coordinates.of(currentPosition.getRow()+1, currentPosition.getColumn()));
        }
        return possibleMoves;
    }
}
