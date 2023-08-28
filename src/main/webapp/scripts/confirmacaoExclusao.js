/**
 * 
 */

 function confirmar(idcontato){
	 let resposta = confirm("Quer mesmo excluir este contato?")
	 
	 if (resposta === true){
//		 alert("Contato com id = "+idcontato+ " excluído")
		 window.location.href = "excluircontato?idcontato="+idcontato
	 }
 }