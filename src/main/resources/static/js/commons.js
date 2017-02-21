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
    message = sendAjax(jsonObj, url, "POST", "", "");
	if (message.tag == "warn") {
		window.swal({
			title : message.message,
			type : "warning",
			confirmButtonClass : 'btn-primary',
			closeOnConfirm : false
		});
	}
	if(message.tag=="danger"){
   	 window.swal({
              title: message.message,
              type: "error",
              showCancelButton: false,
              confirmButtonClass: 'btn-danger',
              confirmButtonText: 'Danger!'
          });
   	
   }
}
