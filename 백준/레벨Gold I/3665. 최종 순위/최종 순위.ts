// 25.02.02
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n');
let lineIdx = 0;

const solution = () => {
  // 테스트 케이스 T회 (T <= 100)
  const T = Number(lines[lineIdx++]);

  for (let t = 0; t < T; t++) {
    const N = Number(lines[lineIdx++]); // 2 <= N <= 500
    const rank = lines[lineIdx++].split(' ').map(Number); // 작년 순위 (1 <= t <= N)

    // 인접행렬 초기화
    const graph: boolean[][] = Array.from({ length: N + 1 }, () => Array(N + 1).fill(false));
    const indegree: number[] = Array(N + 1).fill(0);

    for (let i = 0; i < N; i++) {
      for (let j = i + 1; j < N; j++) {
        graph[rank[i]][rank[j]] = true;
        indegree[rank[j]]++;
      }
    }

    // 등수 변경 (0 <= M <= 25000)
    const M = Number(lines[lineIdx++]);
    for (let i = 0; i < M; i++) {
      const [a, b] = lines[lineIdx++].split(' ').map(Number);
      if (graph[a][b]) {
        graph[a][b] = false;
        graph[b][a] = true;
        indegree[b]--;
        indegree[a]++;
      } else {
        graph[b][a] = false;
        graph[a][b] = true;
        indegree[a]--;
        indegree[b]++;
      }
    }

    // 큐 초기화
    const q: number[] = [];
    for (let i = 1; i <= N; i++) {
      if (indegree[i] === 0) {
        q.push(i);
      }
    }

    let impossible = false;
    let ambiguous = false;

    // 위상 정렬
    const result: number[] = [];
    for (let i = 0; i < N; i++) {
      // N회 돌기전에 큐가 빈다 -> 사이클
      if (q.length === 0) {
        impossible = true;
        break;
      }
      // 큐 크기가 2 이상 -> 순서 보장 X
      if (q.length > 1) {
        ambiguous = true;
      }

      const u = q.shift()!;
      result.push(u);

      for (let v = 1; v <= N; v++) {
        if (graph[u][v]) {
          indegree[v]--;
          if (indegree[v] === 0) {
            q.push(v);
          }
        }
      }
    }

    if (impossible) {
      console.log('IMPOSSIBLE');
    } else if (ambiguous) {
      console.log('?');
    } else {
      console.log(result.join(' '));
    }
  }
};

solution();
