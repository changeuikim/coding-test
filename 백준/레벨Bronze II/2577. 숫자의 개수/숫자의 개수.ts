import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');

const [A, B, C] = lines.map(Number);

const digits = Array(10).fill(0);
let number = A * B * C;

while (number) {
  digits[Math.floor(number % 10)]++;
  number = Math.floor(number / 10);
}

console.log(digits.join('\n'));