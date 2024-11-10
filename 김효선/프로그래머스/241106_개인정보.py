class Privacy:
    def __init__(self, collection_date, term_type, term_dict):
        self.collection_date = list(map(int, collection_date.split('.'))) 
        self.term_type = term_type
        self.term_months = term_dict[term_type]
    
    def expired(self, today):
        today_year, today_month, today_day = map(int, today.split('.'))
        
        expiration_month = self.collection_date[1] + self.term_months
        expiration_year = self.collection_date[0] + (expiration_month - 1) // 12 

        expiration_month = (expiration_month - 1) % 12 + 1

        expiration_day = self.collection_date[2]

        if (expiration_year < today_year) or (expiration_year == today_year and expiration_month < today_month) or (expiration_year == today_year and expiration_month == today_month and expiration_day < today_day):
            return True
        return False

def solution(today, terms, privacies):
    term_dict = {t.split()[0]: int(t.split()[1]) for t in terms}
    
    expired_privacies = []
    
    for i, privacy in enumerate(privacies):
        date_str, term_type = privacy.split()
        privacy_instance = Privacy(date_str, term_type, term_dict)
        
        if privacy_instance.expired(today):
            expired_privacies.append(i + 1)  
            
    return expired_privacies