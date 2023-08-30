package com.matwijewski.piece;

import com.matwijewski.Color;
import com.matwijewski.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Rook extends LongRangePiece implements IRook {
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        return getRookMoves();
    }

}
