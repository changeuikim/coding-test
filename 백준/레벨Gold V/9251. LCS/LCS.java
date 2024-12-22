import java.io.*;

class LCS2D {
    public void solution() throws IOException {
        String word1 = nextLine();
        String word2 = nextLine();
        int N = word1.length(), M = word2.length();

        // dp[i + 1][j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
              // 문자가 같음 : 좌상방 대각선 + 1
              if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
              }
              // 문자가 다름 : 위쪽 또는 왼쪽 중 큰 값
              else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
              }
            }
          }        

        System.out.println(dp[N][M]);
    }

    private static String nextLine() throws IOException {
        char[] buf = new char[1024];
        int c, idx = 0;
        while ((c = System.in.read()) <= 32);
        do {
            buf[idx++] = (char)c;
        } while ((c = System.in.read()) > 10);
        return new String(buf, 0, idx);
    }
}

class LCS1D {
    public void solution() throws IOException {
        String word1 = nextLine().trim();
        String word2 = nextLine().trim();
        int N = word1.length(), M = word2.length();

        // dp[j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
        int[] dp = new int[M + 1];

        for (int i = 1; i <= N; i++) {
            int pre = 0; // 이전 행의 LCS 값
            for (int j = 1; j <= M; j++) {
              // 문자가 다름 : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
              if (pre < dp[j]) {
                pre = dp[j];
              }
              // 문자가 같음 : dp[j] = dp[i-1][j-1] + 1
              else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[j] = pre + 1;
              }
            }
          }        

        int maxLen = dp[0];
        for (int x : dp) {
            maxLen = Math.max(maxLen, x);
        }

        System.out.println(maxLen);
    }

    private static String nextLine() throws IOException {
        char[] buf = new char[1024];
        int c, idx = 0;
        while ((c = System.in.read()) <= 32);
        do {
            buf[idx++] = (char)c;
        } while ((c = System.in.read()) > 10);
        return new String(buf, 0, idx);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // new LCS2D().solution();
        new LCS1D().solution();
    }
}