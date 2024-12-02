import fs = require('fs');

const input: string = fs.readFileSync('/dev/stdin').toString().trim();
const [A, B]: number[] = input.split(' ').map(Number);

console.log(A + B);