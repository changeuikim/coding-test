# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

int n, x, a[10005];
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // 입력 처리
    cin >> n >> x;
    for (size_t i = 0; i < n; ++i) cin >> a[i];
    
    // 출력 처리
    for (size_t i = 0; i < n; ++i) {
        if (a[i] < x) cout << a[i] << ' ';
    }
}
```

### 성능 요약

시간: 0 ms

메모리: 2248 KB

### 제출 일자

2024년 12월 02일 (월) 22:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

