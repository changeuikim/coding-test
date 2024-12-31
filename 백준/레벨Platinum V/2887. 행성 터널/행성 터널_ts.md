# [Platinum V] [행성 터널](https://www.acmicpc.net/problem/2887) - 2887 

NaN그래프 이론, 최소 스패닝 트리, 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIdx = 0;

/*
    비용은 두 행성 간의 최소 축 차이: min(|xA - xB|, |yA - yB|, |zA - zB|)
    모든 행성 간의 간선을 계산하면 nC2 = O(N^2), 이는 N = 1e5일 때 약 50억 개로 시간 초과 발생
    최적화 방법:
        - x, y, z 축별로 좌표를 기준으로 행성을 정렬한 뒤,
        - 인접한 두 행성 사이의 간선만 고려 -> 축별로 N-1개의 간선
        - 총 간선 개수: 3(N-1), 시간 복잡도: O(N log N), 이는 N = 1e5일때 약 170만으로 안전범위
*/

const kruskal = () => {
    // 행성의 개수 N (1 ≤ N ≤ 100,000)
    const [N] = lines[lineIdx++];

    // 행성정보 0-based
    const planets: [number, number, number, number][] = [];
    for (let i = 0; i < N; i++) {
        const [x, y, z] = lines[lineIdx++];
        planets.push([i, x, y, z]);
    }

    // 간선 리스트 초기화
    const graph: [number, number, number][] = [];

    for (let i = 1; i <= 3; i++) {
        // x, y, z축 기준 정렬 간선
        planets.sort((a, b) => a[i] - b[i]);

        for (let j = 0; j < N - 1; j++) {
            const u = planets[j][0];
            const v = planets[j + 1][0];
            const w = Math.abs(planets[j + 1][i] - planets[j][i]);
            graph.push([u, v, w]);
        }
    }

    // 부모노드 0 ~ N-1 초기화
    const parent = Array.from({ length: N }, (_, i) => i);

    // 파인드
    const find = (x: number): number => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    // 유니온
    const union = (a: number, b: number): boolean => {
        a = find(a);
        b = find(b);
        if (a === b) return false;

        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    };

    // 크루스칼
    let mstCost = 0;
    let edgeCount = 0;

    graph.sort((a, b) => a[2] - b[2]); // w 기준 정렬

    for (const [u, v, w] of graph) {
        if (edgeCount >= N - 1) break;
        if (union(u, v)) {
            mstCost += w;
            edgeCount++;
        }
    }

    console.log(mstCost);
};

kruskal();
```

### 성능 요약

시간: 1048 ms

메모리: 113144 KB

### 제출 일자

2024년 12월 31일 (화) 21:42

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

