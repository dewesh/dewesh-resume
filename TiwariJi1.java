import java.util.Arrays;

public class TiwariJi1 {
    public int[] process(int[] nums) {
        int mul = 1;
        boolean isZero = false;
        boolean isMultipleZero = false;
        for(int i =0 ;i < nums.length;i++) {
            if(nums[i] == 0) {
                if( isZero ) isMultipleZero = true;
                isZero = true;
                continue;
            }
            mul*= nums[i];
        }
        for(int i =0 ;i < nums.length;i++) {
            if(isMultipleZero) { nums[i] = 0; continue;}
            if(nums[i] == 0) {
                nums[i] = mul;
            } else if ( isZero) {
                nums[i] = 0;
            } else {
                nums[i] = (int)mul / nums[i];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3, 0, 0};
        int[] result = new TiwariJi1().process(nums);
        System.out.println(Arrays.toString(nums));
    }
}
