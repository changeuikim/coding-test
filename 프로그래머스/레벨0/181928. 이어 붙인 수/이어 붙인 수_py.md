# [Lv.0] [이어 붙인 수](https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=python3) - 181928 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Python 문제풀이

```py
def solution(num_list):
    odd_nums = ''.join([str(num) for num in num_list if num&1 == 1])
    even_nums = ''.join([str(num) for num in num_list if num&1 == 0])
    
    return int(odd_nums) + int(even_nums)
    

```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 10.4 MB

2. 시간: 0.03 ms, 메모리: 10.4 MB
3. 시간: 0.03 ms, 메모리: 10.3 MB
4. 시간: 0.03 ms, 메모리: 10.3 MB
5. 시간: 0.03 ms, 메모리: 10.3 MB

### 제출 일자

2024년 10월 18일 (금) 11:29

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges