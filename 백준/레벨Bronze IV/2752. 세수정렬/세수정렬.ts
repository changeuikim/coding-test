import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const numbers: number[] = input.split(' ').map(Number);

console.log(numbers.sort((a, b) => a - b).join(' '));