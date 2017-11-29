function validacion() {
	var isbn = document.getElementById("isbn");
	var categoria = document.getElementById("categoria");
	var miformulario = document.getElementById("miformulario");
	
	if (isbn.value == "") {
		alert("Falta completar el ISBN!");
		return false;
	} else if (categoria.value == "") {
		alert("Falta completar la categoria!");
		return false;
	} else {
		miformulario.submit();
	}
}