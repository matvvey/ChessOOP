package com.matwijewski.piece;

import com.matwijewski.board.Board;
import com.matwijewski.Color;
import com.matwijewski.Coordinates;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop{
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getBishopMoves();
    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        return super.isSquareAvailableForAttack(coordinates, board);
    }
}
