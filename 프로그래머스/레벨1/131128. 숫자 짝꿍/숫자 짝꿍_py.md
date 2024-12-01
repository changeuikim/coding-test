# [Lv.1] [숫자 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=python3) - 131128 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(X, Y):
    # X, Y의 MAP
    x_map = dict()
    y_map = dict()

    for ch in X:
        x_map[ch] = x_map.get(ch, 0) + 1
    
    for ch in Y:
        y_map[ch] = y_map.get(ch, 0) + 1
    
    # X, Y의 교집합 키
    r_keys = []
    for i in range(9, -1, -1):
        key = str(i)
        if key in x_map and key in y_map:
            r_keys.append(key)
    
    # 조기 반환
    if not r_keys:
        return "-1"
    elif r_keys[0] == "0":
        return "0"
    
    # 결과 반환   
    return "".join(key * min(x_map[key], y_map[key]) for key in r_keys)
```

### 성능 요약

1. 시간: 696.43 ms, 메모리: 29.9 MB

2. 시간: 681.27 ms, 메모리: 29.9 MB
3. 시간: 631.86 ms, 메모리: 29.9 MB
4. 시간: 626.49 ms, 메모리: 30 MB
5. 시간: 614.43 ms, 메모리: 30 MB

### 제출 일자

2024년 12월 01일 (일) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges