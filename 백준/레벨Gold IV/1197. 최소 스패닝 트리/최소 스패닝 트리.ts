// 결과       메모리	시간
// 크루스칼  	63640   416
// 프림	      86080	  536

// @ts-ignore
import fs = require('fs');

// class MinHeap<K extends number, V> {
//   private heap: [K, V][];

//   constructor(arr?: [K, V][]) {
//     this.heap = [];
//     if (arr) {
//       this.heapify(arr);
//     }
//   }

//   size(): number {
//     return this.heap.length;
//   }

//   peek(): [K, V] | undefined {
//     return this.heap.length > 0 ? this.heap[0] : undefined;
//   }

//   isEmpty(): boolean {
//     return this.heap.length === 0;
//   }

//   push(value: [K, V]): void {
//     this.heap.push(value);
//     this._bubbleUp(this.heap.length - 1);
//   }

//   pop(): [K, V] | undefined {
//     if (this.heap.length === 0) return undefined;
//     if (this.heap.length === 1) return this.heap.pop();

//     const minValue = this.heap[0];
//     const lastValue = this.heap.pop()!;
//     this.heap[0] = lastValue;
//     this._bubbleDown(0);
//     return minValue;
//   }

//   heapify(arr: [K, V][]): void {
//     this.heap = [...arr];
//     let index = (this.heap.length - 2) >> 1;
//     while (index >= 0) {
//       this._bubbleDown(index--);
//     }
//   }

//   toArray(): [K, V][] {
//     return [...this.heap];
//   }

//   private _bubbleUp(index: number): void {
//     while (index > 0) {
//       const parentIndex = (index - 1) >> 1;
//       if (this.heap[parentIndex][0] <= this.heap[index][0]) break;

//       [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
//       index = parentIndex;
//     }
//   }

//   private _bubbleDown(index: number): void {
//     while (true) {
//       let minIndex = index;
//       const leftChildIndex = index * 2 + 1;
//       const rightChildIndex = index * 2 + 2;

//       if (
//         leftChildIndex < this.heap.length &&
//         this.heap[leftChildIndex][0] < this.heap[minIndex][0]
//       ) {
//         minIndex = leftChildIndex;
//       }

//       if (
//         rightChildIndex < this.heap.length &&
//         this.heap[rightChildIndex][0] < this.heap[minIndex][0]
//       ) {
//         minIndex = rightChildIndex;
//       }

//       if (minIndex == index) break;

//       [this.heap[minIndex], this.heap[index]] = [this.heap[index], this.heap[minIndex]];
//       index = minIndex;
//     }
//   }
// }

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const kruskal = () => {
  const [V, E] = lines[0];

  // 간선리스트 초기화 : 가중치 기준 오름차순 정렬
  const graph = lines.slice(1, E + 1).sort((a: number[], b: number[]) => a[2] - b[2]);

  // 분리 집합
  const parent = Array(V + 1).fill(-1);

  const find = (x: number): number => {
    const nodes: number[] = [];
    while (parent[x] >= 0) {
      nodes.push(x);
      x = parent[x];
    }
    for (const node of nodes) {
      parent[node] = x;
    }
    return x;
  };

  const union = (a: number, b: number) => {
    const [rootA, rootB] = [find(a), find(b)];

    if (rootA === rootB) return;

    if (rootA > rootB) parent[rootA] = rootB;
    else parent[rootB] = rootA;
  };

  // 크루스칼 알고리즘
  let mstCost = 0;
  let edgeCount = 0;

  for (const [u, v, w] of graph) {
    if (find(u) !== find(v)) {
      union(u, v);
      mstCost += w;
      edgeCount += 1;

      if (edgeCount === V - 1) {
        console.log(mstCost);
        return;
      }
    }
  }

  console.log(mstCost);
};

// const prim = () => {
//   const [V, E] = lines[0];

//   // 인접리스트 초기화
//   const graph: [number, number][][] = Array.from({ length: V + 1 }, () => []);

//   for (let i = 1; i <= E; i++) {
//     const [u, v, w] = lines[i];
//     graph[u].push([v, w]);
//     graph[v].push([u, w]);
//   }

//   // 거리, 방문, 힙 초기화
//   const MAX = Number(1e9);
//   const dist = Array(V + 1).fill(MAX);
//   const visited = Array(V + 1).fill(false);
//   const pq = new MinHeap<number, number>();
//   let mstCost = 0;

//   dist[1] = 0;
//   pq.push([0, 1]);

//   // 프림 알고리즘
//   while (!pq.isEmpty()) {
//     const [cur_dist, u] = pq.pop()!;

//     if (cur_dist > dist[u]) continue;

//     visited[u] = true;
//     mstCost += cur_dist;

//     for (const [v, nxt_dist] of graph[u]) {
//       if (!visited[v] && nxt_dist < dist[v]) {
//         dist[v] = nxt_dist;
//         pq.push([nxt_dist, v]);
//       }
//     }
//   }

//   console.log(mstCost);
// };

kruskal();
// prim();