public class 62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        if(m+n<2){
            return 0;
        }
        //   Time Complexity O(mn), space complexity O(mn)
        //
        // int[][] dp = new int[m][n];
        // for(int i=0;i<m;i++){
        //     dp[i][0]=1;
        // }
        // for(int j=0;j<n;j++){
        //     dp[0][j]=1;
        // }
        
        // for(int i=1;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         dp[i][j]=dp[i-1][j]+dp[i][j-1];
        //     }
        // }
        // return dp[m-1][n-1];
        
        // optimize the space complexity to O(n)
        
        int[] dp = new int[n];
        for(int j=0;j<n;j++){
            dp[j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n-1];
    }
}
