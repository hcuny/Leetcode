/**
 * �����ܳ�
 * Created by tianning.htn 2017/2/13
 */
public class IslandPerimeter {

    /**
     * �����ܳ�
     * ��1�ܳ���+4�������ھ�-2
     * @param ��ά����
     * @return �ܳ�
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