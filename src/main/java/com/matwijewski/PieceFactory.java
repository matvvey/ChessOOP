package com.matwijewski;

import com.matwijewski.piece.*;

public class PieceFactory {
    Piece fromFenChar(char fenChar, Coordinates coordinates) {
        return switch (fenChar) {
            case 'p' -> new Pawn(Color.BLACK, coordinates);
            case 'P' -> new Pawn(Color.WHITE, coordinates);

            case 'r' -> new Rook(Color.BLACK, coordinates);
            case 'R' -> new Rook(Color.WHITE, coordinates);

            case 'n' -> new Knight(Color.BLACK, coordinates);
            case 'N' -> new Knight(Color.WHITE, coordinates);

            case 'b' -> new Bishop(Color.BLACK, coordinates);
            case 'B' -> new Bishop(Color.WHITE, coordinates);

            case 'q' -> new Queen(Color.BLACK, coordinates);
            case 'Q' -> new Queen(Color.WHITE, coordinates);

            case 'k' -> new King(Color.BLACK, coordinates);
            case 'K' -> new King(Color.WHITE, coordinates);

            default -> throw new RuntimeException("Unknown FEN char");
        };
    }
}
