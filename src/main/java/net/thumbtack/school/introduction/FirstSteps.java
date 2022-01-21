package net.thumbtack.school.introduction;

public class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int elem : array) {
            sum += elem;
        }
        return sum;
    }

    public int mul(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int mul = 1;
        for (int elem : array) {
            mul *= elem;
        }
        return mul;
    }

    public int min(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int elem : array) {
            if (elem < minValue) {
                minValue = elem;
            }
        }
        return minValue;
    }

    public int max(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int elem : array) {
            if (elem > maxValue) {
                maxValue = elem;
            }
        }
        return maxValue;
    }

    public double average(int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        return ((double) sum(array)) / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int elem : array) {
            if (elem == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            sum += sum(ints);
        }
        return sum;
    }

    public int max(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            if (max(ints) > maxValue) {
                maxValue = max(ints);
            }
        }
        return maxValue;
    }

    public int diagonalMax(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 0) {
                if (matrix[i][i] > maxValue) {
                    maxValue = matrix[i][i];
                }
            }
        }
        return maxValue;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] ints : matrix) {
            if (!isSortedDescendant(ints)) {
                return false;
            }
        }
        return true;
    }
}
