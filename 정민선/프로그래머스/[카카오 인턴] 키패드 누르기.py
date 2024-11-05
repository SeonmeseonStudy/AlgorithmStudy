def solution(numbers, hand):
    answer = ''
    left = [1, 4, 7]
    right = [3,6,9]
    keypad = {
        1:(0,0),
        2:(0,1),
        3:(0,2),
        4:(1,0),
        5:(1,1),
        6:(1,2),
        7:(2,0),
        8:(2,1),
        9:(2,2),
        '*':(3,0),
        0:(3,1),
        '#':(3,2)
    }
    L, R = '*', '#';
    
    for num in numbers:
        if num in left:
            answer += 'L'
            L = num
        elif num in right:
            answer += 'R'
            R = num
        else:
            Lcount = abs(keypad[L][0]-keypad[num][0]) + abs(keypad[L][1]-keypad[num][1])
            Rcount = abs(keypad[R][0]-keypad[num][0]) + abs(keypad[R][1]-keypad[num][1])
            if Lcount == Rcount:
                hand_choice = 'L' if hand == 'left' else 'R'
            else:
                hand_choice = 'R' if Lcount > Rcount else 'L'

            if hand_choice == 'L':
                L = num
            else:
                R = num

            answer += hand_choice
    return answer