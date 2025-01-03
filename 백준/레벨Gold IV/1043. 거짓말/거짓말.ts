// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const disjointSet = () => {
  // 부모노드 초기화
  const [N, M] = lines[0];
  const parent = Array.from({ length: N + 1 }, (_, i) => i);

  const find = (x: number): number => {
    const nodes: number[] = [];
    while (parent[x] !== x) {
      nodes.push(x);
      x = parent[x];
    }

    for (const node of nodes) parent[node] = x;
    return x;
  };

  const union = (a: number, b: number): void => {
    const root_a = find(a);
    const root_b = find(b);

    if (root_a > root_b) parent[root_a] = root_b;
    else parent[root_b] = root_a;
  };

  // 진실노드 초기화
  const truth = lines[1];
  if (truth[0] === 0) {
    console.log(M);
    return;
  }

  // 파티노드 초기화
  const parties: number[][] = [];
  for (let i = 2; i <= M + 1; i++) {
    const party = lines[i].slice(1);
    parties.push(party);

    for (let j = 0; j < party.length - 1; j++) {
      union(party[j], party[j + 1]);
    }
  }

  // 진실노드로 병합
  const root = find(truth[1]);
  for (let i = 2; i < truth.length; i++) {
    union(truth[i], root);
  }

  // 파티 처리
  let count = M;
  for (const party of parties) {
    if (find(party[0]) === find(root)) count--;
  }

  console.log(count);
};

disjointSet();