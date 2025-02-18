import java.io.*;

class Solution {
    public void solution() throws IOException {
        // 누적 합 초기화
        int N = nextInt(), M = nextInt();

        int[][] nums = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = nextInt();
            }
        }

        int[][] pre = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + nums[i-1][j-1];
            }
        }        

        // 구간 합 처리
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int x1 = nextInt(), y1 = nextInt(), x2 = nextInt(), y2 = nextInt();

            int t = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1];
            sb.append(t).append("\n");
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
        new Solution().solution();
    }
}