def solution(survey, choices):
    answer = ''
    N = 4
    TEST = {
        'R':0, 'T':0,
        'C':0, 'F':0,
        'J':0, 'M':0,
        'A':0, 'N':0
    }
    for i in range(len(survey)):
        category = survey[i]
        result = choices[i]
        
        if result < 4:
            TEST[category[0]] += N-result
        elif result > 4:
            TEST[category[1]] += result-N
            
    answer += 'R' if TEST['R'] >= TEST['T'] else 'T'
    answer += 'C' if TEST['C'] >= TEST['F'] else 'F'
    answer += 'J' if TEST['J'] >= TEST['M'] else 'M'
    answer += 'A' if TEST['A'] >= TEST['N'] else 'N'
    return answer