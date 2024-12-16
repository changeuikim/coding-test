// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const disjointSet = () => {
  // 부모 노드 초기화
  const [N, M] = lines[0];
  const parent = Array.from({ length: N + 1 }, (_, i) => i);

  const find = (x: number): number => {
    // 경로 압축
    while (parent[x] !== x) {
      parent[x] = parent[parent[x]];
      x = parent[x];
    }
    return x;
  };

  const union = (a: number, b: number): void => {
    const rootA = find(a);
    const rootB = find(b);

    if (rootA > rootB) {
      parent[rootA] = rootB;
    } else {
      parent[rootB] = rootA;
    }
  };

  // 서로소 집합 연산
  const result: string[] = [];
  for (let i = 1; i <= M; i++) {
    const [op, a, b] = lines[i];

    if (op === 0) {
      union(a, b);
    } else {
      result.push(find(a) === find(b) ? 'YES' : 'NO');
    }
  }

  console.log(result.join('\n'));
};

disjointSet();