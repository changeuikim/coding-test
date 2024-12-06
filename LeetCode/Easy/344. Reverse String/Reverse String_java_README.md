# [Easy] [Reverse String](https://leetcode.com/problems/reverse-string) - 344

### 구분

알고리즘, 데이터구조

## Java 문제풀이

```java
class Solution {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
```

### 성능 요약

- 실행 시간: 0 ms (100%)
- 메모리 사용량: 45.5 MB (88.42%)

### 제출 일자

2024년 12월 06일 (금) 16:12

> 출처: LeetCode, https://leetcode.com/problemset