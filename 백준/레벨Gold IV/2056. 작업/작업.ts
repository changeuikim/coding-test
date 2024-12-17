// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const topologicalSort = () => {
  // 선행은 모두 1 이상 (K-1) 이하 : 1부터 N까지 이미 위상 정렬 됨
  const N = lines[0][0];
  const dp = Array(N + 1).fill(0);

  for (let v = 1; v <= N; v++) {
    const [time, size, ...pre] = lines[v];
    // 작업시간 설정
    dp[v] = time;
    // 선행시간 반영
    for (const u of pre) {
      dp[v] = Math.max(dp[v], dp[u] + time);
    }
  }
  // 가장 늦게 끝나는 작업을 반환
  console.log(Math.max(...dp));
};

topologicalSort();