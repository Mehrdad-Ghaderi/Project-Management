let chartData = decodeHtml(chartData1); //the second chartData comes from home.html and cuz it's encrypted we need to decrypt it then we can use it
let chartJsonArray = JSON.parse(chartData);
let arrayLength = chartJsonArray.length;
let numericData = [];
let labelData = [];

for (let i = 0; i < arrayLength; i++) {
    numericData[i] = chartJsonArray[i].value;
    labelData[i] = chartJsonArray[i].label;

}


new Chart(document.getElementById("thePieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'The Projects chart',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData,
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
                text: 'Projects Status'
            }
        }
    },
});

//[{"value":1, label:"completed"},{"value":2, label:"INPROGRESS"},{"value":4, label:"FINISHED"}]
function decodeHtml(html) {
    let txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}