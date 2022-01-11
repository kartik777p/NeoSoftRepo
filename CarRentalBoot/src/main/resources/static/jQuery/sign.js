$(function(){
  
    $('#email').blur(function(){
        valEmailNew();
    });
  
    $('#pw').blur(function(){
        valPassNew();
    });


    $('#showPw').change(function(){
        let chk = $("#showPw");
        console.log(chk);
        if(chk.prop('checked')){
            $('#pw').attr("type","text");
            $('#cpw').attr("type","text");
        }
        else{
            $('#pw').attr("type","password");
            $('#cpw').attr("type","password");
        }
    });
});
$('#regForm').submit(function(){
        console.log("In submit event")
        let email = valEmailNew();
        let pass = valPassNew();
    
        if (email && pass) {
            return true;
        }
        else{
            return false;
        }
    });
function valEmailNew(){
    $('#emailError').html("");
    let em = $('#email').val();
    if(em == ""){
        $('#emailError').html("this field is required");
        return false;
    }
    if(!em.includes('@' && '.')){
        $('#emailError').html("Enter correct email");
    }
    return true;
}


function valPassNew(){
    $('#pwError').html("");
    let pattern = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{4,})");

    let pass = $('#pw').val();
    if (pass == "") {
        $('#pwError').html("this field is required");
        return false;
    }
    else{
        if(pattern.test(pass)!=true){
            console.log(pattern.test(pass));
            $('#pwError').html("keep one special char, character and number");
            return false;
        }
    }
    return true;
}

