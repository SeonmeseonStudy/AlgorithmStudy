n = int(input())
std = list(input())
count = dict()

def check(x, y):
    return x

for s in std:
    if s in count:
        count[s] += 1
    else:
        count[s] = 1
count = sorted(count.items())
answer = 0

for i in range(n-1):
    array = list(input())
    
    count2 = dict()
    
    for a in array:
        if a in count2:
            count2[a] += 1
        else:
            count2[a] = 1
    count2 = sorted(count2.items())
    
    if count == count2:
        answer += 1
    else:
        diff1 = len(array) - len(std)
        if abs(diff1) > 1:
            continue
        
        diff = 0
        # 각 문자의 개수를 세서 차이만큼 더하기
        for key in set(std + array):
            cnt1 = std.count(key)
            cnt2 = array.count(key)
            diff += abs(cnt1 - cnt2)

        if diff <= 2:
            answer += 1
            
print(answer)