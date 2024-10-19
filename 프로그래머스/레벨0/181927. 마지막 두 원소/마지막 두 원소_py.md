# [Lv.0] [마지막 두 원소](https://school.programmers.co.kr/learn/courses/30/lessons/181927?language=python3) - 181927 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(num_list):
    last_num = num_list[-1]
    pre_num = num_list[-2]
    
    if last_num > pre_num:
        num_list.append(last_num - pre_num)
    else:
        num_list.append(2 * last_num)
        
    return num_list
    
```

### 성능 요약

1. 시간: 0.00 ms, 메모리: 10.3 MB

2. 시간: 0.00 ms, 메모리: 10.3 MB
3. 시간: 0.00 ms, 메모리: 10.2 MB
4. 시간: 0.00 ms, 메모리: 10.2 MB
5. 시간: 0.00 ms, 메모리: 10.2 MB

### 제출 일자

2024년 10월 19일 (토) 20:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges