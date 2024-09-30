def solution(mats, park):
    answer = -1
    n = len(park)
    m = len(park[0])
    mats.sort(reverse=True)
    
    def inrange(x, y):
        return 0 <= x < n and 0 <= y < m
    
    def check(x, y, mat):
        if not inrange(x+mat-1, y+mat-1):
            return False
        
        for a in range(x, x+mat):
            for b in range(y, y+mat):
                if park[a][b] != "-1":
                    return False
        return True
    
    for mat in mats:
        for i in range(n-mat+1):
            for j in range(m-mat+1):
                if park[i][j] == "-1":
                    if check(i, j, mat):
                        answer = mat    
                        return answer
                    
    return answer

mats = [5,3,2]
park = [["A", "A", "-1", "B", "B", "B", "B", "-1"], ["A", "A", "-1", "B", "B", "B", "B", "-1"], ["-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"], ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"], ["D", "D", "-1", "-1", "-1", "-1", "-1", "F"], ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"]]

answer = solution(mats, park)
print(answer)