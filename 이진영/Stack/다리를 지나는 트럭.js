function solution(bridge_length, weight, truck_weights) {
    let passing = [];
    let t = 0;
    let cur_weight = 0;
    
    while (truck_weights.length > 0 || passing.length > 0) {
        if (passing.length > 0 && t - passing[0][1] >= bridge_length) {
            let wt = passing.shift();
            cur_weight -= wt[0];
        }
        
        if (truck_weights[0] + cur_weight <= weight && passing.length < bridge_length) {
            let w = truck_weights.shift()
            passing.push([w, t]);
            cur_weight += w
        }
        
        t++;
    }
    
    return t;
}