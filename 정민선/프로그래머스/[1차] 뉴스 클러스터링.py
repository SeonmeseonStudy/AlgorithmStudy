# ..?
# 교집합하는거 어떻게해야할지모르겠어서 힌트보면서 풀었당..

def solution(str1, str2):
    answer = 0
    one = []
    two = []
    for i in range(0, len(str1)-1):
        text = str1[i] + str1[i+1]
        if text.isalpha():
            one.append(text.upper())
            
    for i in range(0, len(str2)-1):
        text = str2[i] + str2[i+1]
        if text.isalpha():
            two.append(text.upper())
    
    two2 = two.copy()
    
    def intersection(A, B):
        C = []
        for a in A:
            if a in B:
                B.remove(a)
                C.append(a)
            
        return C

    array = intersection(one, two2)
    hap = len(one) + len(two) - len(array)
    
    if len(one) == 0 and len(two) == 0:
        answer = 65536
    else:
        answer = int(len(array)/hap*65536)
    
    
    return answer