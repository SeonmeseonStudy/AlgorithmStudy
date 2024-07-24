def solution(n, times):
    x = min(times)
    y = max(times)
    left = x
    right = y * n

    while left <= right:
        mid = (left + right) // 2
        total_people = sum(mid // time for time in times)

        if total_people >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer
