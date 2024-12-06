# [Easy] [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) - 125

### 구분

알고리즘, 데이터구조

## Python3 문제풀이

```py
class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub('[^a-z0-9]', '', s.lower())
        return s == s[::-1]
```

### 성능 요약

- 실행 시간: 7 ms (81.48%)
- 메모리 사용량: 18.8 MB (17.37%)

### 제출 일자

2024년 12월 06일 (금) 15:12

> 출처: LeetCode, https://leetcode.com/problemset