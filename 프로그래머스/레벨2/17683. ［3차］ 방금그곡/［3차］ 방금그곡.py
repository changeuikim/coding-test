def note_converter(melody):
    result = []
    for note in melody:
        if note != "#":
            result.append(note)
        else:
            result[-1] = result[-1].lower()
    return "".join(result)

def minute_converter(time_string):
    hour, minute = time_string.split(":")
    return 60 * int(hour) + int(minute)

def melody_repeater(melody, play_time):
    return (melody * (play_time // len(melody) + 1))[:play_time]

def solution(m, musicinfos):
    conv_m = note_converter(m)
    result_title = "(None)"
    result_time = 0
    
    for musicinfo in musicinfos:
        start, end, title, melody = musicinfo.split(",")
        play_time = minute_converter(end) - minute_converter(start)
        conv_melody = note_converter(melody)
        repeated_melody = melody_repeater(conv_melody, play_time)
        
        if conv_m in repeated_melody and play_time > result_time:
            result_title = title
            result_time = play_time
            
    return result_title