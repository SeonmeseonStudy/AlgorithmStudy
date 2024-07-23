from itertools import permutations

def solution(k, dungeons):
    max_dungeons = 0
    all_arr = permutations(dungeons)
    
    for i in all_arr :
        current_k = k
        count = 0
        for dungeon in i:
            a, b = dungeon
            if current_k >= a:
                current_k -= b
                count += 1
            else:
                break
        max_dungeons = max(max_dungeons, count)
    
    return max_dungeons

