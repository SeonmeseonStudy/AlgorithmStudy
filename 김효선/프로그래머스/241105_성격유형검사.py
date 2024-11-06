#객체 지향 접근 방식으로 진행

class PersonalityTest:
    def __init__(self):
        self.scores = {
            'R': 0, 'T': 0,
            'C': 0, 'F': 0,
            'J': 0, 'M': 0,
            'A': 0, 'N': 0
        }
        self.score_mapping = {
            1: (3, 0), 
            2: (2, 0),
            3: (1, 0),
            4: (0, 0),
            5: (0, 1),
            6: (0, 2),
            7: (0, 3)
        }

    def calculate_scores(self, survey, choices):
        for i in range(len(survey)):
            s = survey[i]
            choice = choices[i]
            if choice < 4:
                self.scores[s[0]] += self.score_mapping[choice][0]
            elif choice > 4:
                self.scores[s[1]] += self.score_mapping[choice][1]

    def determine_personality(self):
        result = ''
        for j in range(0, 8, 2):
            first_type = 'R' if j == 0 else ('C' if j == 2 else ('J' if j == 4 else 'A'))
            second_type = 'T' if j == 0 else ('F' if j == 2 else ('M' if j == 4 else 'N'))

            if self.scores[first_type] > self.scores[second_type]:
                result += first_type
            elif self.scores[first_type] < self.scores[second_type]:
                result += second_type
            else:
                result += min(first_type, second_type)

        return result

def solution(survey, choices):
    test = PersonalityTest()
    test.calculate_scores(survey, choices)
    return test.determine_personality()
