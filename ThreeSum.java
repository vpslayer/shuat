import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public static List<List<Integer>> arrRes(int[] num)  {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<num.length -2; i++) {
            if(i==0 || num[i] != num[i-1]) {
                int sum = 0 - num[i];
                int lo = i+1, hi = num.length-1;
                while(lo < hi) {
                    if(num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while(lo<hi && num[lo+1]==num[lo]) lo++;
                        while(lo<hi && num[hi-1]==num[hi]) hi--;
                        lo++;
                        hi--;
                    } else if(num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] testArr = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(arrRes(testArr));
    }
}
