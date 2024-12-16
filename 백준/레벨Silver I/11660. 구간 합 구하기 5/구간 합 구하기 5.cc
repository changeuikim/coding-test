#include <bits/stdc++.h>

using namespace std;

void rangeSum() {
    // 누적 합 초기화
    int N, M;
    cin >> N >> M;

    vector<vector<int>> nums(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> nums[i][j];
        }
    }    

    vector<vector<int>> pre(N+1, vector<int>(N+1, 0));
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + nums[i-1][j-1];
        }
    }      

    // 구간 합 처리
    while (M-- > 0) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int t = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1];
        cout << t << "\n";
    }      
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    rangeSum();
}