from collections import Counter

def solutionA(participant=["leo", "kiki", "eden"], completion=["eden", "kiki"]):
    participant_count = Counter(participant)
    completion_count = Counter(completion)
    
    print(participant_count)
    result = participant_count - completion_count
    
    return list(result.keys())[0]

def solutionB(participant, completion):
    participant.sort()
    completion.sort()
    
    for p, c in zip(participant, completion):
        if p != c:
            return p
    
    return participant[-1]

participant=["leo", "kiki", "eden"]
completion=["eden", "kiki"]
print(solutionB(participant, completion))