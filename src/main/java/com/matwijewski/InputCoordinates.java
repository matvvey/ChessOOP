package com.matwijewski;

import com.matwijewski.piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
        while (true) {
            System.out.println("Please enter coordinates (ex. a1).");

            //a1
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid format: no cell at this number. Maximum numbers of cells is 8.");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format: first character must be a letter.");
                continue;
            }
            if (!Character.isDigit(rankChar)) {
                System.out.println("Invalid format: second character must be a digit.");
                continue;
            }
            int rank = Character.getNumericValue(rankChar);
            if (rankChar < 1 || rank > 8) {
                System.out.println("Invalid format.");
                continue;
            }

            File file = File.fromChar(fileChar);
            if (file == null) {
                System.out.println("Invalid format: incorrect cell. Available cells are in a1 - h8.");
                continue;
            }
            return new Coordinates(file, rank);

        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("Enter coordinates for a piece to move");
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.out.println("Wrong color");
                continue;
            }
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
            if (availableMoveSquares.size() == 0) {
                System.out.println("Blocked piece");
                continue;
            }

            return coordinates;
        }
    }

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Enter your move for a selected piece");
            Coordinates input = input();

            if (!coordinates.contains(input)) {
                System.out.println("Non-available square");
                continue;
            }
            return input;
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecePositions();
        Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
        System.out.println(coordinates);
    }
}
