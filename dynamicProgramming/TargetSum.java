public class TargetSum {
        // Sum(Positive) - Sum(Negative) = target => Sum(Positive) = (Sum(nums)+target) / 2 
        // => 求数组中和为xx的子集个数 => 0-1背包
        public static int findSums(int[] nums, int target) {
            int sum = 0;
            for(int i: nums) {
                sum += i;
            }
            // >>> symbol : unsigned right shift 可以防止int值溢出
            // >> : signed right shift 符号位不动
            return sum < target || (sum + target) % 2 != 0 ? 0 : subSetNum(nums, (sum + target) >>> 1);
        }

        private static int subSetNum(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            // 0-1背包问题 动态规划
            for(int i: nums) {
                for(int j = target; j >= i; j--) {
                    dp[j] += dp[j - i];
                }
            }
            return dp[target];
        }

        public static void main(String[] args) {
            int[] nums = {1, 1, 1, 1, 1};
            int tar = 3;
            System.out.println(findSums(nums, tar));
        }
}
