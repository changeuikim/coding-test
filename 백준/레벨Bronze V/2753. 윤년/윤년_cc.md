# [Bronze V] [윤년](https://www.acmicpc.net/problem/2753) - 2753 

NaN구현, 사칙연산, 수학

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int year;
  cin >> year;

  bool result = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

  cout << result ? 1 : 0;
}
```

### 성능 요약

시간: 0 ms

메모리: 2208 KB

### 제출 일자

2024년 12월 05일 (목) 13:10

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

