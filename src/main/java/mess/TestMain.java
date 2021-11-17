package mess;


import java.util.HashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        int[][] rectangles = new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        //int[][] rectangles = new int[][]{{0, 0, 1, 1}, {0, 1, 3, 2}, {1, 0, 2, 2}};
        System.out.println(isRectangleCover(rectangles));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        int rangeSum = 0;
        int[] minRangeX = new int[]{rectangles[0][0], rectangles[0][1], rectangles[0][2], rectangles[0][3]};
        int[] minRangeY = new int[]{rectangles[0][0], rectangles[0][1], rectangles[0][2], rectangles[0][3]};
        Map<String,Integer> mapCount = new HashMap<>(1);
        for (int[] range : rectangles) {
            rangeSum += calculateRange(range);
            if (range[0] <= minRangeX[0] && range[1] <= minRangeX[1]) {
                minRangeX[0] = range[0];
                minRangeX[1] = range[1];
            }
            if (range[2] >= minRangeX[2] && range[3] >= minRangeX[3]) {
                minRangeX[2] = range[2];
                minRangeX[3] = range[3];
            }
            if (range[0] <= minRangeY[0] && range[3] >= minRangeY[1]) {
                minRangeY[0] = range[0];
                minRangeY[1] = range[3];
            }
            if (range[2] >= minRangeY[2] && range[1] <= minRangeY[3]) {
                minRangeY[2] = range[2];
                minRangeY[3] = range[1];
            }
        }
        int rangeActualX = calculateRange(minRangeX);
        int rangeActualY = calculateRange(minRangeY);
        if (rangeSum == rangeActualX && rangeActualX == rangeActualY) {

        }
        return false;
    }

    public static int calculateRange(int[] rectangle) {
        if (null == rectangle || rectangle.length != 4) {
            return 0;
        }
        int result = (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        return result < 0 ? -result : result;
    }
}
