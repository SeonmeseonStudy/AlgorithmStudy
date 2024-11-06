def parse_terms(terms):
    terms_category = {}
    for T in terms:
        term, period = T.split(" ")
        terms_category[term] = int(period)
    return terms_category    

def solution(today, terms, privacies):
    answer = []
    terms_category = parse_terms(terms)
    currentYear, currentMonth, currentDay = map(int, today.split("."))
    
    def calculate_date(period, year, month, day):
        month += period
        if month > 12:
            year += month // 12
            month = month % 12
            
        if month == 0:
            year -= 1
            month = 12
            
        if currentYear > year:
            return True
        elif currentYear == year:
            if currentMonth > month:
                return True
            elif currentMonth == month and currentDay >= day:
                return True      
        return False

    for index, privacy in enumerate(privacies):
        date, term_type = privacy.split(" ")
        year, month, day = map(int, date.split("."))
        
        if calculate_date(terms_category[term_type], year, month, day):
            answer.append(index+1)
        
    return answer