import java.util.*;

public class Q264_Ugly_Number_II {
    public static int nthUglyNumber(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        int pos2 = 0;
        int pos3 = 0;
        int pos5 = 0;
        while(result.size()<n){
        	System.out.println(result.size());
        	System.out.println(result.get(result.size()-1));
            int nextNumber = Math.min(result.get(pos2)*2, Math.min(result.get(pos3)*3, result.get(pos5)*5));
            if(nextNumber==result.get(pos2)*2){
                pos2++;
            }
            if(nextNumber==result.get(pos3)*3){
                pos3++;
            } 
            if(nextNumber==result.get(pos5)*5){
                pos5++;
            }
            result.add(nextNumber);
        }
        System.out.println(result);
        return result.get(result.size()-1);
    }
    
	public static void main(String[] args) {
		int rs = nthUglyNumber(7);
		System.out.println(rs);

	}
}
