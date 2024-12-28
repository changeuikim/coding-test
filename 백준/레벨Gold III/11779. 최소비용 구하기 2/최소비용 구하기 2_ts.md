# [Gold III] [최소비용 구하기 2](https://www.acmicpc.net/problem/11779) - 11779 

NaN데이크스트라, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIdx = 0;

class MinHeap<K extends number, V> {
    private heap: [K, V][];

    constructor(arr?: [K, V][]) {
        this.heap = [];
        if (arr) {
            this.heapify(arr);
        }
    }

    size(): number {
        return this.heap.length;
    }

    peek(): [K, V] | undefined {
        return this.heap.length > 0 ? this.heap[0] : undefined;
    }

    isEmpty(): boolean {
        return this.heap.length === 0;
    }

    push(value: [K, V]): void {
        this.heap.push(value);
        this._bubbleUp(this.heap.length - 1);
    }

    pop(): [K, V] | undefined {
        if (this.heap.length === 0) return undefined;
        if (this.heap.length === 1) return this.heap.pop();

        const minValue = this.heap[0];
        const lastValue = this.heap.pop()!;
        this.heap[0] = lastValue;
        this._bubbleDown(0);
        return minValue;
    }

    heapify(arr: [K, V][]): void {
        this.heap = [...arr];
        let index = (this.heap.length - 2) >> 1;
        while (index >= 0) {
            this._bubbleDown(index--);
        }
    }

    toArray(): [K, V][] {
        return [...this.heap];
    }

    private _bubbleUp(index: number): void {
        while (index > 0) {
            const parentIndex = (index - 1) >> 1;
            if (this.heap[parentIndex][0] <= this.heap[index][0]) break;

            [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
            index = parentIndex;
        }
    }

    private _bubbleDown(index: number): void {
        while (true) {
            let minIndex = index;
            const leftChildIndex = index * 2 + 1;
            const rightChildIndex = index * 2 + 2;

            if (
                leftChildIndex < this.heap.length &&
                this.heap[leftChildIndex][0] < this.heap[minIndex][0]
            ) {
                minIndex = leftChildIndex;
            }

            if (
                rightChildIndex < this.heap.length &&
                this.heap[rightChildIndex][0] < this.heap[minIndex][0]
            ) {
                minIndex = rightChildIndex;
            }

            if (minIndex == index) break;

            [this.heap[minIndex], this.heap[index]] = [this.heap[index], this.heap[minIndex]];
            index = minIndex;
        }
    }
}

const dijkstra = () => {
    const [N] = lines[lineIdx++];
    let [M] = lines[lineIdx++];

    // 인접리스트 초기화
    const graph = Array.from({ length: N + 1 }, () => []);
    while (M--) {
        const [u, v, w] = lines[lineIdx++];
        graph[u].push([v, w]);
    }

    // 출발점, 도착점
    const [S, E] = lines[lineIdx++];

    // 거리 초기화
    const INF = Number(1e9);
    const dist = Array(N + 1).fill(INF);
    dist[S] = 0;

    // 우선순위 큐 초기화
    const pq = new MinHeap<number, number>();
    pq.push([0, S]);

    // 추적 초기화
    const trace = Array(N + 1).fill(-1);

    // 다익스트라
    while (!pq.isEmpty()) {
        const [cur, u] = pq.pop!();

        if (cur > dist[u]) continue;
        if (u === E) break; // 도착점

        for (const [v, w] of graph[u]) {
            const nxt = cur + w;
            if (dist[v] > nxt) {
                dist[v] = nxt;
                pq.push([nxt, v]);
                trace[v] = u;
            }
        }
    }

    // 최단거리 경로복원
    const path: number[] = [];
    let node = E;
    while (node !== -1) {
        path.push(node);
        node = trace[node];
    }
    path.reverse();

    console.log(dist[E]);
    console.log(path.length);
    console.log(...path);
};

dijkstra();
```

### 성능 요약

시간: 440 ms

메모리: 76352 KB

### 제출 일자

2024년 12월 28일 (토) 23:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

