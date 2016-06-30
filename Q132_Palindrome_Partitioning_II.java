public class Q132_Palindrome_Partitioning_II {
    public static int minCut(String s) {
    	
//Method1 n^3 Time Limit Exceeded
//
//        if(s.length()<=1){
//            return 0;
//        }
//        int dp[][] = new int[s.length()][s.length()];
//        for(int i=0;i<s.length();i++){
//        	dp[i][i]=0;
//        }
//        for(int len=2;len<=s.length();len++){
//        	for(int i=0;i<=s.length()-len;i++){
//        		int j=i+len-1;
//        		dp[i][j]=len-1;
//        		if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1]==0||len==2)){
//        			dp[i][j]=0;
//        			System.out.println("i="+i+" j="+j+" dp="+dp[i][j]);
//        			continue;
//        		}
//        		for(int k=i+1;k<=j;k++){
//        			dp[i][j]=Math.min(dp[i][j],dp[i][k-1]+dp[k][j]+1);
//        		}
//        		System.out.println("i="+i+" j="+j+" dp="+dp[i][j]);
//        	}
//        }
//        return dp[0][s.length()-1];

//Method2 n^2   
    	
    	if(s.length()<=1){
    		return 0;
    	}
    	boolean[][] isPal = new boolean[s.length()][s.length()];
    	for(int i=0;i<s.length();i++){
    		isPal[i][i]=true;
    	}
    	for(int len=2;len<=s.length();len++){
    		for(int i=0;i<=s.length()-len;i++){
    			int j=i+len-1;
    			if(s.charAt(i)==s.charAt(j) && (isPal[i+1][j-1]==true||len==2)){
        			isPal[i][j]=true;
        		}
    		}
    	}
    	
    	if(isPal[0][s.length()-1]){
    		return 0;
    	}
    	
    	int[] dp = new int[s.length()+1];
    	dp[0]=-1;
    	dp[1]=0;
    	for(int i=2;i<=s.length();i++){
    		dp[i]=i-1;
    		if(isPal[0][i-1]){
    			dp[i]=0;
    			continue;
    		}
    		for(int j=1;j<i;j++){
    			if(isPal[j][i-1]){
    				dp[i]=Math.min(dp[i], dp[j]+1);
    			}
    		}    		
    	}
    	return dp[s.length()];    
    }
    
    
    public static void main(String[] args){
    	String test="bb";
    	int rs = minCut(test);
    	System.out.println(rs);
    }
}
