# [Gold IV] [작업](https://www.acmicpc.net/problem/2056) - 2056 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## TypeScript 문제풀이

```TypeScript
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
```

### 성능 요약

시간: 288 ms

메모리: 33892 KB

### 제출 일자

2024년 12월 17일 (화) 13:32

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

