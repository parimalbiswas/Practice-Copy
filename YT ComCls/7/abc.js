function runProgram(input){
    input = input.split("\n");
    var tc = input[0];
    var line=1;
    
    
    for(var i=0;i<tc;i++)
    {
        var given = input[line++];
        var arr = input[line++].split(" ").map(String);
        // console.log(given,arr);
        var output = Jio(arr,arr);
        
        if(output===0)
        {
            console.log("Front",arr[res]);
        }
        else if(output === arr.length )
        {
            console.log(arr[res-1],"Last");
        }
        else
        {
            console.log(arr[res-1],arr[res]);
        }
    }
    
}
function Jio(given,arr)
{
    var startInx=0;endInx=arr.length-1;
    var final = arr.length;
    while(startInx<=endInx)
    {
        let middleInx = Math.floor((startInx+endInx)/2);
        if(given<arr[middleInx])
        {
            final=middleInx;
            endInx=middleInx-1;
        }
        else
        {
            startInx=middleInx-1;
        }
    }
    return final;
}









 

if (process.env.USER === "") {
  runProgram(``);
} else {
  process.stdin.resume();
  process.stdin.setEncoding("ascii");
  let read = "";
  process.stdin.on("data", function (input) {
    read += input;
  });
  process.stdin.on("end", function () {
    read = read.replace(/\n$/, "");
    read = read.replace(/\n$/, "");
    runProgram(read);
  });
  process.on("SIGINT", function () {
    read = read.replace(/\n$/, "");
    runProgram(read);
    process.exit(0);
  });
}