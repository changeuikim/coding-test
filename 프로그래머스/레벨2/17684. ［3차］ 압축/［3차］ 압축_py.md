# [Lv.2] [[3차] 압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=python3) - 17684 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def solution(msg):
    result = []
    
    # LZW 사전
    dic = dict()
    for i in range(26):
        dic[chr(ord('A') + i)] = i + 1    
    idx = 27
    
    # 압축
    w = ""
    for c in msg:
        wc = w + c
        if wc in dic:
            w = wc
        else:
            result.append(dic[w])
            dic[wc] = idx
            idx += 1
            w = c
    
    # 잔여 처리
    if w:
        result.append(dic[w])
    
    return result
```

### 성능 요약

1. 시간: 0.21 ms, 메모리: 10.2 MB

2. 시간: 0.20 ms, 메모리: 10.3 MB
3. 시간: 0.20 ms, 메모리: 10.2 MB
4. 시간: 0.18 ms, 메모리: 10.2 MB
5. 시간: 0.16 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 10일 (일) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges