def max_hamburgers(N, K, table):
    table = list(table)                    
    visited = [False] * N                 
    count = 0                              

    for i in range(N):                     
        if table[i] == 'P':              
           
            for j in range(max(0, i - K), min(N, i + K + 1)):
                if table[j] == 'H' and not visited[j]: 
                    visited[j] = True                 
                    count += 1                        
                    break                              

    return count                                       
