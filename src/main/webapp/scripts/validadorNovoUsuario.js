/**
 * 
 */

 function validar(){
	let nome = frmnovousuario.nome.value
	let fone = frmnovousuario.fone.value
	let mail = frmnovousuario.email.value
	if (nome === ""){
		alert('Preencha o campo nome')
		frmnovousuario.nome.focus()
		return false;
	} else if (fone === ""){
		alert('Preencha o campo fone')
		frmnovousuario.fone.focus()
		return false;
	} else {
		document.forms["frmnovousuario"].submit()
	}
 }
 
 function validarSenha(){
	 let senha = frmcontato.nome.value;
	 println("teste: "+senha);
 }
 
