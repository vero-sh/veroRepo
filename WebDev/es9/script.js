
document.addEventListener('DOMContentLoaded', () => {
    let input = document.getElementById('txt');
    let btn = document.getElementById('btn');
    let names = [];

    btn.addEventListener('click', () => {
        names.push(input.value);
        input.value = '';

        let max = names[0];
        for (let elem of names) {
            if (elem.length > max.length) max = elem;
        }

        console.log('Array:', names);
        console.log('Longest name:', max);

    });
});