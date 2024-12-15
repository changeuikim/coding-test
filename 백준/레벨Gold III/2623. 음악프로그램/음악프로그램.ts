// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let index = 0;
const input = (): string => lines[index++];

class Queue<T> {
  private input: T[] = [];
  private output: T[] = [];

  push(item: T): void {
    this.input.push(item);
  }

  pop(): T | undefined {
    if (this.output.length === 0) {
      while (this.input.length > 0) {
        this.output.push(this.input.pop()!);
      }
    }
    return this.output.pop();
  }

  size(): number {
    return this.input.length + this.output.length;
  }

  isEmpty(): boolean {
    return this.size() === 0;
  }
}

const topologicalSort = () => {
  // 인접리스트, 진입차수 초기화
  let [N, M] = input().split(' ').map(Number);
  const graph = Array.from({ length: N + 1 }, () => []);
  const inDegree = Array(N + 1).fill(0);

  while (M--) {
    const entry = input().split(' ').map(Number);

    for (let i = 1; i < entry.length - 1; i++) {
      const [u, v] = [entry[i], entry[i + 1]];
      graph[u].push(v);
      inDegree[v] += 1;
    }
  }

  // 큐 초기화
  const q = new Queue<number>();
  const result: number[] = [];

  for (let i = 1; i <= N; i++) {
    if (inDegree[i] === 0) {
      q.push(i);
    }
  }

  // 위상 정렬
  while (!q.isEmpty()) {
    const u = q.pop();

    result.push(u);

    for (const v of graph[u]) {
      inDegree[v]--;
      if (inDegree[v] === 0) {
        q.push(v);
      }
    }
  }

  // 사이클 확인
  if (result.length === N) console.log(result.join('\n'));
  else console.log(0);
};

topologicalSort();