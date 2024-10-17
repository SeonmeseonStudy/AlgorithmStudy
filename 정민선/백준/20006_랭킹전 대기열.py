person, room_limit = map(int, input().split())

teams = []

def settingTeam(team, level, name):
    team['player_number'] += 1
    team['players'].append((level, name))
    
    if team['player_number'] == 1:
        team['maxlevel'] = level + 10
        team['minlevel'] = level - 10
    
    if team['player_number'] == room_limit:
        team['state'] = team['state'] = "Started!"

def printGame(team):
    print(team['state'])
    
    team['players'].sort(key=lambda x : (x[1]))
    
    for level ,player in team['players']:
        print(level, player)

for i in range(person):
    level, nickname = map(str, input().split())
    level = int(level)
    
    matched = False
    for team in teams:
        if team['state'] == 'Waiting!' and team['minlevel'] <= level <= team['maxlevel']:
            settingTeam(team, level, nickname)
            matched = True
            break
            
    if not matched:
        new_team = {
            'state': 'Waiting!',
            'player_number': 0,
            'players': [],
            'maxlevel': 0,
            'minlevel': 0
        }
        settingTeam(new_team, level, nickname)
        teams.append(new_team)

for team in teams:
    if team['state'] != 'init':
        printGame(team)