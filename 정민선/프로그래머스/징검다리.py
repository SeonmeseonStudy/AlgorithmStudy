def solution(distance, rocks, n):
    answer = 0
    
    rocks.sort()
    rocks.append(distance)
    
    def minDistance(min_dist):
        count = 0  
        last_position = 0 

        for rock in rocks:
            if rock - last_position < min_dist:
                count += 1
            else:
                last_position = rock
        return count <= n

    left, right = 0, distance
    while left <= right:
        mid = (left + right)//2
        if minDistance(mid):
            answer = mid  
            left = mid + 1
        else:
            right = mid - 1

    return answer