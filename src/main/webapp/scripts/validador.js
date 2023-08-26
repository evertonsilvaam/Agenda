/**
 * 
 */

function validar(){
	let nome = frmcontato.nome.value
	let fone = frmcontato.fone.value
	let mail = frmcontato.email.value
	if (nome === ""){
		alert('Preencha o campo nome')
		frmcontato.nome.focus()
		return false;
	} else if (fone === ""){
		alert('Preencha o campo fone')
		frmcontato.fone.focus()
		return false;
	} else {
		document.forms["frmcontato"].submit()
	}
	
//	alert('nome: '+ nome+ ' fone: '+ fone+ ' mail: '+ mail)
}