T = int(input())  

for _ in range(T):
    n, k, t, m = map(int, input().split())


    teams = {}
    for i in range(1, n + 1):
        teams[i] = {
            'scores': [0] * (k + 1),   
            'submit_count': 0,       
            'last_time': 0            
        }

    for time in range(1, m + 1):
        team_id, problem_id, score = map(int, input().split())
        team = teams[team_id]

        team['scores'][problem_id] = max(team['scores'][problem_id], score)
        team['submit_count'] += 1
        team['last_time'] = time

    rank_data = []
    for team_id in range(1, n + 1):
        total_score = sum(teams[team_id]['scores'])
        submit_count = teams[team_id]['submit_count']
        last_time = teams[team_id]['last_time']
        rank_data.append((
            -total_score,       
            submit_count,       
            last_time,           
            team_id              
        ))

    rank_data.sort()

    for rank, data in enumerate(rank_data, 1):
        if data[3] == t:
            print(rank)
            break
