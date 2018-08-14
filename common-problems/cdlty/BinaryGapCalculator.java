package algorithms;

public class BinaryGapCalculator {

    public static void main(String[] args) {
        System.out.println(longestBinaryGap(9));
        System.out.println(longestBinaryGap(529));
        System.out.println(longestBinaryGap(32));
        System.out.println(longestBinaryGap(1041));
    }

    private static int longestBinaryGap(int n) {
        int longest = 0;
        int counter = 0;
        boolean isCounting = false;

        while(n > 0) {
            if((n & 1) == 1) {
                if(isCounting) {
                    longest = Math.max(longest, counter);
                    counter = 0;
                } else {
                    isCounting = true;
                    counter = 0;
                }
            } else {
                if(isCounting) {
                    counter++;
                }
            }
            n >>= 1;
        }

        return longest;
    }

}
