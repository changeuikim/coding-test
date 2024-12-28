# [Platinum III] [2-SAT - 4](https://www.acmicpc.net/problem/11281) - 11281 

NaN2-sat, 그래프 이론, 강한 연결 요소

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIndex = 0;

const iterativeTarjan = () => {
    const [N, M] = lines[lineIndex++];

    // 음수 인덱싱
    const idx = (x: number): number => {
        return x > 0 ? x : N * 2 + 1 + x;
    };

    // 1. 음수,양수 인접리스트 초기화
    const graph = Array.from({ length: N * 2 + 1 }, () => [] as number[]);

    for (let i = 0; i < M; i++) {
        const [u, v] = lines[lineIndex++];

        // u Or V는 ~u -> v 또는 ~v -> u이다
        graph[idx(-u)].push(idx(v));
        graph[idx(-v)].push(idx(u));
    }

    // SCC 후보
    const sccStk: number[] = [];
    const onStk = Array(N * 2 + 1).fill(false);
    // 발견 순서, 발견 시간
    const disc = Array(N * 2 + 1).fill(-1);
    let time = 1;
    // SCC id, SCC 번호
    const sccID = Array(N * 2 + 1).fill(-1);
    let sccNum = 1;
    // 정점의 도달 가능한 최소 방문 순서
    const lowlink = Array(N * 2 + 1).fill(-1);

    // 2. 모든 정점에 대해 DFS
    const dfsStk: [number, number][] = [];
    for (let start = 1; start <= N * 2; start++) {
        if (disc[start] === -1) {
            dfsStk.push([start, 0]);

            while (dfsStk.length > 0) {
                const [u, i] = dfsStk[dfsStk.length - 1];

                // u 첫 방문
                if (disc[u] === -1) {
                    // lowlink 갱신 1
                    disc[u] = lowlink[u] = time++;
                    // SCC 후보에 u 추가
                    sccStk.push(u);
                    onStk[u] = true;
                }

                // 자식 v를 탐색: for v in graph[u]
                if (i < graph[u].length) {
                    const v = graph[u][i];
                    dfsStk[dfsStk.length - 1] = [u, i + 1];

                    // v 첫방문
                    if (disc[v] === -1) {
                        dfsStk.push([v, 0]);
                    }
                    // v가 SCC 후보라면
                    else if (onStk[v]) {
                        // lowlink 갱신 2
                        lowlink[u] = Math.min(lowlink[u], disc[v]);
                    }
                }
                // 탐색할 v가 없으면
                else {
                    // dfs(v)를 콜스택에서 제거
                    dfsStk.pop();
                    // 부모가 있다면
                    if (dfsStk.length > 0) {
                        const parent = dfsStk[dfsStk.length - 1][0];
                        // lowlink 갱신 3 : u의 자식들의 최소값을 u의 부모에 전파
                        lowlink[parent] = Math.min(lowlink[parent], lowlink[u]);
                    }

                    // u가 이번 SCC의 루트 : 역방향 간선이 없고, 자식 중에서도 가장 빠르다
                    if (lowlink[u] === disc[u]) {
                        // 새 SCC를 구성
                        while (true) {
                            const top = sccStk.pop();
                            onStk[top] = false;
                            // 정점의 SCC 번호 기록
                            sccID[top] = sccNum;
                            if (top === u) break;
                        }
                        sccNum++;
                    }
                }
            }
        }
    }

    // 3. 정점 u와 정점 -u의 scc_cnt를 대조
    const result = Array(N).fill(0);
    for (let u = 1; u <= N; u++) {
        if (sccID[u] === sccID[idx(-u)]) {
            console.log(0);
            return;
        }
        if (sccID[u] < sccID[idx(-u)]) {
            result[u - 1] = 1;
        }
    }
    console.log(1);
    console.log(...result);
};

iterativeTarjan();
```

### 성능 요약

시간: 384 ms

메모리: 54604 KB

### 제출 일자

2024년 12월 28일 (토) 10:00

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

