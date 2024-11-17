def solution(n, info):
    scores = list(range(10, -1, -1))

    best_diff = -1  
    best_case = [-1] * 11 

    def calc_score(ryan_shots):
        ryan_score, apeach_score = 0, 0
        for i in range(11):
            if info[i] >= ryan_shots[i]:
                apeach_score += (10 - i) * (info[i] > 0)
            else:
                ryan_score += (10 - i) * (ryan_shots[i] > 0)

        return ryan_score, apeach_score

    #백트레킹ㄴ...
    def backtrack(i, ryan_shots, remaining_arrows):
        nonlocal best_diff, best_case
        
        if i == 11:
            ryan_score, apeach_score = calc_score(ryan_shots)
            if ryan_score > apeach_score:
                diff = ryan_score - apeach_score
                if diff > best_diff or (diff == best_diff and ryan_shots < best_case):
                    best_diff = diff
                    best_case = ryan_shots[:]
            return
        
        max_arrows_for_this_score = min(remaining_arrows, n)
        for arrows in range(max_arrows_for_this_score + 1):
            ryan_shots[i] = arrows
            backtrack(i + 1, ryan_shots, remaining_arrows - arrows)

    backtrack(0, [0] * 11, n)

    if best_diff <= 0:
        return [-1]
    
    return best_case