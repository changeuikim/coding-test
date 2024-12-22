// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const greedy = () => {
  const [N] = lines[0];
  const meetings = lines.slice(1, N + 1);

  // 종료가 빠른 순으로 정렬
  const sorted = meetings.sort(([aS, aE], [bS, bE]) => (aE == bE ? aS - bS : aE - bE));

  let [E, cnt] = [-1, 0];
  for (const [ns, ne] of sorted) {
    // 현재 종료 <= 다음 시작
    if (E <= ns) {
      E = ne;
      cnt++;
    }
  }

  console.log(cnt);
};

greedy();