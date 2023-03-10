public class searMatrix {
    /**     二维数组的二分查找
     从矩阵的右上角开始搜索，如果当前值大于目标值，则向左移动一列，如果当前值小于目标值，则向下移动一行。

     重复步骤1直到找到目标值或者搜索完整个矩阵。

     由于每行和每列的元素都是升序排列的，所以从右上角开始搜索可以保证每次移动都能减少可能的情况。*/
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix,20));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        boolean bool = false;
        int row = 0;
        int col = matrix[0].length-1;
        while (col>=0&&row<matrix.length){
            if (matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            }else {
                row++;
            }
        }
        return bool;
    }

    public static boolean seaMatrix(int[][] matrix, int target){
        boolean bool = false;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] > target)
                return false;
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == target)
                    return true;
                else if (matrix[i][j] > target) {
                    break;
                }
            }
        }
        return bool;
    }

}
