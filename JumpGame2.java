import java.util.HashMap;
import java.util.Map;

public class JumpGame2 {

    Map<Integer, Integer> memoize;
    public int jump(int[] nums) {
        memoize = new HashMap<>();
        return jumpRec(nums, nums.length-1);
    }

    public int jumpRec(int[] nums, int endIndex) {
        if( endIndex == 0) return 0;
        if(memoize.containsKey(endIndex)) {
            return memoize.get(endIndex);
        }
        int min = Integer.MAX_VALUE;
        boolean isDirty = false;
        for( int i = endIndex-1; i >= 0; i--) {
            if( nums[i] >= endIndex-i) {
                int jumps = jumpRec(nums, i)+1;
                if( jumps > 0 && jumps < min) {
                    min = jumps;
                    isDirty = true;
                }
            }
        }
        if( isDirty) {
            memoize.put(endIndex, min);
            return min;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(new JumpGame2().jump(nums));
    }
}
