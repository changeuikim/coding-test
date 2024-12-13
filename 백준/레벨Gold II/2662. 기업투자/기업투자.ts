// @ts-ignore
import fs = require('fs');

// 입력 처리
const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let idx = 0;
const input = (): string => lines[idx++];

// 이익 2차원 배열 : n축 금액, m축 기업
const [N, M] = input().split(' ').map(Number);
const profit: number[][] = [Array(M + 1).fill(0)];

for (let i = 0; i < N; i++) {
  const line = input().split(' ').map(Number);
  profit.push(line);
}

// 누산 DP, 기업별 memo
const dp = Array(N + 1)
  .fill(null)
  .map(() => Array(M + 1).fill(0));
const memo = Array(N + 1)
  .fill(null)
  .map(() => Array(M + 1).fill(0));

// 루프 : 기업 -> 투자액 -> 변동폭
// 점화식 : dp[N][다음] = dp[N-k][이전] + profit[k][다음]
for (let i = 1; i <= M; i++) {
  for (let j = 0; j <= N; j++) {
    for (let k = 0; k <= j; k++) {
      const curProfit = dp[j - k][i - 1] + profit[k][i];
      if (curProfit > dp[j][i]) {
        dp[j][i] = curProfit;
        memo[j][i] = k;
      }
    }
  }
}

console.log(dp[N][M]);

// memo[N][M]부터 N을 차감하며 역추적
const corp = Array(M + 1).fill(0);
let r = N;

for (let i = M; i >= 1; i--) {
  corp[i] = memo[r][i];
  r -= memo[r][i];
}

console.log(corp.splice(1).join(' '));