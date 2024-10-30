# [Lv.1] [약수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12928?language=javascript) - 12928 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(n) {
    const divisors = [];
    
    // 제곱근 이하의 범위에서 절반의 약수를 구할 수 있다.
    for (let i = 1; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            divisors.push(i);
            
            // 제곱수는 제외한다.
            if (i !== n / i) {
                
                // 약수로 나눈 수도 약수이다.
                divisors.push(n / i);
            }
        }
    }
    
    return divisors.reduce((sum, num) => sum + num, 0);
}
```

### 성능 요약

1. 시간: 0.20 ms, 메모리: 33.4 MB

2. 시간: 0.19 ms, 메모리: 33.4 MB
3. 시간: 0.15 ms, 메모리: 33.4 MB
4. 시간: 0.14 ms, 메모리: 33.4 MB
5. 시간: 0.14 ms, 메모리: 33.4 MB

### 제출 일자

2024년 10월 30일 (수) 21:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges