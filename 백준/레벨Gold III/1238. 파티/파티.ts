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

// 정방향, 역방향 인접리스트 초기화
const [N, M, X] = lines[0].split(' ').map(Number);
const fGraph: [number, number][][] = Array.from({ length: N + 1 }, () => []);
const rGraph: [number, number][][] = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= M; i++) {
  const [u, v, w] = lines[i].split(' ').map(Number);
  fGraph[u].push([v, w]);
  rGraph[v].push([u, w]);
}

// 다익스트라
const dijkstra = (N: number, S: number, graph: [number, number][][]) => {
  // 거리배열 초기화
  const MAX = 100001;
  const dist: number[] = Array(N + 1).fill(MAX);
  dist[S] = 0;

  // 최소힙
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
};

// 집 -> X -> 집
const homeToParty = dijkstra(N, X, fGraph);
const partyToHome = dijkstra(N, X, rGraph);

// 최대시간 찾기
let maxTime = -1;
for (let i = 1; i <= N; i++) {
  const curTime = homeToParty[i] + partyToHome[i];
  if (curTime > maxTime) {
    maxTime = curTime;
  }
}

console.log(maxTime);