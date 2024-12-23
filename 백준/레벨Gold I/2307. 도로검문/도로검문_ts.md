# [Gold I] [도로검문](https://www.acmicpc.net/problem/2307) - 2307 

NaN데이크스트라, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

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

const INF = Number(1e9);

type Skip = [number, number] | null;
type State = [number, number[]] | null;

const solution = () => {
  const [N, M] = lines[0];

  // 인접리스트 초기화화
  const graph = Array(N + 1)
    .fill(null)
    .map(() => []);

  for (let i = 1; i <= M; i++) {
    const [u, v, w] = lines[i];
    graph[u].push([v, w]);
    graph[v].push([u, w]);
  }

  const dijkstra = (skip: Skip, isTrace: boolean): State => {
    // 간선정보 추적
    const trace = isTrace ? Array(N + 1).fill(0) : null;

    // 거리 초기화
    const dist = Array(N + 1).fill(INF);
    dist[1] = 0;

    // 우선순위 큐 초기화
    const pq = new MinHeap<number, number>();
    pq.push([0, 1]);

    // 다익스트라
    while (!pq.isEmpty()) {
      const [cur, u] = pq.pop!();

      if (cur > dist[u]) continue;

      for (const [v, w] of graph[u]) {
        // 간선 끊기
        if (skip[0] === u && skip[1] === v) continue;

        const nxt = cur + w;
        if (nxt < dist[v]) {
          // 간선 저장
          if (isTrace) trace[v] = u;
          dist[v] = nxt;
          pq.push([nxt, v]);
        }
      }
    }

    return [dist[N], trace];
  };

  // 최단 시간과 간선 추적
  const [min_time, trace] = dijkstra([0, 0], true);

  // 최단 시간의 간선 복원
  const edges: [number, number][] = [];
  let node = N;
  while (trace && trace[node]) {
    edges.push([trace[node], node]);
    node = trace[node];
  }

  // 간선 하나씩 끊기
  let max_diff = -1;
  for (const [u, v] of edges) {
    const [delay_time, _] = dijkstra([u, v], false);

    if (delay_time === INF) {
      console.log(-1);
      return;
    }

    max_diff = Math.max(max_diff, delay_time - min_time);
  }

  console.log(max_diff);
};

solution();
```

### 성능 요약

시간: 692 ms

메모리: 29768 KB

### 제출 일자

2024년 12월 23일 (월) 10:16

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

