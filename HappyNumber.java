import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        int tempVar = n;
        while(tempVar != 1 && !nums.contains(tempVar)) {
            nums.add(tempVar);
            tempVar = sumOfSquaredDigits(tempVar);
        }
        if( tempVar == 1) {
            return true;
        }
        return false;

    }
    public int sumOfSquaredDigits(int n) {
        int sum = 0;
        while(n > 0) {
            int r = n % 10;
            n = n/10;
            sum += (r*r);
        }
        return sum;
    }
}
