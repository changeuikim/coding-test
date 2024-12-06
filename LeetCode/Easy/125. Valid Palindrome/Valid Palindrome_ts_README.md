# [Easy] [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) - 125

### 구분

알고리즘, 데이터구조

## TypeScript 문제풀이

```ts
function isPalindrome(s: string): boolean {
  s = s.toLowerCase().replace(/[^a-z0-9]/g, '');
  for (let i = 0, j = s.length - 1; i < j; i++, j--) {
    if (s.charAt(i) != s.charAt(j)) return false;
  }
  return true;
}
```

### 성능 요약

- 실행 시간: 3 ms (88.77%)
- 메모리 사용량: 52.1 MB (91.41%)

### 제출 일자

2024년 12월 06일 (금) 15:17

> 출처: LeetCode, https://leetcode.com/problemset