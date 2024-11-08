# [Lv.2] [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=python3) - 43165 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Python 문제풀이

```py
def dfs(idx, cur_sum, max_sum, numbers, target):
    # 베이스 케이스 Base Case
    if idx == len(numbers):
        return 1 if cur_sum == target else 0
    
    # 가지치기 Pruning
    if target > cur_sum + max_sum or target < cur_sum - max_sum:    
        return 0    
    max_sum -= numbers[idx]
    
    # 재귀 Recursion
    return dfs(idx + 1, cur_sum - numbers[idx], max_sum, numbers, target) + \
           dfs(idx + 1, cur_sum + numbers[idx], max_sum, numbers, target);

def solution(numbers, target):
    return dfs(0, 0, sum(numbers), numbers, target)
    
```

### 성능 요약

1. 시간: 207.29 ms, 메모리: 10.2 MB

2. 시간: 163.52 ms, 메모리: 10.1 MB
3. 시간: 4.48 ms, 메모리: 10 MB
4. 시간: 2.10 ms, 메모리: 10.1 MB
5. 시간: 0.42 ms, 메모리: 10.1 MB

### 제출 일자

2024년 11월 08일 (금) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges