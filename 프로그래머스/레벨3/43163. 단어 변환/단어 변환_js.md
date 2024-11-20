# [Lv.3] [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163?language=javascript) - 43163 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## JavaScript 문제풀이

```js
function solution(begin, target, words) {
    if (!words.includes(target)) {
        return 0;
    }
    
    const queue = [[begin, 0]];
    const visited = new Array(words.length).fill(false);
    
    while (queue.length > 0) {
        const [cur, cnt] = queue.shift();
        
        // 종료조건
        if (cur === target) {
            return cnt;
        }
        
        // 1글자만 다르다면 엔큐
        for (let idx = 0; idx < words.length; idx++) {
            const word = words[idx];
            
            if (visited[idx]) {
                continue;
            }
            
            // 자리별 차이 계산
            let dif = 0;
            for (let i = 0; i < begin.length; i++) {
                if (cur[i] !== word[i]) {
                    dif++;
                }
                if (dif > 1) {
                    break;
                }
            }
            
            // 엔큐
            if (dif === 1) {
                visited[idx] = true;
                queue.push([word, cnt + 1]);
            }
        }
    }
    
    return 0;
}
```

### 성능 요약

1. 시간: 0.27 ms, 메모리: 33.5 MB

2. 시간: 0.22 ms, 메모리: 33.4 MB
3. 시간: 0.09 ms, 메모리: 33.5 MB
4. 시간: 0.09 ms, 메모리: 33.4 MB
5. 시간: 0.07 ms, 메모리: 33.3 MB

### 제출 일자

2024년 11월 20일 (수) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges