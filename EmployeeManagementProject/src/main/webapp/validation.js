// name validation
function validate() {
  // var naam  = regform.name.value;                 // not working
  // var naam1 = document.regform.name.value;
  // var naam2= document.forms["regform"]["name"].value;
  try {
    var name = document.getElementById("name").value;
    var fname = document.getElementById("fname").value;
    var phoneno = document.getElementById("phoneno").value;
    var email = document.getElementById("email").value;
    var address = document.getElementById("address").value;
    var idno = document.getElementById("idno").value;
    var salary = document.getElementById("salary").value;

    var flag = true;

    // validating name and father name
    //checking length
    if (
      name.length < 3 ||
      name.length > 25 ||
      fname.length < 3 ||
      fname.length > 25
    ) {
      alert("Name length must be greater than 3 and less than 25 chars");
      flag = false;
      name.focus();
    }
    // checking alphabates
    var regEx = /^[a-zA-Z\s]+$/;
    if (regEx.test(name) && regEx.test(fname)) {
      /// ok
    } else {
      alert("Invalid Name \n Please enter letters and space only.");
      flag = false;
    }
    // check space
    if (name.charAt(0) == " " || fname.charAt(0) == " ") {
      alert("Invalid Name \n remove space");
      flag = false;
    }

    // Validating Phoneno
    // checking length
    if (!(phoneno.length == 10)) {
      alert("Invalid Phone no. \n Phone number must be 10 digit");
      flag = false;
    }

    // validating email

    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    if (
      atposition < 1 ||
      dotposition < atposition + 2 ||
      dotposition + 2 >= email.length
    ) {
      alert(
        "Please enter a valid e-mail address \n atpostion:" +
          atposition +
          "\n dotposition:" +
          dotposition
      );
      flag = false;
    }

    // checking space
    if (email.includes(" ")) {
      alert("Invalid email \n remove space");
      flag = false;
    }

    // validating idno (Aadhar card)
    // checking length
    if (idno.length != 12) {
      alert("Invalid IDNo \n Please enter correct Aadhar number");
      flag = false;
    }
    // checking only digit
    if (isNaN(idno)) {
      alert("Invalid IDNo. \nPlease enter only numeral value");
      flag = false;
    }

    // validating salary
    if (salary <= 0 || isNaN(salary)) {
      alert("Invalid Salary \n Please enter correct Salary");
      flag = false;
    }

    return flag;
  } catch (error) {
    alert(error.message);
  }
} //validate

