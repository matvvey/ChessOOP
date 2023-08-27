package com.matwijewski;

import com.matwijewski.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecePositions();

//        BoardFactory boardFactory = new BoardFactory();

        Board board = (new BoardFactory()).fromFEN(
//                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
                "3k4/8/5n2/2N5/3B4/8/8/3K4 w - - 0 1"
        );

        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
//        renderer.render(board);

//       Piece piece = board.getPiece(new Coordinates(File.B, 8));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//
//        int a = 123;

        Game game = new Game(board);
        game.gameLoop();
    }
}