def solution(today, terms, privacies):
    today_year, today_month, today_day = map(int, today.split('.'))
    
    term_dict = {}
    for term in terms:
        t, months = term.split()
        term_dict[t] = int(months)
    
    expired_privacies = []
    
    for i, privacy in enumerate(privacies):
        date_str, term_type = privacy.split()
        year, month, day = map(int, date_str.split('.'))
        
        expiration_month = month + term_dict[term_type]
        expiration_year = year + (expiration_month - 1) // 12 
        expiration_month = (expiration_month - 1) % 12 + 1  
        
        expiration_day = day
        
        if (expiration_year < today_year) or \
           (expiration_year == today_year and expiration_month < today_month) or \
           (expiration_year == today_year and expiration_month == today_month and expiration_day < today_day):
            expired_privacies.append(i + 1)  
            
    return expired_privacies