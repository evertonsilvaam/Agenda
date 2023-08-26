/**
 * 
 */

function validarLogin(){
	let usuario = frmlogin.usuario.value
	let senha = frmlogin.senha.value
	
	if (usuario === ""){
		alert('Preencha o campo ususario')
		frmlogin.usuario.focus()
		return false;
	} else if (senha === ""){
		alert('Preencha o campo senha')
		frmlogin.senha.focus()
		return false;
	} else {
		document.forms["frmlogin"].submit()
	}
}

function limparCampos(){
	frmlogin.usuario.value = ''
	frmlogin.senha.value = ''
	
}