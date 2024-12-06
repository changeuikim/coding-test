import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
const n = parseInt(lines[0]);
const nums = lines[1].split(' ').map(Number);
const v = parseInt(lines[2]);

const count = nums.filter((num: number) => num === v).length;
console.log(count);