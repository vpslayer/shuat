import java.util.*;

// tag: dp
public class Robber {
    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, memo, nums.length-1);
    }
    // top-bottom recursive method
    private static int rob(int[] nums, int[] memo, int id) {
        if(id<0) return 0;
        if(memo[id] >=0) return memo[id];
        int result = Math.max(rob(nums, memo, id-2)+nums[id], rob(nums, memo, id-1));
        memo[id] = result;
        return result;
    }
    // bottom-up iterative method
    private static int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length+1]; // 1-based array
        memo[0]=0;memo[1]=nums[0];
        for(int i=1; i<nums.length; i++) {
            memo[i+1] = Math.max(memo[i], memo[i-1]+nums[i]);
        }
        return memo[nums.length];
    }
    // two pointer bottum-up iterative method
    private static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int pre1=0, pre2=0;
        for(int i: nums) {
            int tmp=pre1;
            pre1 = Math.max(i+pre2, pre1);
            pre2 = tmp;
        }
        return pre1;
    }
    public static void main(String[] args) {
        int[] arr =  {1,2,3,1};
        System.out.println("The max amount is " + rob2(arr));
    }
}