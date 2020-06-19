import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length <= 2) return result;
        int prevElement = nums[0];
        result.addAll(customTwoSum(nums, 1, nums[0] * -1));
        for(int i = 1; i < nums.length - 2; i++) {
            if(prevElement == nums[i]) continue;
            result.addAll(customTwoSum(nums, i+1, nums[i] * -1));
            prevElement = nums[i];
        }
        return result;
    }

    public List<List<Integer>> customTwoSum(int[] nums, int start, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int prevNumber = 0;
        for (int i = start; i < nums.length-1; i++) {
            List<Integer> result = new ArrayList<>();
            result.add(target * -1);
            result.add(nums[i]);
            if(i == start) {
                prevNumber = nums[i];
            } else if( nums[i] == prevNumber) {
                continue;
            }
            int binaryResultIndex = searchbinary(nums, i+1, nums.length-1, target-nums[i]);
            if(binaryResultIndex != -1) {
                result.add(nums[binaryResultIndex]);
                results.add(result);
            }
            prevNumber = nums[i];
        }
        return results;
    }

    public int searchbinary(int[] nums, int start, int end, int target) {
        if(start > end) return - 1;
        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchbinary(nums, start, mid-1, target);
        } else {
            return searchbinary(nums, mid+1, end, target);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> resultList = new Sum3().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(resultList.size());
    }
}
