function solution(genres, plays) {
    const genreMap = new Map();
    const songMap = new Map();

    genres.forEach((genre, i) => {
        genreMap.set(genre, (genreMap.get(genre) || 0) + plays[i]);
        if (!songMap.has(genre)) songMap.set(genre, []);
        songMap.get(genre).push([plays[i], i]);
    });

    const sortedGenres = Array.from(genreMap.keys()).sort((a, b) => genreMap.get(b) - genreMap.get(a));

    const result = [];
    sortedGenres.forEach((genre) => {
        const sortedSongs = songMap.get(genre).sort((a, b) => b[0] - a[0] || a[1] - b[1]);
        result.push(...sortedSongs.slice(0, 2).map(song => song[1]));
    });

    return result;
}