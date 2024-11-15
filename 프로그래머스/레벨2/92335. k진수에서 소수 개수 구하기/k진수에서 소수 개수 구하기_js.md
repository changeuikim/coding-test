# [Lv.2] [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=javascript) - 92335 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
const isPrime = (num) => {
    if (num < 2) return false;
    if (num === 2 || num === 3) return true;
    if (num % 2 === 0 || num % 3 === 0) return false;
    
    const sqrt = Math.sqrt(num)
    for (let i = 5; i <= sqrt; i += 6) {
        if (num % i === 0) return false;
    }
    
    return true;
};

function solution(n, k) {
    const kNum = n.toString(k);
    let cnt = 0;

    kNum.split('0').forEach(num => {
        if (num && isPrime(+num)) {
            cnt++;
        }
    });

    return cnt;
}
```

### 성능 요약

1. 시간: 3.10 ms, 메모리: 36.4 MB

2. 시간: 0.09 ms, 메모리: 33.5 MB
3. 시간: 0.09 ms, 메모리: 33.5 MB
4. 시간: 0.08 ms, 메모리: 33.6 MB
5. 시간: 0.08 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 15일 (금) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges