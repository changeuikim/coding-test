# [Lv.2] [스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=java) - 49993 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Java 문제풀이

```java
import java.util.Set;
import java.util.HashSet;

class Solution {    
    public static boolean isValid(String skillOrder, String skillTree, Set<Character> skillSet) {
        int idx = 0;

        for (int i = 0; i < skillTree.length(); i++) {
            char c = skillTree.charAt(i);
            if (skillSet.contains(c)) {
                if (c == skillOrder.charAt(idx)) {
                    idx++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        Set<Character> skillSet = new HashSet<>();
        int count = 0;
        
        for (int i = 0; i < skill.length(); i++) {
            skillSet.add(skill.charAt(i));
        }    
        
        for (String skillTree : skill_trees) {
            if (isValid(skill, skillTree, skillSet)) {
                count++;
            }
        }
        
        return count;
    }
}
```

### 성능 요약

1. 시간: 0.21 ms, 메모리: 80.7 MB

2. 시간: 0.20 ms, 메모리: 77 MB
3. 시간: 0.20 ms, 메모리: 75.9 MB
4. 시간: 0.18 ms, 메모리: 78.6 MB
5. 시간: 0.17 ms, 메모리: 67.1 MB

### 제출 일자

2024년 11월 22일 (금) 23:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges