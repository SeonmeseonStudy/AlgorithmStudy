def solution(s):
    countp=0
    county=0
    
    for i in range(len(s)):
        print(s[i])
        if s[i]=='p' or s[i]=='P':
            countp +=1
        elif s[i]=='y' or s[i]=='Y':
            county+=1
        
    if countp==county:
        return True
    else:
        return False

            