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