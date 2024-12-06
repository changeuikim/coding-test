# [Easy] [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) - 125

### 구분

알고리즘, 데이터구조

## Python3 문제풀이

```py
class Solution:
    def isPalindrome(self, s: str) -> bool:
        start, end = 0, len(s) - 1
        while start <= end:
            if not s[start].isalnum():
                start += 1
            elif not s[end].isalnum():
                end -= 1
            else:
                if s[start].lower() != s[end].lower():
                    return False
                start += 1
                end -= 1
        return True
```

### 성능 요약

- 실행 시간: 7 ms (81.48%)
- 메모리 사용량: 17.7 MB (33.08%)

### 제출 일자

2024년 12월 06일 (금) 15:09

> 출처: LeetCode, https://leetcode.com/problemset