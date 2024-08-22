const main = () => {
    const input = require('fs').readFileSync('dev/stdin')
    .toString().trim().split("\n");
    const n = Number(input[0]);
    let q = input[1].split(" ").map(Number);
    let st = [];
    let count = 1;

    while (q.length > 0 || st.length > 0) {
        let cur1 = q.shift();
        let cur2 = st.pop();

        if (cur1 === count) {
            count++;
            if (cur2) st.push(cur2);
        } else if (cur2 === count) {
            count++;
            if (cur1) q.unshift(cur1);
        } else {
            if (!cur1) break;
            else {
                if (cur2) st.push(cur2);
                st.push(cur1);
            }
        }
    }

    if (q.length > 0 || st.length > 0) {
        console.log("Sad");
    } else console.log("Nice");
}

main();