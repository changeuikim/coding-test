import java.util.*;

class Solution {
    private String noteConverter(String melody) {
        StringBuilder sb = new StringBuilder();
        for (char note : melody.toCharArray()) {
            if (note == '#') {
                int lastIdx = sb.length() - 1;
                char newNote = Character.toLowerCase(sb.charAt(lastIdx));
                sb.setCharAt(lastIdx, newNote);                
            } else {
                sb.append(note);
            }
        }
        return sb.toString();
    }

    private int minuteConverter(String timeString) {
        String[] parts = timeString.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return 60 * hour + minute;
    }

    private String melodyRepeater(String melody, int playTime) {
        return melody.repeat(playTime / melody.length() + 1).substring(0, playTime);
    }    

    public String solution(String m, String[] musicinfos) {
        String convM = noteConverter(m);
        String resultTitle = "(None)";
        int resultTime = 0;

        for (String musicinfo : musicinfos) {
            String[] parts = musicinfo.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = parts[3];

            int playTime = minuteConverter(end) - minuteConverter(start);
            String convMelody = noteConverter(melody);
            String repeatedMelody = melodyRepeater(convMelody, playTime);

            if (repeatedMelody.contains(convM) && playTime > resultTime) {
                resultTitle = title;
                resultTime = playTime;
            }
        }

        return resultTitle;
    }
}