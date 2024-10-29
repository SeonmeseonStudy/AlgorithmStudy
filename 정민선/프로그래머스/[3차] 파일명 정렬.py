def solution(files):
    answer = []
    
    def section(file):
        start = -1
        
        for i in range(len(file)):
            if file[i].isdigit():
                start = i
                break
                
        head = file[:start]
        number = file[start:start+5]
        
        end = start+5
        for i in range(start, len(file)):
            if not file[i].isdigit():
                end = i
                break

        number = file[start:end]
        tail = file[end:]
        
        return head, number, tail
    
    
    fileList = []
    for file in files:
        head, number, tail = section(file)
        fileList.append((head, number, tail))
    
    fileList.sort(key=lambda x : (x[0].lower(), int(x[1])))
    
    for head, number, tail in fileList:
        answer.append(f"{head}{number}{tail}")
    
    return answer