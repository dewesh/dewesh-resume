public class divide2integer {
    public int divide(int dividend, int divisor) {
        int result = 0;
        boolean isNegative = dividend < 0 ^ divisor < 0;
        if( dividend == Integer.MIN_VALUE) dividend = Integer.MAX_VALUE;
        dividend = dividend < 0 ? -dividend: dividend;
        divisor = divisor < 0 ? -divisor: divisor;
        while( dividend >= divisor) {
            dividend -= divisor;
            result ++;
        }
        return isNegative ? -result: result;
    }

    public static void main(String[] args) {
        int result = new divide2integer().divide(-2147483648, -1);
        System.out.println(result);
    }
}
