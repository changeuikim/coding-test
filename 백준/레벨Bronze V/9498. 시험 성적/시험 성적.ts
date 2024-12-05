import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const score = parseInt(input);

let result: string;
if (score >= 90 && score <= 100) result = 'A';
else if (score >= 80) result = 'B';
else if (score >= 70) result = 'C';
else if (score >= 60) result = 'D';
else result = 'F';

console.log(result);