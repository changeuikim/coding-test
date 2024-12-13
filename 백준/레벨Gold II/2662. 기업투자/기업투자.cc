#include <bits/stdc++.h>

using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 이익 2차원 배열 : n축 금액, m축 기업
  int N, M;
  cin >> N >> M;

  vector<vector<int>> profit(N+1, vector<int>(M+1, 0));

  for (int i = 1; i <= N; i++) {
    for (int j = 0; j <= M; j++) {
      cin >> profit[i][j];
    }
  }  

  // 누산 DP, 기업별 memo
  vector<vector<int>> dp(N+1, vector<int>(M+1, 0));
  vector<vector<int>> memo(N+1, vector<int>(M+1, 0));

  // 루프 : 기업 -> 투자액 -> 변동폭
  // 점화식 : dp[N][다음] = dp[N-k][이전] + profit[k][다음]
  for (int i = 1; i <= M; i++) {
    for (int j = 0; j <= N; j++) {
      for (int k = 0; k <= j; k++) {
        int curProfit = dp[j - k][i - 1] + profit[k][i];
        if (curProfit > dp[j][i]) {
            dp[j][i] = curProfit;
            memo[j][i] = k;
        }
      }
    }
  }

  cout << dp[N][M] << "\n";

  // memo[N][M]부터 N을 차감하며 역추적
  vector<int> corp(M+1, 0);
  int r = N;

  for (int i = M; i >= 1; i--) {
    corp[i] = memo[r][i];
    r -= memo[r][i];     
  }  

  for (int i = 1; i < corp.size(); i++) {
    cout << corp[i] << " ";
  }  
}