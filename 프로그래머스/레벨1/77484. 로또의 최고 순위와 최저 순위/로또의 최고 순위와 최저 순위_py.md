# [Lv.1] [로또의 최고 순위와 최저 순위](https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=python3) - 77484 

### 구분

코딩테스트 연습 > 2021 Dev－Matching： 웹 백엔드 개발자（상반기）

## Python 문제풀이

```py
def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    zero_count = 0
    lottos_set = set()
    
    for num in lottos:
        if num == 0:
            zero_count += 1
        else:
            lottos_set.add(num)
            
    inter_count = 0
    
    for num in win_nums:
        if num in lottos_set:
            inter_count += 1
            
    max_count = inter_count + zero_count
    min_count = inter_count

    return [rank[max_count], rank[min_count]]
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 10.2 MB

2. 시간: 0.01 ms, 메모리: 10.1 MB
3. 시간: 0.00 ms, 메모리: 10.4 MB
4. 시간: 0.00 ms, 메모리: 10.4 MB
5. 시간: 0.00 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 23일 (토) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges