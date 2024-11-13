# [Lv.1] [실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=python3) - 42889 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def solution(N, stages):
    # 각 스테이지에 멈춘 플레이어 수 계산
    stage_players = [0] * (N + 2)
    for stage in stages:
        stage_players[stage] += 1
    
    # 각 스테이지의 실패율 계산
    stage_failure = []
    players = len(stages)
    
    for stage in range(1, N + 1):
        failure_rate = stage_players[stage] / players if players > 0 else 0;
        stage_failure.append((stage, failure_rate))
        players -= stage_players[stage]
    
    # 실패율 내림차순, 스테이지 오름차순
    stage_failure.sort(key=lambda x: (-x[1], x[0]))
    
    return [stage for stage, _ in stage_failure]
```

### 성능 요약

1. 시간: 18.94 ms, 메모리: 18.1 MB

2. 시간: 17.75 ms, 메모리: 11.5 MB
3. 시간: 14.97 ms, 메모리: 11.4 MB
4. 시간: 14.48 ms, 메모리: 14.8 MB
5. 시간: 13.31 ms, 메모리: 14.9 MB

### 제출 일자

2024년 11월 13일 (수) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges