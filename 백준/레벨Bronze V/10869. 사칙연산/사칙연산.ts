import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const [a, b]: number[] = input.split(' ').map(Number);

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(Math.floor(a / b));
console.log(a % b);