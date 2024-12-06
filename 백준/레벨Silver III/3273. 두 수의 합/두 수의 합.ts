import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
const n = parseInt(lines[0]);
const arr = lines[1].split(' ').map(Number);
const x = parseInt(lines[2]);

arr.sort((a: number, b: number) => a - b);

let cnt = 0,
  i = 0,
  j = n - 1;
while (i < j) {
  const curr = arr[i] + arr[j];
  if (curr < x) i++;
  else if (curr > x) j--;
  else {
    cnt++;
    i++;
    j--;
  }
}

console.log(cnt);