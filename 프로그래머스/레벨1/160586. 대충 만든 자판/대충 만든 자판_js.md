# [Lv.1] [대충 만든 자판](https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=javascript) - 160586 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(keymap, targets) {
    // 키 사전 생성
    const keyMap = new Map();

    keymap.forEach(key => {
        for (let idx = 0; idx < key.length; idx++) {
            const ch = key[idx];
            if (!keyMap.has(ch)) {
                keyMap.set(ch, idx + 1);
            } else {
                keyMap.set(ch, Math.min(keyMap.get(ch), idx + 1));
            }
        }
    });

    // 결과 처리
    return targets.map(target => {
        let acc = 0;
        for (let i = 0; i < target.length; i++) {
            const ch = target[i];
            if (!keyMap.has(ch)) {
                return -1;
            }
            acc += keyMap.get(ch);
        }
        return acc;
    });
}
```

### 성능 요약

1. 시간: 2.10 ms, 메모리: 36.9 MB

2. 시간: 1.64 ms, 메모리: 36.8 MB
3. 시간: 1.62 ms, 메모리: 36.8 MB
4. 시간: 1.57 ms, 메모리: 36.8 MB
5. 시간: 1.49 ms, 메모리: 36.8 MB

### 제출 일자

2024년 11월 28일 (목) 23:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges