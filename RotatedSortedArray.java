public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) {
            return -1;
        }
        if(len == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = getPivot(nums, 0, len);
        int leftResult = searchBinary(nums, target, 0, pivot-1);
        int rightResult = searchBinary(nums, target, pivot, len-1);
        if(leftResult != -1) {
            return leftResult;
        } else {
            return rightResult;
        }

    }

    public int getPivot(int[] nums, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex)/2;
        if(mid == 0 || mid == nums.length-1) return mid;
        if(nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid]) return mid;

        if(nums[mid] > nums[0] && nums[mid] > nums[nums.length-1]) {
            return getPivot(nums, mid+1, endIndex);
        } else {
            return getPivot(nums, startIndex, mid);
        }
    }

    public int searchBinary(int[] nums, int target, int start, int end) {
        if(start < 0 || end < 0 || start >= nums.length || end >= nums.length) return -1;
        if( start == end ) {
            if(nums[start] == target)
                return start;
            else
                return -1;
        }
        int mid = (start + end )/2;
        if(nums[mid] > target) {
            return searchBinary(nums, target, start, mid-1);
        } else {
            return searchBinary(nums, target, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(new RotatedSortedArray().search(nums, 3));
    }
}
