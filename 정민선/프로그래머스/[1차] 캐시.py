def solution(cacheSize, cities):
    answer = 0
    cities = [i.upper() for i in cities]
    if cacheSize == 0:
        return len(cities)*5
    
    cache = []
    for city in cities:
        if city in cache:
            answer += 1
            cache.remove(city)
            cache.append(city)
        else:
            answer += 5
            if cacheSize > len(cache):
                cache.append(city)
            else:
                cache.pop(0)
                cache.append(city)

    return answer