def dfs(beads, energy):
    if len(beads) == 2:
        return energy
    
    max_energy = 0
    for i in range(1, len(beads) - 1):
        gain = beads[i - 1] * beads[i + 1]
        next_beads = beads[:i] + beads[i + 1:]
        max_energy = max(max_energy, dfs(next_beads, energy + gain))
    
    return max_energy

n = int(input())
arr = list(map(int, input().split()))

print(dfs(arr, 0))
