# [Gold IV] [최단경로](https://www.acmicpc.net/problem/1753) - 1753 

NaN데이크스트라, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

class MinHeap<T extends [number, any]> {
  private heap: T[];

  constructor() {
    this.heap = [];
  }

  size(): number {
    return this.heap.length;
  }

  peek(): T | null {
    return this.heap.length > 0 ? this.heap[0] : null;
  }

  heappush(value: T): void {
    this.heap.push(value);
    this._bubbleUp(this.heap.length - 1);
  }

  heappop(): T | null {
    if (this.heap.length === 0) return null;
    if (this.heap.length === 1) return this.heap.pop() || null;

    const minValue = this.heap[0];
    this.heap[0] = this.heap.pop();
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
      const leftChildIndex = 2 * index + 1;
      const rightChildIndex = 2 * index + 2;

      if (leftChildIndex < this.heap.length && this.heap[leftChildIndex][0] < this.heap[index][0]) {
        minIndex = leftChildIndex;
      }

      if (rightChildIndex < this.heap.length && this.heap[rightChildIndex][0] < this.heap[index][0]) {
        minIndex = rightChildIndex;
      }

      if (minIndex === index) break;

      [this.heap[minIndex], this.heap[index]] = [this.heap[index], this.heap[minIndex]];
      index = minIndex;
    }
  }
}

// 인접리스트 초기화
const [V, E] = lines[0].split(' ').map(Number);
const S = parseInt(lines[1]);
const graph: [number, number][][] = Array.from({ length: V + 1 }, () => []);

for (let i = 2; i < E + 2; i++) {
  const [u, v, w] = lines[i].split(' ').map(Number);
  graph[u].push([v, w]);
}

// 거리배열 초기화
const INF = Infinity;
const distances = Array(V + 1).fill(INF);
distances[S] = 0;

// 다익스트라
const heap = new MinHeap();
heap.heappush([0, S]);

while (heap.size() > 0) {
  const [currDist, u] = heap.heappop();

  if (currDist > distances[u]) continue;

  for (const [v, w] of graph[u]) {
    const nextDist = currDist + w;

    if (nextDist < distances[v]) {
      distances[v] = nextDist;
      heap.heappush([nextDist, v]);
    }
  }
}

// 출력 처리
const output = distances
  .slice(1)
  .map((dist) => (dist === INF ? 'INF' : dist.toString()))
  .join('\n');
console.log(output);
```

### 성능 요약

시간: 680 ms

메모리: 103116 KB

### 제출 일자

2024년 12월 11일 (수) 22:21

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

