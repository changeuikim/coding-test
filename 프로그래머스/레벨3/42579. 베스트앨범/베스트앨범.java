import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<>());
            }
            songMap.get(genres[i]).add(new int[]{plays[i], i});
        }

        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        sortedGenres.sort((a, b) -> genreMap.get(b) - genreMap.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> sortedSongs = songMap.get(genre);
            sortedSongs.sort((a, b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
            for (int i = 0; i < Math.min(2, sortedSongs.size()); i++) {
                result.add(sortedSongs.get(i)[1]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}