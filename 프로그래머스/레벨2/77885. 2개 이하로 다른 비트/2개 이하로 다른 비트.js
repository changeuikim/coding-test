function solution(numbers) {
    const result = [];

    numbers.forEach(num => {
        const bigNum = BigInt(num);
        
        // 첫번째 0은 1로, 뒤는 모두 0
        const biggerNum = bigNum + 1n;
        
        // 첫번째 0 이전은 0, 뒤는 모두 1
        const bitDiff = bigNum ^ (bigNum + 1n);
        
        // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        const minNum = biggerNum + (bitDiff >> 2n);

        result.push(Number(minNum));
    });

    return result;
}