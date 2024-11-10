# [Lv.2] [[3차] 압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=javascript) - 17684 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(msg) {
    const result = [];
    
    // LZW 사전
    const dic = new Map();
    for (let i = 0; i < 26; i++) {
        dic.set(String.fromCharCode('A'.charCodeAt(0) + i), i + 1);
    }
    let idx = 27;
    
    // 압축
    let w = "";
    for (let c of msg) {
        let wc = w + c;
        if (dic.has(wc)) {
            w = wc;
        } else {
            result.push(dic.get(w));
            dic.set(wc, idx);
            idx++;
            w = c;
        }
    }
    
    // 잔여 처리
    if (w != "") {
        result.push(dic.get(w));
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.43 ms, 메모리: 33.6 MB

2. 시간: 0.43 ms, 메모리: 33.5 MB
3. 시간: 0.40 ms, 메모리: 33.6 MB
4. 시간: 0.40 ms, 메모리: 33.5 MB
5. 시간: 0.38 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 10일 (일) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges