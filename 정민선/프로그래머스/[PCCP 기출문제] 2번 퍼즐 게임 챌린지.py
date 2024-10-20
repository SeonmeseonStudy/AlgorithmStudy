def solution(diffs, times, limit):
    games = len(diffs)
    
    def playGame(diff, time, level, time_prev):
        game_round = diff-level
        taken = 0
        
        if game_round > 0:
            taken += (time+time_prev) * game_round
        
        taken += time
        return taken
        
    left = 1
    right = max(diffs)
    answer = right
    
    while (left < right):
        mid = (left+right)//2
        total = 0
        
        for game in range(games):
            diff = diffs[game]
            time = times[game]
            time_prev = 0

            if game !=  0:
                time_prev = times[game-1]

            total += playGame(diff, time, mid, time_prev)

        if total <= limit:
            answer = min(mid, answer)
            right = mid
        else:
            left = mid + 1

    return answer