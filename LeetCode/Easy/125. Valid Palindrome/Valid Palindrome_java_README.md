# [Easy] [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) - 125

### 구분

알고리즘, 데이터구조

## Java 문제풀이

```java
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;                
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
```

### 성능 요약

- 실행 시간: 2 ms (99.07%)
- 메모리 사용량: 42.7 MB (90.93%)

### 제출 일자

2024년 12월 06일 (금) 15:35

> 출처: LeetCode, https://leetcode.com/problemset