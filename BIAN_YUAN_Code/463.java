/**
 * 岛屿周长
 * Created by tianning.htn 2017/2/13
 */
public class IslandPerimeter {

    /**
     * 计算周长
     * 有1周长就+4，有相邻就-2
     * @param 二维数组
     * @return 周长
     */
    public static String getPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;

                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int input[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(getPerimeter(input));
    }

}
