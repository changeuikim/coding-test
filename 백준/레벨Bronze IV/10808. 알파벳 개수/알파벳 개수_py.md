# [Bronze IV] [알파벳 개수](https://www.acmicpc.net/problem/10808) - 10808 

NaN구현, 문자열

## PyPy3 문제풀이

```PyPy3
word = input().rstrip()
alphabet = [0] * 26
ascii_a = ord('a')

for ch in word:
    alphabet[ord(ch) - ascii_a] += 1

print(*alphabet)
```

### 성능 요약

시간: 92 ms

메모리: 108080 KB

### 제출 일자

2024년 12월 05일 (목) 16:17

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

