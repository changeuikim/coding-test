// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIdx = 0;

const tarjan = () => {
    // 테스트 케이스 T회 (T <= 11)
    let T: number = lines[lineIdx++][0];
    while (T--) {
        // 정점 N 간선 M (1 ≤ N, M ≤ 100,000)
        const [N, M] = lines[lineIdx++];

        // 1. 간선 리스트 초기화
        const graph: number[][] = Array.from({ length: N }, () => []);
        for (let _ = 0; _ < M; _++) {
            const [u, v] = lines[lineIdx++];
            graph[u].push(v);
        }
        lineIdx++;

        // SCC 목록
        const sccMap: { [key: number]: number[] } = {};
        const sccID: number[] = Array(N).fill(-1);
        let sccNum: number = 0;

        // SCC 후보
        const sccStk: number[] = [];
        const onStk: boolean[] = Array(N).fill(false);

        // 발견
        const disc: number[] = Array(N).fill(-1);
        let discTime: number = 0;
        const lowlink: number[] = Array(N).fill(-1);

        // 2. 모든 정점에 대해 DFS
        const dsfStk: [number, number][] = [];
        for (let start = 0; start < N; start++) {
            if (disc[start] === -1) {
                dsfStk.push([start, 0]);

                // Iterative Tarjan
                while (dsfStk.length > 0) {
                    const [u, i] = dsfStk[dsfStk.length - 1];

                    // u를 첫방문
                    if (disc[u] === -1) {
                        // lowlink 갱신 1
                        lowlink[u] = disc[u] = discTime++;

                        // SCC 후보에 u 추가
                        sccStk.push(u);
                        onStk[u] = true;
                    }

                    // 자식 v를 탐색 : for v in graph[u]
                    if (i < graph[u].length) {
                        const v = graph[u][i];
                        // 다음 v로 미리 이동
                        dsfStk[dsfStk.length - 1] = [u, i + 1];

                        // v를 첫방문
                        if (disc[v] === -1) {
                            dsfStk.push([v, 0]);
                        }
                        // v가 SCC 후보
                        else if (onStk[v]) {
                            // lowlink 갱신 2
                            lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                        }
                    }
                    // 탐색할 v가 없으면
                    else {
                        // dfs(v)를 콜스택에서 팝
                        dsfStk.pop();

                        // 부모 노드가 남아있다면
                        if (dsfStk.length > 0) {
                            const parent = dsfStk[dsfStk.length - 1][0];
                            // lowlink 갱신 3
                            lowlink[parent] = Math.min(lowlink[parent], lowlink[u]);
                        }

                        // u가 새로운 SCC의 루트라면
                        if (lowlink[u] === disc[u]) {
                            const cur_scc: number[] = [];

                            // 새로운 SCC 구성하기
                            while (true) {
                                const top = sccStk.pop()!;
                                onStk[top] = false;
                                cur_scc.push(top);
                                sccID[top] = sccNum;
                                if (top === u) break;
                            }

                            sccMap[sccNum++] = cur_scc;
                        }
                    }
                }
            }
        }

        // 3. 진입차수 0인 SCC를 확인
        const indegree: number[] = Array(sccNum).fill(0);
        for (let u = 0; u < N; u++) {
            for (const v of graph[u]) {
                // 서로 다른 SCC를 연결하면 진입차수 증가
                if (sccID[v] !== sccID[u]) {
                    indegree[sccID[v]]++;
                }
            }
        }

        // 4. 출력 처리
        const entry = Array.from({ length: sccNum }, (_, i) => i).filter((i) => indegree[i] === 0);
        if (entry.length === 1) {
            const result = sccMap[entry[0]].sort((a, b) => a - b);
            console.log(result.join('\n'));
        } else {
            console.log('Confused');
        }
        console.log();
    }
};

tarjan();