const api = `https://abrakadabra1234.herokuapp.com/data`;

let countriesNotDuplicatObj = {};
var globalData = [];

let form = document.getElementById("input_form");
form.addEventListener("submit", postDataFun);


// -------------------------- Data Display map Function --------------------------
function DisplayData(data) {
    let tbody = document.getElementById("tbody");
    tbody.innerHTML = " ";
    data.map((el) => {
        tbody.innerHTML += `
                <tr>
                    <td>${el.id}</td>
                    <td>${el.country}</td>
                    <td>${el.city}</td>
                    <td>${el.population}</td>
                    <td><button style="background-color: yellow">Edit</button></td>
                    <td><button style="background-color: red" onClick="deleteItem(${el.id})">Delete</button></td>
                </tr>
        `;
    })

}

// --------------------------Post Data Function into JSON Server --------------------------
function postDataFun(e) {
    e.preventDefault();
    let country = form.elements[0].value;
    let city = form.elements[1].value;
    let population = form.elements[2].value;

    let obj = {
        country,
        city,
        population
    }

    // console.log(obj);
    fetch(api, {
        "method": "POST",
        "body": JSON.stringify(obj),
        "headers": { "content-type": "application/json" }
    })
        .then((res) => fetchDataFun(res))
        .catch((err) => console.log(err))
}

// -------------------------- Data Fetch Function --------------------------
function fetchDataFun() {

    countriesNotDuplicatObj = {};

    fetch(api)
        .then(res => res.json())
        .then(data => {
            globalData = [...data];
            data.map((el) => {
                countriesNotDuplicatObj[el.country] = 1; // will not have any duplicate Country Entry
            })

            let filterbyCountery = document.getElementById("filterbyCountery");
            filterbyCountery.innerHTML = `<option value="all">All Countries</option>`;




            for (key in countriesNotDuplicatObj) {
                filterbyCountery.innerHTML += `<option value=${key}>${key}</option>`;
                // 36:18 min 
            }

            filterbyCountery.addEventListener("change", () => {
                let filteredCountry = filterbyCountery.value;
                // console.log(filteredCountry);
                if (filteredCountry === "all") {
                    fetchDataFun();
                    return;
                }
                fetch(`${api}?country=${filteredCountry}`)
                    .then(res => res.json())
                    .then(data => {
                        globalData = [...data]
                        DisplayData(data)
                    })
                    .catch(err => console.log(err))

            })

            DisplayData(data)
        })
        .catch(err => console.log(err))
}
fetchDataFun();

// -------------------------- Assendening Decending Function --------------------------

function AssenDecenFun() {
    let AssDec = document.getElementById("sortbyPopulation");
    AssDec.addEventListener("change", () => {
        // console.log(globalData);
        // console.log(AssDec.value);
        if (AssDec.value === "assending") {
            globalData.sort((a, b) => a.population - b.population)
            DisplayData(globalData);
        }
        else if (AssDec.value === "decending") {
            globalData.sort((a, b) => b.population - a.population)
            DisplayData(globalData);
        }
    })
}
AssenDecenFun();

// -----------------------Delete Function ----------------

function deleteItem(id) {
    // console.log(id);
    fetch(`${api}/${id}`, { "method": "DELETE" })
        .then(res => fetchDataFun())
}

// -----------------------Edit Function ----------------

// 1:00 

function Java() {
    fetch(`${api}/${java}`)
        .then(res=>console.log(java))
        
}