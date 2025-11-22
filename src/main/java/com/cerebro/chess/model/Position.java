package com.cerebro.chess.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    @AllArgsConstructor
    @Getter
    public enum FenPosition {
        A8, B8, C8, D8, E8, F8, G8, H8,
        A7, B7, C7, D7, E7, F7, G7, H7,
        A6, B6, C6, D6, E6, F6, G6, H6,
        A5, B5, C5, D5, E5, F5, G5, H5,
        A4, B4, C4, D4, E4, F4, G4, H4,
        A3, B3, C3, D3, E3, F3, G3, H3,
        A2, B2, C2, D2, E2, F2, G2, H2,
        A1, B1, C1, D1, E1, F1, G1, H1;
    }
    @Getter
    private static final Map<Coordinates , FenPosition> FEN_POSITIONS;
    static {
        final Map<Coordinates, FenPosition> row1 = Map.of(Coordinates.of(0,0), FenPosition.A8, Coordinates.of(0,1), FenPosition.A8, Coordinates.of(0,2), FenPosition.C8, Coordinates.of(0,3), FenPosition.D8, Coordinates.of(0,4), FenPosition.E8, Coordinates.of(0,5), FenPosition.F8, Coordinates.of(0,6), FenPosition.G8, Coordinates.of(0,7), FenPosition.H8);
        final Map<Coordinates, FenPosition> row2 = Map.of(Coordinates.of(1,0), FenPosition.A7, Coordinates.of(1,1), FenPosition.A7, Coordinates.of(1,2), FenPosition.C7, Coordinates.of(1,3), FenPosition.D7, Coordinates.of(1,4), FenPosition.E7, Coordinates.of(1,5), FenPosition.F7, Coordinates.of(1,6), FenPosition.G7, Coordinates.of(1,7), FenPosition.H7);
        final Map<Coordinates, FenPosition> row3 = Map.of(Coordinates.of(2,0), FenPosition.A6, Coordinates.of(2,1), FenPosition.A6, Coordinates.of(2,2), FenPosition.C6, Coordinates.of(2,3), FenPosition.D6, Coordinates.of(2,4), FenPosition.E6, Coordinates.of(2,5), FenPosition.F6, Coordinates.of(2,6), FenPosition.G6, Coordinates.of(2,7), FenPosition.H6);
        final Map<Coordinates, FenPosition> row4 = Map.of(Coordinates.of(3,0), FenPosition.A5, Coordinates.of(3,1), FenPosition.A5, Coordinates.of(3,2), FenPosition.C5, Coordinates.of(3,3), FenPosition.D5, Coordinates.of(3,4), FenPosition.E5, Coordinates.of(3,5), FenPosition.F5, Coordinates.of(3,6), FenPosition.G5, Coordinates.of(3,7), FenPosition.H5);
        final Map<Coordinates, FenPosition> row5 = Map.of(Coordinates.of(4,0), FenPosition.A4, Coordinates.of(4,1), FenPosition.A4, Coordinates.of(4,2), FenPosition.C4, Coordinates.of(4,3), FenPosition.D4, Coordinates.of(4,4), FenPosition.E4, Coordinates.of(4,5), FenPosition.F4, Coordinates.of(4,6), FenPosition.G4, Coordinates.of(4,7), FenPosition.H4);
        final Map<Coordinates, FenPosition> row6 = Map.of(Coordinates.of(5,0), FenPosition.A3, Coordinates.of(5,1), FenPosition.A3, Coordinates.of(5,2), FenPosition.C3, Coordinates.of(5,3), FenPosition.D3, Coordinates.of(5,4), FenPosition.E3, Coordinates.of(5,5), FenPosition.F3, Coordinates.of(5,6), FenPosition.G3, Coordinates.of(5,7), FenPosition.H3);
        final Map<Coordinates, FenPosition> row7 = Map.of(Coordinates.of(6,0), FenPosition.A2, Coordinates.of(6,1), FenPosition.A2, Coordinates.of(6,2), FenPosition.C2, Coordinates.of(6,3), FenPosition.D2, Coordinates.of(6,4), FenPosition.E2, Coordinates.of(6,5), FenPosition.F2, Coordinates.of(6,6), FenPosition.G2, Coordinates.of(6,7), FenPosition.H2);
        final Map<Coordinates, FenPosition> row8 = Map.of(Coordinates.of(7,0), FenPosition.A1, Coordinates.of(7,1), FenPosition.A1, Coordinates.of(7,2), FenPosition.C1, Coordinates.of(7,3), FenPosition.D1, Coordinates.of(7,4), FenPosition.E1, Coordinates.of(7,5), FenPosition.F1, Coordinates.of(7,6), FenPosition.G1, Coordinates.of(7,7), FenPosition.H1);
        FEN_POSITIONS = new HashMap<>();
        FEN_POSITIONS.putAll(row1);
        FEN_POSITIONS.putAll(row2);
        FEN_POSITIONS.putAll(row3);
        FEN_POSITIONS.putAll(row4);
        FEN_POSITIONS.putAll(row5);
        FEN_POSITIONS.putAll(row6);
        FEN_POSITIONS.putAll(row7);
        FEN_POSITIONS.putAll(row8);
    }

    @Getter
    public static final class Coordinates {
        private final Integer row;
        private final Integer column;

        public static Coordinates of(int row, int column) {
            return new Coordinates(row, column);
        }

        private Coordinates(Integer row, Integer column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Coordinates coordinates)) return false;
            if(this == coordinates) return true;
            return Objects.equals(this.getRow(), coordinates.getRow()) && Objects.equals(this.getColumn(), coordinates.getColumn());
        }
    }
}
