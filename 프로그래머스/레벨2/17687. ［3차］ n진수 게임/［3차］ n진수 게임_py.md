# [Lv.2] [[3차] n진수 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17687?language=python3) - 17687 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def solution(n, t, m, p):
    res = []
    num = 0
    seq = []

    while len(res) < t:
        if len(seq) >= m:
            res.append(seq[p - 1])
            seq = seq[m:]
        else:
            seq.extend(list(base_converter(num, n)))
            num += 1

    return ''.join(res)

def base_converter(number, base):
    chars = "0123456789ABCDEF"
    if number == 0:
        return "0"
    
    res = []
    while number > 0:
        res.append(chars[number % base])
        number //= base
        
    return ''.join(reversed(res))

```

### 성능 요약

1. 시간: 34.14 ms, 메모리: 10.2 MB

2. 시간: 30.84 ms, 메모리: 10 MB
3. 시간: 30.38 ms, 메모리: 10.1 MB
4. 시간: 12.75 ms, 메모리: 10.3 MB
5. 시간: 10.41 ms, 메모리: 10.3 MB

### 제출 일자

2024년 11월 11일 (월) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges