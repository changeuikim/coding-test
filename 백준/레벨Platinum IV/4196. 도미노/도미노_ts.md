# [Platinum IV] [도미노](https://www.acmicpc.net/problem/4196) - 4196 

NaN방향 비순환 그래프, 그래프 이론, 강한 연결 요소, 위상 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIndex = 0;

const iterative_tarjan = () => {
    // 테스트케이스 T회
    let [T] = lines[lineIndex++];
    while (T--) {
        // SSC그룹핑 -> DAG생성 -> 진입차수 확인
        const [V, E] = lines[lineIndex++];

        // 1. 인접리스트 초기화
        const graph = Array.from({ length: V + 1 }, () => [] as number[]);
        for (let i = 0; i < E; i++) {
            const [u, v] = lines[lineIndex++];
            graph[u].push(v);
        }

        // SSC 후보 스택, 정점의 스택 포함 여부
        const sccStack: number[] = [];
        const inStack = Array(V + 1).fill(false);
        // DFS 방문순서, 카운터
        const visited = Array(V + 1).fill(-1);
        let visitedCount = 0;
        // SSC id, 현재
        const sccID = Array(V + 1).fill(-1);
        let curSCC = 0;
        // low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
        const low = Array(V + 1).fill(-1);

        // 2. 모든 정점에 대해 DFS
        const dfsStack: [number, number][] = [];
        for (let start = 1; start <= V; start++) {
            if (visited[start] === -1) {
                dfsStack.push([start, 0]);

                while (dfsStack.length > 0) {
                    const [u, i] = dfsStack[dfsStack.length - 1];

                    // 첫 방문
                    if (visited[u] === -1) {
                        // low 갱신 1
                        visited[u] = low[u] = visitedCount++;
                        // 스택에 u를 추가
                        sccStack.push(u);
                        inStack[u] = true;
                    }

                    // 인접 정점을 탐색
                    if (i < graph[u].length) {
                        const v = graph[u][i];
                        dfsStack[dfsStack.length - 1] = [u, i + 1];

                        // 첫 방문
                        if (visited[v] === -1) {
                            dfsStack.push([v, 0]);
                        }
                        // SCC 후보
                        else if (inStack[v]) {
                            // low 갱신 2
                            low[u] = Math.min(low[u], visited[v]);
                        }
                    }
                    // 탐색을 완료하면
                    else {
                        // dfs(v)
                        dfsStack.pop();
                        if (dfsStack.length > 0) {
                            const parent = dfsStack[dfsStack.length - 1][0];
                            // low 갱신 3
                            low[parent] = Math.min(low[parent], low[u]);
                        }

                        // u가 SCC 루트 정점
                        if (low[u] === visited[u]) {
                            // u의 SCC 구성하기
                            while (true) {
                                const top = sccStack.pop();
                                inStack[top] = false;
                                sccID[top] = curSCC;
                                if (top === u) break;
                            }
                            curSCC++;
                        }
                    }
                }
            }
        }

        // 3. SCC 단위로 DAG 생성
        const indegree = Array(curSCC).fill(0);
        for (let u = 1; u <= V; u++) {
            for (const v of graph[u]) {
                // 서로 다른 SCC를 연결하면 진입차수 증가
                if (sccID[u] !== sccID[v]) {
                    indegree[sccID[v]]++;
                }
            }
        }

        // 4. 진입차수 0인 SCC의 개수
        console.log(indegree.filter((x) => x === 0).length);
    }
};

iterative_tarjan();

```

### 성능 요약

시간: 1092 ms

메모리: 168228 KB

### 제출 일자

2024년 12월 26일 (목) 10:37

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

