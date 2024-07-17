function solution(s){
    let lower = s.toLowerCase();
    let count = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (lower.charAt(i) === "p") count++;
        if (lower.charAt(i) === "y") count--;
    }

    return count ? false : true;
}