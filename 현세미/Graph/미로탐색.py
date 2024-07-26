from collections import deque

def bfs(maze, rows, cols):
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    queue = deque([(0, 0)])
    
    while queue:
        current_x, current_y = queue.popleft()
   
        for direction in directions:
            next_x = current_x + direction[0]
            next_y = current_y + direction[1]

            if 0 <= next_x < rows and 0 <= next_y < cols and maze[next_x][next_y] == 1:
        
                maze[next_x][next_y] = maze[current_x][current_y] + 1
                queue.append((next_x, next_y))
    

    return maze[rows - 1][cols - 1]

n, m = map(int, input().split())

maze = []
for _ in range(n):
    line = input().strip()
    maze.append([int(char) for char in line])


result = bfs(maze, n, m)
print(result)
