package com.matwijewski;
import java.util.ArrayList;
import java.util.List;

public class BoardUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates source, Coordinates target) {


        List <Coordinates> result = new ArrayList<>();

        int fileShift = source.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rankShift = source.rank < target.rank ? 1 : -1;

        for (
                int fileIndex = source.file.ordinal() + fileShift,
                rank = source.rank + rankShift;

                fileIndex != target.file.ordinal() && rank != target.rank;

                fileIndex += fileShift, rank += rankShift
        ) {
            result.add (new Coordinates(File.values()[fileIndex], rank));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Coordinates> list = getDiagonalCoordinatesBetween(new Coordinates(File.D, 4), new Coordinates(File.G, 7));
        System.out.println(list);
    }
}
