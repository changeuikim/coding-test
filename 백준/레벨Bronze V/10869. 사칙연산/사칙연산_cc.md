# [Bronze V] [사칙연산](https://www.acmicpc.net/problem/10869) - 10869 

NaN구현, 사칙연산, 수학

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <iostream>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int a, b;
  cin >> a >> b;
  
  cout << a+b << '\n'
       << a-b << '\n'
       << a*b << '\n'
       << a/b << '\n'
       << a%b;
}
```

### 성능 요약

시간: 0 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 05일 (목) 10:58

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

