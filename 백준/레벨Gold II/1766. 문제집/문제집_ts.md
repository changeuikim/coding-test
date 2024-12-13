# [Gold II] [문제집](https://www.acmicpc.net/problem/1766) - 1766 

NaN방향 비순환 그래프, 자료 구조, 그래프 이론, 우선순위 큐, 위상 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

// 최소힙
class MinHeap<T extends number> {
  private heap: T[];

  constructor(arr?: T[]) {
    this.heap = [];
    if (arr) {
      this.heap = arr;
      this._heapify();
    }
  }

  size(): number {
    return this.heap.length;
  }

  peek(): T | undefined {
    return this.heap.length > 0 ? this.heap[0] : undefined;
  }

  isEmpty(): boolean {
    return this.heap.length === 0;
  }

  push(value: T): void {
    this.heap.push(value);
    this._bubbleUp(this.heap.length - 1);
  }

  pop(): T | undefined {
    if (this.heap.length === 0) return undefined;
    if (this.heap.length === 1) return this.heap.pop();

    const minValue = this.heap[0];
    const lastValue = this.heap.pop()!;
    this.heap[0] = lastValue;
    this._bubbleDown(0);
    return minValue;
  }

  toArray(): T[] {
    return [...this.heap];
  }

  private _heapify(): void {
    let index = (this.heap.length - 2) >> 1;
    while (index >= 0) {
      this._bubbleDown(index--);
    }
  }

  private _bubbleUp(index: number): void {
    while (index > 0) {
      const parentIndex = (index - 1) >> 1;
      if (this.heap[parentIndex] <= this.heap[index]) break;

      [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
      index = parentIndex;
    }
  }

  private _bubbleDown(index: number): void {
    while (true) {
      let minIndex = index;
      const leftChildIndex = index * 2 + 1;
      const rightChildIndex = index * 2 + 2;

      if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[minIndex]) {
        minIndex = leftChildIndex;
      }

      if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[minIndex]) {
        minIndex = rightChildIndex;
      }

      if (minIndex == index) break;

      [this.heap[minIndex], this.heap[index]] = [this.heap[index], this.heap[minIndex]];
      index = minIndex;
    }
  }
}

// 입력 처리
const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let idx = 0;
const input = (): string => lines[idx++];

// 인접리스트, 진입차수 초기화
let [N, M] = input().split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
const inDegree = Array(N + 1).fill(0);

while (M--) {
  const [u, v] = input().split(' ').map(Number);
  graph[u].push(v);
  inDegree[v]++;
}

// 힙 초기화
const inits = Array.from({ length: N }, (_, i) => i + 1).filter((node) => inDegree[node] === 0);
const heap = new MinHeap(inits);
const result: number[] = [];

// 위상 정렬
while (!heap.isEmpty()) {
  const u = heap.pop();

  result.push(u);

  for (const v of graph[u]) {
    inDegree[v]--;
    if (inDegree[v] === 0) heap.push(v);
  }
}

console.log(result.join(' '));
```

### 성능 요약

시간: 364 ms

메모리: 41528 KB

### 제출 일자

2024년 12월 13일 (금) 15:33

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

