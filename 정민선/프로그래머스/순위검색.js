function solution(info, query) {
    var answer = [];
    volunteer = {}
    for (let form of info){
        let [language, job, grade, food, score] = form.split(' ')
        let key = `${language}-${job}-${grade}-${food}`;
        if (!volunteer[key]) {
            volunteer[key] = [];
        }
        volunteer[key].push(Number(score)); 
    }
    
    for (let key in volunteer) {
        volunteer[key].sort((a, b) => a - b);
    }
    
    function search(scores, limit) {
        let left = 0, right = scores.length-1;
        while (left <= right){
            let mid = Math.floor((left+right)/2);
            if (scores[mid] >= limit){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
    
    for (let q of query){
        let temp = q.replaceAll('and', '').split(' ').filter(e => e);
        let limit = Number(temp.pop());
        
        let count = 0;
        for (let key in volunteer){
            let conditions = key.split('-');
            let check = true;
            
            for (let i=0; i<temp.length; i++){
                if (temp[i] !== '-' && temp[i] !== conditions[i]){
                    check = false;
                    break;
                }
            }
            if (check){
                let scores = volunteer[key];
                let index = search(scores, limit);
                count += scores.length - index;
            }
        }
        answer.push(count);
    }
    return answer;
}