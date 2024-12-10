#include <bits/stdc++.h>

using namespace std;

string noteConverter(const string& melody) {
    string result;
    for (char note : melody) {
        if (note == '#') {
            result.back() = tolower(result.back());
        } else {
            result.push_back(note);
        }
    }
    return result;
}

int minuteConverter(const string& timeString) {
    size_t colonPos = timeString.find(':');
    int hour = stoi(timeString.substr(0, colonPos));
    int minute = stoi(timeString.substr(colonPos + 1));
    return 60 * hour + minute;
}

string melodyRepeater(const string& melody, int playTime) {
    string result;
    int repeatCount = ceil(static_cast<double>(playTime) / melody.size());
    for (int i = 0; i < repeatCount; ++i) {
        result += melody;
    }
    return result.substr(0, playTime);
}

string solution(string m, vector<string> musicinfos) {
    string convM = noteConverter(m);
    string resultTitle = "(None)";
    int resultTime = 0;

    for (const string& musicinfo : musicinfos) {
        stringstream ss(musicinfo);
        string start, end, title, melody;

        getline(ss, start, ',');
        getline(ss, end, ',');
        getline(ss, title, ',');
        getline(ss, melody, ',');

        int playTime = minuteConverter(end) - minuteConverter(start);
        string convMelody = noteConverter(melody);
        string repeatedMelody = melodyRepeater(convMelody, playTime);

        if (repeatedMelody.find(convM) != string::npos && playTime > resultTime) {
            resultTitle = title;
            resultTime = playTime;
        }
    }

    return resultTitle;
}