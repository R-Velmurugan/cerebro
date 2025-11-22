package com.cerebro.chess.utils;

import com.cerebro.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {
    public static List<Position.Coordinates> getTopLeftDiagonalSquares(Position.Coordinates from) {
        List<Position.Coordinates> result = new ArrayList<>();
        getTopLeftDiagonalSquares(from, result);
        return result;
    }

    private static void getTopLeftDiagonalSquares(Position.Coordinates square, List<Position.Coordinates> result){
        if(square.getRow() < 0 || square.getColumn() < 0) return;
        result.add(square);
        BoardUtils.getTopLeftDiagonalSquares(Position.Coordinates.of(square.getRow()-1, square.getColumn()-1), result);
    }
}
