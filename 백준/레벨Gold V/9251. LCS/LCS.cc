#include <bits/stdc++.h>
using namespace std;

namespace LCS2D {
    void solution() {
        string word1, word2;
        cin >> word1 >> word2;
        int N = word1.length(), M = word2.length();

        // dp[i + 1][j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
        vector<vector<int>> dp(N + 1, vector<int>(M + 1, 0));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // 문자가 같음 : 좌상방 대각선 + 1
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                // 문자가 다름 : 위쪽 또는 왼쪽 중 큰 값    
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        cout << dp[N][M];
    }
}

namespace LCS1D {
    void solution() {
        string word1, word2;
        cin >> word1 >> word2;
        int N = word1.length(), M = word2.length();

        // dp[j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
        vector<int> dp(M + 1, 0);

        for (int i = 1; i <= N; i++) {
            int pre = 0; // 이전 행의 LCS 값
            for (int j = 1; j <= M; j++) {
                // 문자가 다름 : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                if (pre < dp[j]) {
                    pre = dp[j];
                }
                // 문자가 같음 : dp[j] = dp[i-1][j-1] + 1
                else if (word1[i - 1] == word2[j - 1]) {
                    dp[j] = pre + 1;
                }
            }
        }

        cout << *max_element(dp.begin(), dp.end());
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // LCS2D::solution();
    LCS1D::solution();
}