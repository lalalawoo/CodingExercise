public class Q304_Range_Sum_Query_2D_Immutable {
    
    private static int[][] matrix;
    private static int[][] sum;

    public Q304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        this.matrix = matrix;
        sum=new int[matrix.length][matrix[0].length];
        sum[0][0]=matrix[0][0];
        for(int i=1;i<matrix.length;i++){
            sum[i][0]=sum[i-1][0]+matrix[i][0];
            System.out.println("sum["+i+"][0]="+sum[i][0]);
        }
        for(int j=1;j<matrix[0].length;j++){
            sum[0][j]=sum[0][j-1]+matrix[0][j];
            System.out.println("sum[0]["+j+"]="+sum[0][j]);
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                sum[i][j]=matrix[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
                System.out.println("sum["+i+"]["+j+"]="+sum[i][j]);
            }
        }
        int temp=matrix[3][4];
        System.out.println("matrix[3][4]="+ temp);
        System.out.println("sum[3][4]="+sum[3][4]);
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        int result=sum[row2][col2];
        if(row1>0){
            result=result-sum[row1-1][col2];
        }
        if(row2>0){
            result=result-sum[row2][col1-1]+(row1>0?sum[row1-1][col1-1]:sum[row1][col1-1]);
        }
        return result;
    }
    
    public static void main(String[] args){
    	int[][] testmatrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
    	Q304_Range_Sum_Query_2D_Immutable test = new Q304_Range_Sum_Query_2D_Immutable(testmatrix);
    	int rs1 = test.sumRegion(0, 1, 2, 3);
    	System.out.println(rs1);
    	int rs2 = test.sumRegion(1, 2, 3, 4);
    	System.out.println(rs2);
    }
}
