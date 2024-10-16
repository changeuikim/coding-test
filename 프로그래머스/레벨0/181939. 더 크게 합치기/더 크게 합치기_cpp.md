# [Lv.0] [더 크게 합치기](https://school.programmers.co.kr/learn/courses/30/lessons/181939?language=cpp) - 181939 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <bits/stdc++.h>

using namespace std;

int solution(int a, int b) {   
    
    int a_num = stoi(to_string(a) + to_string(b));
    int b_num = stoi(to_string(b) + to_string(a));
    
    return max(a_num, b_num);
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.19 MB

2. 시간: 0.02 ms, 메모리: 4.18 MB
3. 시간: 0.02 ms, 메모리: 4.13 MB
4. 시간: 0.02 ms, 메모리: 4.03 MB
5. 시간: 0.02 ms, 메모리: 3.72 MB

### 제출 일자

2024년 10월 17일 (목) 02:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges