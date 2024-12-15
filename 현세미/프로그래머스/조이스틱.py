def solution(name):
    length = len(name)
    total_moves = 0

    for char in name:
        up_moves = ord(char) - ord('A')
        down_moves = 26 - up_moves
        total_moves += min(up_moves, down_moves)

    min_left_right = length - 1

    for i in range(length):
        next_index = i + 1
        while next_index < length and name[next_index] == 'A':
            next_index += 1

        go_right = 2 * i + length - next_index
        go_left = i + 2 * (length - next_index)

        min_left_right = min(min_left_right, go_right, go_left)

    return total_moves + min_left_right
