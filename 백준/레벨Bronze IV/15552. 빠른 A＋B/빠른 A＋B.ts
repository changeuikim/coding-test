import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim().split('\n');
const T = parseInt(input[0]);

const result = new Array(T).fill(-1);
for (let i = 1; i <= T; i++) {
  const [a, b] = input[i].split(' ').map(Number);
  result[i - 1] = a + b;
}

console.log(result.join('\n'));