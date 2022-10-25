// File EmailChecker.js
// Given an string, check if its a valid email.
// If valid, print YES
// If not, print NO
// use the Unix Philosophy Approach


// -----------------------------------------------------------

// Valid

// mysite@masaischool.com
// my.name@masaischool.org
// mysite@masai.school.net

// Not Valid
// masai.school.com [@ is not present]
// masai@.com [ domain can not start with dot `.` ]
// @masai.school.net [ No character before @ ]
// name@gmail.b [ `.b` is not a valid tld ]
// name@.org.org [ domain can not start with dot `.` ]
// .name@masaischool.org [ an email should not be start with `.` ]
// masaischool()*@gmail.com [ only allows character, digit, underscore, and dash ]
// name..1234@yahoo.com [double dots are not allowed]



// ------------------------------------------------------------------

main();

const main = () => {
    if (noAttherat()) {
        console.log("NO");  // masai.school.com [@ is not present]
    }
    if (domainStartedwithDot()) {
        console.log("NO");  // masai@.com [ domain can not start with dot `.` ]
    }
    if()

    else {
        console.log("YES");
    }
}