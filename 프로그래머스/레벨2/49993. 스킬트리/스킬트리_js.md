# [Lv.2] [스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=javascript) - 49993 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## JavaScript 문제풀이

```js
const isValid = (skillOrder, skillTree, skillSet) => {
    let idx = 0;
    
    for (const skill of skillTree) {
        if (skillSet.has(skill)) {
            if (skill === skillOrder[idx]) {
                idx++;
            } else {
                return false;
            }
        }
    }
    
    return true;
}

function solution(skill, skill_trees) {
    const skillSet = new Set(skill);
    let count = 0;
    
    for (const skillTree of skill_trees) {
        if (isValid(skill, skillTree, skillSet)) {
            count++;
        }
    }
    
    return count;
}
```

### 성능 요약

1. 시간: 0.30 ms, 메모리: 33.3 MB

2. 시간: 0.22 ms, 메모리: 33.4 MB
3. 시간: 0.22 ms, 메모리: 33.3 MB
4. 시간: 0.21 ms, 메모리: 33.4 MB
5. 시간: 0.20 ms, 메모리: 33.3 MB

### 제출 일자

2024년 11월 22일 (금) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges