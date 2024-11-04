# [Lv.1] [최대공약수와 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12940?language=javascript) - 12940 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
const gcd = (n, m) => {
    while (m > 0) {
        let temp = m;
        m = n % m;
        n = temp;
    }
    return n;
}

const lcm = (n, m) => {
    return (n * m) / gcd(n, m);
}

function solution(n, m) {    
    return [gcd(n, m), lcm(n, m)];
}
```

### 성능 요약

1. 시간: 0.07 ms, 메모리: 33.5 MB

2. 시간: 0.07 ms, 메모리: 33.4 MB
3. 시간: 0.06 ms, 메모리: 33.4 MB
4. 시간: 0.06 ms, 메모리: 33.4 MB
5. 시간: 0.05 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 04일 (월) 20:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges