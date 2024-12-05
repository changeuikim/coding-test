import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const wordToAscii = input.split('').map((it: string) => it.charCodeAt(0));
const alphabet = Array(26).fill(0);

for (const ascii of wordToAscii) alphabet[ascii - 'a'.charCodeAt(0)]++;

console.log(alphabet.join(' '));