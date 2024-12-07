from collections import defaultdict

def solution(genres, plays):
    genre_map = defaultdict(int)
    song_map = defaultdict(list)

    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_map[genre] += play
        song_map[genre].append((play, i))

    sorted_genres = sorted(genre_map.keys(), key=lambda x: genre_map[x], reverse=True)

    result = []
    for genre in sorted_genres:
        sorted_songs = sorted(song_map[genre], key=lambda x: (-x[0], x[1]))
        result.extend([song[1] for song in sorted_songs[:2]])

    return result