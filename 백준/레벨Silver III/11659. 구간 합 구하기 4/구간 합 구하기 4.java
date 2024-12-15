import java.io.*;

class Solution {
    public void rangeSum() throws IOException {
        // 누적 합 초기화
        int N = nextInt(), M = nextInt();
        int[] prefixSum = new int[N+1];

        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + nextInt();
        }

        // 구간 합 출력
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int i = nextInt(), j = nextInt();
            sb.append(prefixSum[j] - prefixSum[i - 1]).append("\n");
        }

        System.out.println(sb);
    }

    int nextInt() throws IOException {
        int n = 0;
        int c;

        while ((c = System.in.read()) <= 32); // 탭 2, 개행 10, 공백 32

        do {
            n = n * 10 + (c - '0'); // 한자리씩 추가
        } while ((c = System.in.read()) > 32); // 구분자 : 공백

        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().rangeSum();
    }
}