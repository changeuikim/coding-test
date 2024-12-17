#include <bits/stdc++.h>
using namespace std;

void topologicalSort() {
    // 선행은 모두 1 이상 (K-1) 이하 : 1부터 N까지 이미 위상 정렬 됨
    int N;
    cin >> N;

    vector<int> dp(N + 1, 0);
    for (int v = 1; v <= N; v++) {
        int time, size;
        cin >> time >> size;

        // 작업시간 설정
        dp[v] = time;
        // 선행시간 반영
        while (size--) {
            int u;
            cin >> u;

            dp[v] = max(dp[v], dp[u] + time);
        }
    }

    // 가장 늦게 끝나는 작업을 반환
    cout << *max_element(dp.begin() + 1, dp.end());
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    topologicalSort();
}