// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').split('\n');

const LCS2D = () => {
  const word1 = lines[0];
  const word2 = lines[1];
  const [N, M] = [word1.length, word2.length];

  // dp[i + 1][j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
  const dp = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
      // 문자가 같음 : 좌상방 대각선 + 1
      if (word1[i - 1] === word2[j - 1]) {
        dp[i][j] = dp[i - 1][j - 1] + 1;
      }
      // 문자가 다름 : 위쪽 또는 왼쪽 중 큰 값
      else {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
  }

  console.log(dp[N][M]);
};

const LCS1D = () => {
  const word1 = lines[0];
  const word2 = lines[1];
  const [N, M] = [word1.length, word2.length];

  // dp[j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
  const dp = Array(M + 1).fill(0);

  for (let i = 1; i <= N; i++) {
    let pre = 0; // 이전 행의 LCS 값
    for (let j = 1; j <= M; j++) {
      // 문자가 다름 : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
      if (pre < dp[j]) {
        pre = dp[j];
      }
      // 문자가 같음 : dp[j] = dp[i-1][j-1] + 1
      else if (word1[i - 1] === word2[j - 1]) {
        dp[j] = pre + 1;
      }
    }
  }

  console.log(Math.max(...dp));
};

// LCS2D();
LCS1D();