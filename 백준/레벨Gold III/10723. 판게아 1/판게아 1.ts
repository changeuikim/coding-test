// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

// 전역변수
let N: number;
let M: number;
let parent: number[];
type Edge = [number, number, number];

const insort = (arr: Edge[], value: Edge) => {
  let left = 0;
  let right = arr.length;
  while (left < right) {
    const mid = left + ((right - left) >> 1);
    if (arr[mid][0] < value[0]) left = mid + 1;
    else right = mid;
  }
  arr.splice(left, 0, value);
};

const find = (x: number): number => {
  while (x != parent[x]) {
    parent[x] = parent[parent[x]];
    x = parent[x];
  }
  return x;
};

const union = (a: number, b: number): boolean => {
  [a, b] = [find(a), find(b)];
  if (a === b) return false;

  if (a > b) parent[a] = b;
  else parent[b] = a;
  return true;
};

const kruskal = (edges: Edge[]): bigint => {
  // 부모 + 랭크 노드
  parent = Array.from({ length: N + 1 }, (_, i) => i);

  // 최소 신장 트리
  let mstCost = BigInt(0);
  let edgeCount = 0;

  for (const [w, u, v] of edges) {
    if (edgeCount >= N - 1) break;
    if (union(u, v)) {
      mstCost += BigInt(w);
      edgeCount++;
    }
  }

  return mstCost;
};

const solution = () => {
  // 1. 테스트 T회
  let lineIndex = 0;
  let [T] = lines[lineIndex++];
  while (T--) {
    [N, M] = lines[lineIndex++];

    // 2. 태초의 세계, 엣지 리스트
    const edges: Edge[] = [];
    for (let i = 1; i < N; i++) {
      const [u, c] = lines[lineIndex++];
      insort(edges, [c, i, u]); // w, u, v
    }

    // 3. 조물주가 새로이 놓은 도로
    let result = BigInt(0);
    for (let j = 1; j <= M; j++) {
      const [u, v, c] = lines[lineIndex++];
      insort(edges, [c, u, v]); // w, u, v

      // 5. XOR 연산
      result ^= kruskal(edges); // 4. 크루스칼
    }

    console.log(Number(result));
  }
};

solution();