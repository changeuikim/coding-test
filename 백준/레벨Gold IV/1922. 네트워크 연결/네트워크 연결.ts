// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIdx = 0;

const kruskal = () => {
    const [V] = lines[lineIdx++];
    let [E] = lines[lineIdx++];

    // 엣지리스트 초기화
    const graph = lines.slice(2, E + 2);

    // 부모노드 1 ~ N 초기화
    const parent = Array.from({ length: V + 1 }, (_, i) => i);

    // 파인드
    const find = (x: number): number => {
        while (parent[x] !== x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    // 유니온
    const union = (a: number, b: number) => {
        [a, b] = [find(a), find(b)];
        if (a === b) return false;

        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    };

    // 크루스칼
    let mstCost = 0;
    let edgeCnt = 0;

    graph.sort((a: number[], b: number[]) => a[2] - b[2]); // w 정렬

    for (const [u, v, w] of graph) {
        if (edgeCnt >= V - 1) break;
        if (union(u, v)) {
            mstCost += w;
            edgeCnt++;
        }
    }

    console.log(mstCost);
};

kruskal();