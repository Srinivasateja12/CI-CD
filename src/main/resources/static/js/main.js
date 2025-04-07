function calculate() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let operator = document.getElementById("operator").value;

    if (num1 === "" || num2 === "") {
        alert("Please enter both numbers");
        return;
    }

    fetch(`/calculate?num1=${num1}&num2=${num2}&operator=${operator}`)
        .then(response => response.text())
        .then(data => {
            document.getElementById("result").innerText = data;
        })
        .catch(error => console.error("Error:", error));
}
