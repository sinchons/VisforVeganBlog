/*##################### Sign Up Terms and Conditions ####################################*/

function checkForm(form)
{
    if(!form.terms.checked) {
    alert("Please indicate that you accept the Terms and Conditions");
    form.terms.focus();
    return false;
}
    return true;
}

/*##################### Log in Pop-Up ####################################*/

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

/*##################### Instagram embed width ####################################*/

// var myElement = document.getElementById("instagram-embed-0");
//     myElement.style.height = "461px";
// document.getElementById("instagram-embed-0").style.height = "461px";
