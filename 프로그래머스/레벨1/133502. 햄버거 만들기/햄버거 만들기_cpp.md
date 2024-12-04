# [Lv.1] [햄버거 만들기](https://programmers.co.kr/) - 133502 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    vector<int>stack(ingredient.size(),0);
    int top = -1;
    int result = 0;
    
    for (int item : ingredient) {
        stack[++top] = item;

        if (top >= 3) {
            if (stack[top] == 1 && stack[top-1] == 3 && stack[top-2] == 2 && stack[top-3] == 1) {
                top -= 4;
                result++;
            }
        }
    }

    return result;    
}
```

### 성능 요약

1. 시간: 11.28 ms, 메모리: 38.5 MB

2. 시간: 8.39 ms, 메모리: 32.6 MB
3. 시간: 7.52 ms, 메모리: 26.1 MB
4. 시간: 5.36 ms, 메모리: 23.8 MB
5. 시간: 4.54 ms, 메모리: 19.5 MB

### 제출 일자

2024년 12월 04일 (수) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges