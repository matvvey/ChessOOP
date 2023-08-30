package com.matwijewski;

import com.matwijewski.board.Board;
import com.matwijewski.piece.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardConsoleRenderer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";

    public void render(Board board, Piece pieceToMove) {
        Set<Coordinates> availableMoveSquares = emptySet();
        if (pieceToMove != null) {
            availableMoveSquares = pieceToMove.getAvailableMoveSquares(board);
        }


        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);

                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates, isHighlight);
                } else {
                    line += getPieceSprite(board.getPiece(coordinates), isHighlight);
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    public void render(Board board) {
        render(board, null);
    }

        private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighLight) {
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighLight){
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighLight) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates), isHighLight);
    }

    private String selectUnicodeSprite(Piece piece) {
        return switch (piece.getClass().getSimpleName()) {
            case "Pawn" -> "♙";
            case "Knight" -> "♘";
            case "Bishop" -> "♗";
            case "Rook" -> "♖";
            case "Queen" -> "♕";
            case "King" -> "♔";
            default -> "error";
        };

    }

    private String getPieceSprite(Piece piece, boolean isHighLight) {
        return colorizeSprite(
                "   " + selectUnicodeSprite(piece) + "   ", piece.color, Board.isSquareDark(piece.coordinates), isHighLight
                //        - another types of spaces
        );
    }
}

