# [Lv.2] [롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=python3) - 132265 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(topping):
    result = 0
    
    # 인덱스가 토핑 번호, 요소가 토핑의 수
    left = [0] * (10000 + 1)
    right = [0] * (10000 + 1)
    
    # 동생 초기화
    rc = 0    
    for i in topping:
        if right[i] == 0:
            rc += 1
        right[i] += 1
    
    # 슬라이딩 윈도우
    lc = 0
    for i in topping:
        # 동생 제거
        right[i] -= 1
        if right[i] == 0:
            rc -= 1
            
        # 철수 추가
        if left[i] == 0:
            lc += 1
        left[i] += 1
        
        # 비교
        if lc == rc:
            result += 1
    
    return result
```

### 성능 요약

1. 시간: 381.28 ms, 메모리: 50.5 MB

2. 시간: 345.88 ms, 메모리: 50.5 MB
3. 시간: 317.02 ms, 메모리: 50.6 MB
4. 시간: 314.26 ms, 메모리: 51.3 MB
5. 시간: 313.76 ms, 메모리: 50.6 MB

### 제출 일자

2024년 11월 10일 (일) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges