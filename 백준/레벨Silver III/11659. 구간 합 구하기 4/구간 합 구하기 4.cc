#include <bits/stdc++.h>

using namespace std;

void rangeSum() {
    // 누적 합 초기화
    int N, M;
    cin >> N >> M;

    vector<int> prefixSum(N + 1, 0);

    for (int i = 0; i < N; i++) {
        int t;
        cin >> t;
        prefixSum[i + 1] = prefixSum[i] + t;
    }

    while (M--) {
        int i, j;
        cin >> i >> j;
        cout << prefixSum[j] - prefixSum[i - 1] << "\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    rangeSum();
}