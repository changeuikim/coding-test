public class Solution {
    public static long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            // 첫번째 0은 1로, 뒤는 모두 0
            long biggerNum = num + 1;
            
            // 첫번째 0 이전은 0, 뒤는 모두 1
            long bitDiff = num ^ (num + 1);
            
            // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
            long minNum = biggerNum + (bitDiff >> 2);

            result[i] = minNum;
        }

        return result;
    }
}