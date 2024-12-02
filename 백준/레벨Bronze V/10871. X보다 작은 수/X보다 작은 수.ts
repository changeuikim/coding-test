import fs = require('fs');

const input: string = fs.readFileSync('/dev/stdin').toString().trim();

// 입력 처리
const lines: string[] = input.split('\n');
const [N, X]: number[] = lines[0].split(' ').map(Number);
const A: number[] = lines[1].split(' ').map(Number);

// 결과 처리
const result: number[] = A.filter(a => a < X);

// 출력 처리
console.log(result.join(' '));