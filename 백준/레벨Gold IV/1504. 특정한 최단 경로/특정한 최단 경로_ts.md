# [Gold IV] [특정한 최단 경로](https://www.acmicpc.net/problem/1504) - 1504 

NaN데이크스트라, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

class MinHeap<K extends number, V> {
  private heap: [K, V][];

  constructor() {
    this.heap = [];
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

  private _bubbleUp(index: number): void {
    while (index > 0) {
      const parentIndex = Math.floor((index - 1) / 2);
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

      if (leftChildIndex < this.heap.length && this.heap[leftChildIndex][0] < this.heap[minIndex][0]) {
        minIndex = leftChildIndex;
      }

      if (rightChildIndex < this.heap.length && this.heap[rightChildIndex][0] < this.heap[minIndex][0]) {
        minIndex = rightChildIndex;
      }

      if (minIndex == index) break;

      [this.heap[minIndex], this.heap[index]] = [this.heap[index], this.heap[minIndex]];
      index = minIndex;
    }
  }
}

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

// 인접리스트 초기화
const MAX = 10000001;
const [N, E] = lines[0].split(' ').map(Number);
const graph: Array<[number, number][]> = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= E; i++) {
  const [u, v, w] = lines[i].split(' ').map(Number);
  graph[u].push([v, w]);
  graph[v].push([u, w]);
}

const [v1, v2] = lines[E + 1].split(' ').map(Number);

// 다익스트라
function dijkstra(S: number, N: number, graph: Array<[number, number][]>): number[] {
  const dist: number[] = Array(N + 1).fill(MAX);
  dist[S] = 0;

  const heap = new MinHeap<number, number>();
  heap.push([0, S]);

  while (!heap.isEmpty()) {
    const [curDist, u] = heap.pop();

    if (curDist > dist[u]) continue;

    for (const [v, w] of graph[u]) {
      const nxtDist = curDist + w;
      if (nxtDist < dist[v]) {
        dist[v] = nxtDist;
        heap.push([nxtDist, v]);
      }
    }
  }

  return dist;
}

// 1, V1, V2에서 출발하는 거리배열
const from_1 = dijkstra(1, N, graph);
const from_v1 = dijkstra(v1, N, graph);
const from_v2 = dijkstra(v2, N, graph);

// 경로1 : 1 -> v1 -> v2 -> N
// 경로2 : 1 -> v2 -> v1 -> N
const path1 = from_1[v1] + from_v1[v2] + from_v2[N];
const path2 = from_1[v2] + from_v2[v1] + from_v1[N];
const result = Math.min(path1, path2);

console.log(result >= MAX ? -1 : result);
```

### 성능 요약

시간: 504 ms

메모리: 77732 KB

### 제출 일자

2024년 12월 12일 (목) 13:22

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

