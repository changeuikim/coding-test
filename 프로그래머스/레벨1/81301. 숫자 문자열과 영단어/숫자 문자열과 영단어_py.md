# [Lv.1] [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=python3) - 81301 

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

## Python 문제풀이

```py
def solution(s):
    num_map = {
        'zero':'0',
        'one':'1',
        'two':'2',
        'three':'3',
        'four':'4',
        'five':'5',
        'six':'6',
        'seven':'7',
        'eight':'8',
        'nine':'9'        
    }
    
    for key, val in num_map.items():
        s = s.replace(key, val)
    
    return int(s)
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 10.3 MB

2. 시간: 0.03 ms, 메모리: 10.3 MB
3. 시간: 0.02 ms, 메모리: 10.5 MB
4. 시간: 0.02 ms, 메모리: 10.4 MB
5. 시간: 0.02 ms, 메모리: 10.4 MB

### 제출 일자

2024년 11월 06일 (수) 22:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges