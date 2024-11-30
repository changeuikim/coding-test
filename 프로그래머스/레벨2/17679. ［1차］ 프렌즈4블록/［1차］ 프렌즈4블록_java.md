# [Lv.2] [[1차] 프렌즈4블록](https://school.programmers.co.kr/learn/courses/30/lessons/17679?language=java) - 17679 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    private static class Pair {
        int x, y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return this.x == pair.x && this.y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];
        for (int i = 0; i < m; i++) {
            blocks[i] = board[i].toCharArray();
        }
        int result = 0;

        while (true) {
            // 기능1: Pop 요소를 판별
            Set<Pair> popSet = new HashSet<>();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = blocks[i][j];
                    // 우측, 우하단, 하단
                    if (c != ' ' && c == blocks[i][j + 1] && c == blocks[i + 1][j + 1] && c == blocks[i + 1][j]) {
                        popSet.add(new Pair(i, j));
                        popSet.add(new Pair(i, j + 1));
                        popSet.add(new Pair(i + 1, j + 1));
                        popSet.add(new Pair(i + 1, j));
                    }
                }
            }

            // 기능2: 점수 업데이트
            if (popSet.isEmpty()) {
                break;
            }

            result += popSet.size();

            // 기능3: 블록 내리기
            for (Pair p : popSet) {
                blocks[p.x][p.y] = ' ';
            }

            for (int j = 0; j < n; j++) {
                int blankIdx = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (blocks[i][j] != ' ') {
                        blocks[blankIdx][j] = blocks[i][j];
                        if (blankIdx != i) {
                            blocks[i][j] = ' ';
                        }
                        blankIdx--;
                    }
                }
            }
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 10.25 ms, 메모리: 75.2 MB

2. 시간: 3.81 ms, 메모리: 86.5 MB
3. 시간: 3.18 ms, 메모리: 76.7 MB
4. 시간: 2.66 ms, 메모리: 74.3 MB
5. 시간: 2.20 ms, 메모리: 76.8 MB

### 제출 일자

2024년 11월 30일 (토) 23:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges