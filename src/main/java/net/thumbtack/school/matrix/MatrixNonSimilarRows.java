package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private Map<Set<Integer>, int[]> matrixNonSimilar;

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixNonSimilar = new HashMap<>();
        for (int[] ints : matrix) {
            Set<Integer> set = new HashSet<>();
            for (int anInt : ints) {
                set.add(anInt);
            }
            matrixNonSimilar.putIfAbsent(set, ints);
        }
    }

    public Set<int[]> getNonSimilarRows() {
        return new HashSet<>(matrixNonSimilar.values());
    }
}
