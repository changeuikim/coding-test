// @ts-ignore
import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8');
const lines = input.split('\n').map((line: string) => line.trim().split(' ').map(Number));

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
  const result: number[] = [];
  let index = 0;

  while (true) {
    const N = lines[index++][0];
    if (N === 0) break;

    // 동굴 초기화
    const cave: number[][] = [];
    for (let i = 0; i < N; i++) {
      cave.push(lines[index++]);
    }

    // 방향 초기화 : 상하좌우
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];

    // 힙, dp 초기화
    const start = cave[0][0];
    const heap = new MinHeap<number, [number, number]>();
    heap.push([start, [0, 0]]);

    const MAX = N * N * 9 + 1;
    const dp: number[][] = Array.from({ length: N }, () => Array(N).fill(MAX));
    dp[0][0] = start;

    // 다익스트라
    while (!heap.isEmpty()) {
      const [cur, [y, x]] = heap.pop()!;

      if (y === N - 1 && x === N - 1) {
        break;
      }

      for (let i = 0; i < 4; i++) {
        const [ny, nx] = [y + dy[i], x + dx[i]];

        if (0 <= ny && ny < N && 0 <= nx && nx < N) {
          const nxt = cur + cave[ny][nx];
          if (dp[ny][nx] > nxt) {
            heap.push([nxt, [ny, nx]]);
            dp[ny][nx] = nxt;
          }
        }
      }
    }

    result.push(dp[N - 1][N - 1]);
  }

  // 결과 출력
  for (let i = 0; i < result.length; i++) {
    console.log(`Problem ${i + 1}: ${result[i]}`);
  }
};

dijkstra();