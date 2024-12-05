import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const year: number = parseInt(input);

const result = (year % 4 === 0 && year % 100 != 0) || year % 400 === 0;

console.log(result ? 1 : 0);