def solution(m, musicinfos):
    answer = ['(None)', 0]
    
    def calcTime(start, end):
        startHour, startMinute = map(int, start.split(":"))
        endHour, endMinute = map(int, end.split(":"))
        time = (endHour*60+endMinute)-(startHour*60+startMinute)
        return time
    
    def replaceNote(note):
        return note.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b")
    
    m = replaceNote(m)
    for info in musicinfos:
        start, end, name, music = info.split(",")
        music = replaceNote(music)
        time = calcTime(start, end)
        
        music = (music * (time // len(music) + 1))[:time]
        print(music)
        if m in music:
            if answer[1] >= time:
                continue
            answer = [name, time]

    return answer[0]