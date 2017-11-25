function validacion() {
	var isbn = document.getElementById("isbn");
	var miformulario = document.getElementById("miformulario");
	
	if (isbn.value == "") {
		alert("Datos no validos");
		return false;
	} else {
		miformulario.submit();
	}
}