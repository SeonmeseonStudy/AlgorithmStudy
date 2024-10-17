T = int(input())

for i in range(T):
    n, k, yid, m = map(int, input().split()) 
    teams = {i: {'score': [0] * (k + 1), 'count': 0, 'time': 0} for i in range(1, n + 1)}
    
    for i in range(1, m+1):
        tid, qid, score = map(int, input().split())
        team = teams[tid]
        
        if team['score'][qid] < score:
            team['score'][qid] = score
        
        team['count'] += 1
        team['time'] = i
    
    result = []
    for tid, team in teams.items():
        score = sum(team['score'])
        count = team['count']
        time = team['time']
        result.append((score, count, time, tid))
        
    result.sort(key=lambda x: (-x[0], x[1], x[2]))

    for index, r in enumerate(result, start=1):
        if r[3] == yid:
            print(index)