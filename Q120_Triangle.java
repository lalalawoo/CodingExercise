public class Q120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        int[] res = new int[triangle.size()];
        res[0]=triangle.get(0).get(0);
        int left=res[0];
        int right=res[0];
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    res[j]=right+triangle.get(i).get(j);
                }else if(j==i){
                    res[j]=left+triangle.get(i).get(j);
                }else{
                    res[j]=triangle.get(i).get(j)+Math.min(left,right);
                }
                left=right;
                right=j==i?res[0]:res[j+1];
            }
        }
        int minTotal = res[0];
        for(int i=1;i<res.length;i++){
            minTotal=Math.min(minTotal,res[i]);
        }
        return minTotal;
    }
}
