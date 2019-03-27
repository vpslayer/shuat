// type: dp, recursion
import java.util.Arrays;

public class CombinationSum4 {
    /** 
    private static int[] dp; // dp: class attribute; store intermediate results
    public static int combination(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;  
        return helper(nums, target);
    }
    private static int helper(int[] nums, int target) {
        // recursion stops when dp[x]!=-1
        if(dp[target]!=-1) return dp[target];
        int res=0;  // local val in method, reallocated with value 0 at each recursion call.
        for(int i=0; i<nums.length && target >= nums[i]; i++) {
            res += helper(nums, target-nums[i]);
        }
        dp[target]=res;
        return res;
    }
    */
    public static int combination(int[] nums, int target) {
        int[] res = new int[target+1];
        res[0] = 1;
        for(int i=1; i<res.length; i++) {
            for(int j=0; j<nums.length; j++) {
                if((i-nums[j])>=0) res[i] += res[i-nums[j]];
            }
        }
        return res[target];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int tar = 4;
        System.out.println("The different combinations is " + combination(nums, tar));
    }
}