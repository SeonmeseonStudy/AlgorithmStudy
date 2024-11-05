#프로그래머스 - 성격유형검사
def solution(survey, choices):
    answer = ''
    result_table = {
        'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0
    }

    score_table = {
        1: 3, 2: 2, 3: 1, 4: 0, 5: 1, 6: 2, 7: 3
    }

    for i in range(len(survey)):
        type1, type2 = survey[i][0], survey[i][1]
        choice = choices[i]
        
        if choice < 4:
            result_table[type1] += score_table[choice]
        elif choice > 4: 
            result_table[type2] += score_table[choice]

    
    if result_table['R'] >= result_table['T']:
        answer += 'R'
    else:
        answer += 'T'
        
    if result_table['C'] >= result_table['F']:
        answer += 'C'
    else:
        answer += 'F'
        
    if result_table['J'] >= result_table['M']:
        answer += 'J'
    else:
        answer += 'M'
        
    if result_table['A'] >= result_table['N']:
        answer += 'A'
    else:
        answer += 'N'

    return answer
