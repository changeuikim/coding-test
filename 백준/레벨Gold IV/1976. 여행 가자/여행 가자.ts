// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const disjointSet = () => {
  // 부모 노드 초기화
  const [N, M] = lines[0];
  const parent = Array.from({ length: N + 1 }, (_, i) => i);

  const find = (x: number): number => {
    const nodes: number[] = [];
    while (parent[x] !== x) {
      nodes.push(x);
      x = parent[x];
    }
    // 한번에 경로 압축
    for (const node of nodes) {
      parent[node] = x;
    }
    return x;
  };

  const union = (a: number, b: number): void => {
    const [rootA, rootB] = [find(a), find(b)];
    if (rootA === rootB) return;

    if (rootA > rootB) parent[rootA] = rootB;
    else parent[rootB] = rootA;
  };

  // 분리 집합
  for (let i = 1; i <= N; i++) {
    const line = lines[i + 1];

    for (let j = 1; j <= N; j++) {
      if (line[j - 1] === 1) {
        union(i, j);
      }
    }
  }

  // 경로 검증
  const cities = lines[N + 2];
  const root = find(cities[0]);
  const isPossible = cities.every((city: number) => find(city) === root);
  console.log(isPossible ? 'YES' : 'NO');
};

disjointSet();