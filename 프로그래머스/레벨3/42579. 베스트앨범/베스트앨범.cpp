#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, int> genreMap;
    unordered_map<string, vector<pair<int, int>>> songMap;

    for (int i = 0; i < genres.size(); i++) {
        genreMap[genres[i]] += plays[i];
        songMap[genres[i]].emplace_back(plays[i], i);
    }

    vector<string> sortedGenres;
    for (const auto& g : genreMap) {
        sortedGenres.push_back(g.first);
    }
    sort(sortedGenres.begin(), sortedGenres.end(), [&](const string& a, const string& b) {
        return genreMap[b] < genreMap[a];
    });

    vector<int> result;
    for (const string& genre : sortedGenres) {
        auto& songs = songMap[genre];
        sort(songs.begin(), songs.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first == b.first ? a.second < b.second : a.first > b.first;
        });
        for (int i = 0; i < min(2, (int)songs.size()); i++) {
            result.push_back(songs[i].second);
        }
    }

    return result;
}
