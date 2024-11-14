# [Lv.2] [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=javascript) - 49994 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## JavaScript 문제풀이

```js
function solution(dirs) {
    // 방향 설정, 방문 기록, 초기 위치
    const directions = {
        'U': [0, 1],
        'D': [0, -1],
        'R': [1, 0],
        'L': [-1, 0]
    };
    const visited = new Set();
    let x = 0, y = 0;
    
    // 방향 전환 및 이동 처리
    for (const d of dirs) {
        const [dx, dy] = directions[d];
        const nx = x + dx;
        const ny = y + dy;
        
        if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
            // 작은 좌표를 항상 시작점으로 정렬
            let path = [[x, y], [nx, ny]];
            path.sort((a, b) => {
                if (a[0] !== b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            
            visited.add(JSON.stringify(path));
            x = nx;
            y = ny;
        }
    }
    
    // 집합의 길이를 반환
    return visited.size;
}
```

### 성능 요약

1. 시간: 1.17 ms, 메모리: 34.1 MB

2. 시간: 1.13 ms, 메모리: 34.1 MB
3. 시간: 1.12 ms, 메모리: 33.9 MB
4. 시간: 1.10 ms, 메모리: 34.1 MB
5. 시간: 1.08 ms, 메모리: 34.1 MB

### 제출 일자

2024년 11월 14일 (목) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges