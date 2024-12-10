const noteConverter = (melody) => {
    return melody.replace(/[A-Z]#/g, (note) => note[0].toLowerCase());
}

const minuteConverter = (timeString) => {
    const [hour, minute] = timeString.split(":").map(Number);
    return 60 * hour + minute;
}

const melodyRepeater = (melody, playTime) => {
    return melody.repeat(Math.ceil(playTime / melody.length)).substr(0, playTime);
}

function solution(m, musicinfos) {
    const convM = noteConverter(m);
    let resultTitle = "(None)";
    let resultTime = 0;
    
    musicinfos.forEach((musicInfo) => {
       const [start, end, title, melody] = musicInfo.split(",");
        const playTime = minuteConverter(end) - minuteConverter(start);
        const convMelody = noteConverter(melody);
        const repeatedMelody = melodyRepeater(convMelody, playTime);
        
        if (repeatedMelody.includes(convM) && playTime > resultTime) {
            resultTitle = title;
            resultTime = playTime;
        }
    });
    
    return resultTitle;
}