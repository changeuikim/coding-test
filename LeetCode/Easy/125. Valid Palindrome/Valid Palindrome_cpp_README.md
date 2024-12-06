# [Easy] [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) - 125

### 구분

알고리즘, 데이터구조

## C++ 문제풀이

```cpp
class Solution {
public:
    bool isPalindrome(string s) {
      int start = 0, end = s.length() - 1;
      while (start < end) {
        if (!isalnum(s[start])) start++;
        else if (!isalnum(s[end])) end--;
        else {
          if (tolower(s[start]) != tolower(s[end])) return false;
          start++;
          end--;
        }
      }
      return true;
    }
};
```

### 성능 요약

- 실행 시간: 0 ms (100%)
- 메모리 사용량: 9.9 MB (12.92%)

### 제출 일자

2024년 12월 06일 (금) 15:40

> 출처: LeetCode, https://leetcode.com/problemset