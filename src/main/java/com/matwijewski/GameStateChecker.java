package com.matwijewski;

import com.matwijewski.board.Board;

public abstract class GameStateChecker {
    public abstract GameState check (Board board, Color color);
}
