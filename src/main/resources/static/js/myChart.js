new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'The Projects chart',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: [12, 19, 3],
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Projects Chart'
            }
        }
    },
});