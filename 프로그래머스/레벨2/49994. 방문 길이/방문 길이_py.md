# [Lv.2] [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=python3) - 49994 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Python 문제풀이

```py
def solution(dirs):
    # 방향 설정, 방문 기록, 초기 위치
    directions = {
        'U' : (0, 1),
        'D' : (0, -1),
        'R' : (1, 0),
        'L' : (-1, 0)
    }
    visited = set()
    x, y = (0, 0)
    
    # 방향 전환 및 이동 처리
    for d in dirs:
        dx, dy = directions[d]
        nx, ny = x + dx, y + dy
        
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            # 작은 좌표를 항상 시작점으로 정렬
            path = [(x, y), (nx, ny)]
            path.sort(key=lambda x: (x[0], x[1]))
                
            visited.add(tuple(path))
            x, y = nx, ny
    
    # 집합의 길이를 반환
    return len(visited)
```

### 성능 요약

1. 시간: 0.79 ms, 메모리: 10.3 MB

2. 시간: 0.78 ms, 메모리: 10.2 MB
3. 시간: 0.44 ms, 메모리: 10.3 MB
4. 시간: 0.43 ms, 메모리: 10.2 MB
5. 시간: 0.41 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 14일 (목) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges