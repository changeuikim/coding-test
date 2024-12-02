# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=javascript) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## JavaScript 문제풀이

```js
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
```

### 성능 요약

1. 시간: 34.94 ms, 메모리: 57.1 MB

2. 시간: 34.46 ms, 메모리: 50.5 MB
3. 시간: 31.34 ms, 메모리: 57.4 MB
4. 시간: 30.41 ms, 메모리: 56 MB
5. 시간: 27.03 ms, 메모리: 56 MB

### 제출 일자

2024년 12월 02일 (월) 19:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges