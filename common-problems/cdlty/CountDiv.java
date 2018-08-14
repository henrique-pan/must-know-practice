package algorithms;

public class CountDiv {

    public static void main(String[] args) {
        int min = 0;
        int max = 0;
        int k = 11;

        System.out.println(solution(min, max, k));
    }

    public static int solution(int min, int max, int k) {
        int result = (max/k) - (min/k);
        if(min % k == 0) result++;
        return result;
    }

}
