function sendAjax(jsData, url, type, successMessage, str) {
    var returnData = "";
    $.ajax({
        async: false,
        type: type,
        url: url,
        data: str === "" ? JSON.stringify(jsData) : jsData, //JSON.stringify(jsData),
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            //alert(row);
            returnData = data;
            if (successMessage !== "") {
//                reset();
//                window.swal({
//                    title: successMessage,
//                    type: "success",
//                    showCancelButton: false,
//                    confirmButtonClass: 'btn-danger',
//                    confirmButtonText: 'OK'
//                });
            }
        },
        error: function () {
            window.swal({
                title: "Error !",
                type: "error",
                showCancelButton: false,
                confirmButtonClass: 'btn-danger',
                confirmButtonText: 'OK'
            });
        }

    });
    return returnData;
}

function save(jsonObj, saveUrl){
	
	var url,data, message;
    url = saveUrl;
    console.log(jsonObj);
    message = sendAjax(jsonObj, url, "POST", "", "");
}

/*###############################################
 *############  For Auto complete 			  ###
 *###############################################*/

function getData(url){
	var result=sendAjax("{}", url, "GET", "", "");
	return result;
}


function autocomplet_key(fieldId,lengthKey){
	$( "#"+fieldId+"" ).keypress(function() {
		if($("#"+fieldId+"").val().length>=lengthKey){
			$('#inputIcon').prop('class', 'glyphicon glyphicon-search');
		}else{
			$('#inputIcon').prop('class', 'fa fa-refresh fa-spin');
		}
		});
	
	$( "#"+fieldId+"" ).keyup(function() {
		if($("#"+fieldId+"").val().length>=lengthKey){
			$('#inputIcon').prop('class', 'glyphicon glyphicon-search');
		}else{
			$('#inputIcon').prop('class', 'fa fa-refresh fa-spin');
		}
		});
	
	$( "#"+fieldId+"" ).click(function() {
			$('#inputIcon').prop('class', 'glyphicon glyphicon-search');
		});
	
	$( "#"+fieldId+"" ).focusout(function() {
		$('#inputIcon').prop('class', 'glyphicon glyphicon-search');
	});
}
/*###############################################
 *############  For Auto complete End		  ###
 *###############################################*/
function login() {
	var user=$('#txtUserId').val();
	var pwd=$('#txtPassword').val();
    var url = "/opensuite/login/auth?userId="+user+"&pwd="+pwd+"";
    var message = sendAjax("{}", url, "GET", "", "");
    if (message.message === "") {
        window.swal({
            title: "Invalid User Id or Password ! Please try again.",
            type: "warning",
            confirmButtonClass: 'btn-danger',
            closeOnConfirm: false
        });
        return;
    }
    window.location.href = message !== ""?message.message:"/";
}



