package com.matwijewski;

import com.matwijewski.board.Board;
import com.matwijewski.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = (new BoardFactory()).fromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Game game = new Game(board);
        game.gameLoop();

                /* If you want to create a standard start position for pieces you can use FEN code below.
        Also, you can change this FEN code in constructor "Board" as you want (for example - you can use editor on website lichess.org to make
        different positions of board and take FEN code from there).
         */
    }
}