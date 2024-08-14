const main = () => {
    const input = require('fs').readFileSync('dev/stdin').toString().trim().split("\n").slice(1);

    let list = [];
    input.forEach((val, idx) => {
        const [age, name] = val.split(' ');
        list.push({
            name: name,
            age: Number(age),
            index: idx
        })
    })

    list.sort((a, b) => {
        if (a.age === b.age) {
            return a.index - b.index
        } else return a.age - b.age
    })

    console.log(list.map(i => i.age + " " + i.name).join("\n"));
}

main();