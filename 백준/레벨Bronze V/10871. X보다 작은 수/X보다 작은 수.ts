import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const lines: string[] = input.split('\n');

const [N, X]: number[] = lines[0].split(' ').map(Number);
const A: number[] = lines[1].split(' ').map(Number);

const result: number[] = A.filter((a) => a < X);
console.log(result.join(' '));