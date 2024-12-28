#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

struct Node {
    int vertex, cost;
    Node* prev;

    Node(int v, int c, Node* p) : vertex(v), cost(c), prev(p) {}

    bool operator<(const Node& o) const {
        return cost > o.cost;
    }   
};

void dijkstra() {
    int N, M;
    cin >> N >> M;

    // 인접리스트 초기화
    vector<vector<pii>> graph(N + 1);

    for (int i = 0; i < M; ++i) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].emplace_back(v, w);
    }

    // 출발점, 도착점
    int S, E;
    cin >> S >> E;

    // 거리 초기화
    const int INF = 1e9;
    vector<int> dist(N + 1, INF);
    dist[S] = 0;

    // 우선순위 큐 초기화
    priority_queue<Node> pq;
    pq.push(Node(S, 0, nullptr));

    // 다익스트라
    Node* endNode = nullptr;
    while (!pq.empty()) {
        Node current = pq.top();
        pq.pop();

        int cur = current.cost, u = current.vertex;

        if (cur > dist[u]) continue;

        if (u == E) {
            endNode = new Node(current);
            break;
        }

        for (auto& neighbor : graph[u]) {
            int v = neighbor.first, w = neighbor.second;
            int nxt = cur + w;
            if (dist[v] > nxt) {
                dist[v] = nxt;
                pq.push(Node(v, nxt, new Node(current)));
            }
        }    
    }
    
    // 최단거리 경로복원
    vector<int> path;
    while (endNode != nullptr) {
        path.push_back(endNode->vertex);
        endNode = endNode->prev;
    }
    reverse(path.begin(), path.end());

    cout << dist[E] << "\n";
    cout << path.size() << "\n";
    for (int p : path) {
        cout << p << " ";
    }    
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    dijkstra();
}