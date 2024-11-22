# [Lv.2] [스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=python3) - 49993 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Python 문제풀이

```py
def is_valid(skill_order, skill_tree, skill_set):    
    idx = 0

    for c in skill_tree:
        if c in skill_set:
            if c == skill_order[idx]:
                idx += 1
            else:
                return False

    return True

def solution(skill, skill_trees):    
    skill_set = set(skill)
    count = 0
    
    for skill_tree in skill_trees:
        if is_valid(skill, skill_tree, skill_set):
            count += 1

    return count
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.1 MB
3. 시간: 0.01 ms, 메모리: 10.1 MB
4. 시간: 0.01 ms, 메모리: 10 MB
5. 시간: 0.01 ms, 메모리: 10 MB

### 제출 일자

2024년 11월 22일 (금) 23:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges