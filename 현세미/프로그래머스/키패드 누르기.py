def solution(numbers, hand):
    keypad = {
        1: (0, 0), 2: (0, 1), 3: (0, 2),
        4: (1, 0), 5: (1, 1), 6: (1, 2),
        7: (2, 0), 8: (2, 1), 9: (2, 2),
        '*': (3, 0), 0: (3, 1), '#': (3, 2)
    }
    
    left_hand, right_hand = keypad['*'], keypad['#']
    result = ""
    
    
    def dist(pos1, pos2):
        return abs(pos1[0] - pos2[0]) + abs(pos1[1] - pos2[1])


    for number in numbers:
        if number in [1, 4, 7]:
            result += 'L'
            left_hand = keypad[number]
        elif number in [3, 6, 9]:
            result += 'R'
            right_hand = keypad[number]
        else:
            left_dist = dist(left_hand, keypad[number])
            right_dist = dist(right_hand, keypad[number])
            
            if left_dist < right_dist:
                result += 'L'
                left_hand = keypad[number]
            elif right_dist < left_dist:
                result += 'R'
                right_hand = keypad[number]
            else:
                if hand == "right":
                    result += 'R'
                    right_hand = keypad[number]
                else:
                    result += 'L'
                    left_hand = keypad[number]

    return result
