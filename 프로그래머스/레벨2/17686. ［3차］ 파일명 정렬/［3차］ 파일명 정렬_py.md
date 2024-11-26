# [Lv.2] [[3차] 파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=python3) - 17686 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
import re

def solution(files):
    pattern = re.compile(r'([a-zA-Z\-\. ]+)(\d{1,5})')
    parsed_files = []

    for file in files:
        match = pattern.match(file)
        head = match.group(1)
        number = match.group(2)
        parsed_files.append((head, int(number), file))

    parsed_files.sort(key=lambda x: (x[0].lower(), x[1]))

    return [file[2] for file in parsed_files]
```

### 성능 요약

1. 시간: 2.81 ms, 메모리: 10.5 MB

2. 시간: 2.75 ms, 메모리: 10.7 MB
3. 시간: 2.51 ms, 메모리: 10.5 MB
4. 시간: 2.37 ms, 메모리: 10.7 MB
5. 시간: 2.36 ms, 메모리: 10.7 MB

### 제출 일자

2024년 11월 26일 (화) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges