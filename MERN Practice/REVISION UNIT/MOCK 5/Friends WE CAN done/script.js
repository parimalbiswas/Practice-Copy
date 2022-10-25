
let tbody = document.getElementById("tbody")

let url= "https://abrakadabra1234.herokuapp.com/data"
function getData(){

    // let arr=[]
    // fetch function
    fetch("https://abrakadabra1234.herokuapp.com/data")
        .then(res => res.json())
        .then(data => {
                display(data)
        })
}

// create td
function display(arr){
  tbody.innerHTML=''

    // console.log(arr)

    arr.forEach((el) => {
        let tr=document.createElement('tr')
        tr.setAttribute('id', 'tr')

        let td1= document.createElement('td')
        td1.setAttribute('id', 'td')
        td1.innerText=el.id

        let td2= document.createElement('td')
        td2.setAttribute('id', 'td')
        td2.innerText=el.country

        let td3= document.createElement('td')
        td3.setAttribute('id', 'td')
        td3.innerText=el.city

        let td4= document.createElement('td')
        td4.setAttribute('id', 'td')
        td4.innerText=el.population

let td5=document.createElement('td')
td5.setAttribute('id', 'edit')
td5.innerText= "EDIT"
td5.addEventListener('click', function (){


    console.log(el.id);
})



let td6=document.createElement('td')
td6.setAttribute('id', 'delete')
td6.innerText= "DELETE"
td6.addEventListener('click', function(){

    const deleteMethod = {
        method: 'DELETE', 
        headers: {
         'Content-type': 'application/json; charset=UTF-8'
        },
       
       }

       fetch(`https://abrakadabra1234.herokuapp.com/data/${el.id}`, deleteMethod) 
       .then(response => response.json())
       .then(data => console.log(data)) 
       .catch(err => console.log(err)) 
})


        tr.append(td1, td2, td3, td4, td5, td6)
tbody.append(tr)
    });
    
}



let citys=document.getElementById('city')
let populations=document.getElementById('population')

let arr={}
function update() {
    let select= document.getElementById('country')
    var option = select.options[select.selectedIndex];
  let country= option.value
    let city= citys.value
  let population=  populations.value

  if(country!=="" && city!=='' && population!==''){

      arr={...arr,country, city, population}
  }
    
}


function postData(){
    fetch('https://abrakadabra1234.herokuapp.com/data', {
        method: 'POST', // or 'PUT'
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(arr),
      })
      .then((response) => response.json())
      .then((data) => {
        console.log('Success:', data);
      })
      .catch((error) => {
        console.error('Error:', error);
      });
}

document.getElementById('submit').addEventListener('click', function(e){
e.preventDefault()
console.log(arr);
postData()
})


async function lth(){
    try{
        const res= await fetch(`https://abrakadabra1234.herokuapp.com/data`);
        let data = await res.json();
        let all= data;
         all.sort((a,b)=> a.population - b.population)
         display(all)
        // console.log(all);
        
    }catch(er){
        console.log(er)
    }
}
async function htl(){
    try{
        const res= await fetch(`https://abrakadabra1234.herokuapp.com/data`);
        let data = await res.json();
        let all= data;
         all.sort((a,b)=> b.population - a.population)
         display(all)
        // console.log(all);
        
    }catch(er){
        console.log(er)
    }
}

function sortP(){
    //     
   let sortP= document.getElementById('sortPopulation')
    var option = sortP.options[sortP.selectedIndex];
    let sortValue= option.value
{sortValue==='accending' ? lth() : htl() }

}











getData()