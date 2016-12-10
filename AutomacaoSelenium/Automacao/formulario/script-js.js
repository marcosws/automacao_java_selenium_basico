/* **** script-js.js ****
 * 09/12/2016      
 * Marcos W. Souza      */

function validaForm()
{
	var msg = "Pendências: ";
	var valida = true;
	
	var nome = document.getElementById('nome').value;
	var cpf = document.getElementById('cpf').value;
	var telefone = document.getElementById('telefone').value;
	var celular = document.getElementById('celular').value;
	var email = document.getElementById('email').value;
	
	var nomeStatus = "Nome deve ser preenchido.";
	var cpfStatus = "CPF inválido."; // se campo estiver em branco: CPF deve ser preenchido.
	var telefoneStatus = "Telefone deve ser preenchido.";
	var celularStatus = "Celular deve ser preenchido.";
	var emailStatus = "Formato de e-mail inválido."; // se campo estiver em branco:  E-mail deve ser preenchido.
	
	document.getElementById('statusNome').innerHTML = "";
	document.getElementById('statusCpf').innerHTML = "";
	document.getElementById('statusTelefone').innerHTML = "";
	document.getElementById('statusCelular').innerHTML = "";
	document.getElementById('statusEmail').innerHTML = "";
	
	if(nome === "")
	{
		valida = false;
		if(document.getElementById('mensagem').checked)
			msg += "\n- " + nomeStatus;
		else
			document.getElementById('statusNome').innerHTML = nomeStatus;
	}
	
	
	if(!validaCpf(cpf))
	{
		if(cpf === "")
			cpfStatus = "CPF deve ser preenchido."; // troca a mensagem se CPF estiver em branco
		
		valida = false;
		if(document.getElementById('mensagem').checked)
			msg +="\n- " + cpfStatus;
		else
			document.getElementById('statusCpf').innerHTML = cpfStatus;
	}
	
	if(telefone === "")
	{
		valida = false;
		if(document.getElementById('mensagem').checked)
			msg += "\n- " + telefoneStatus;
		else
			document.getElementById('statusTelefone').innerHTML = telefoneStatus;
	}
	
	if(celular === "")
	{
		valida = false;
		if(document.getElementById('mensagem').checked)
			msg += "\n- " + celularStatus;
		else
			document.getElementById('statusCelular').innerHTML = celularStatus;
	}
	
	if(!validaEmail(email))
	{
		if(email === "")
			emailStatus = "E-mail deve ser preenchido."; // troca a mensagem se E-mail estiver em branco
		
		valida = false;
		if(document.getElementById('mensagem').checked)
			msg += "\n- " + emailStatus;
		else
			document.getElementById('statusEmail').innerHTML = emailStatus;
	}
	
	if(!valida)
	{
		if(document.getElementById('mensagem').checked)
			alert(msg);
		return false; //javascript:void(0);
	}
	else
	{
		return true; //document.getElementById("form1").submit();
	}
}

function validaEmail(email)
{
	var res = email.match(/^([\w\-]+\.)*[\w\- ]+@([\w\- ]+\.)+([\w\-]{2,3})$/g);
	if(res === null)
		return false;
	else
		return true;
}
function validaCpf(cpf)
{
	cpf = cpf.toString();
	cpf = cpf.replace(/[^0-9]/g, '');
	
	if(cpf.length != 11)
		return false;
	
	var rep = 0;
	for(var r = 0; r < 10; r++){
		if(cpf.substr(r,1) === cpf.substr(10,1))
			rep += 1;
		if(rep === 10)
			return false;
	}
	
	var soma = 0;
	var valida = false;
	var peso_mult1 = [10,9,8,7,6,5,4,3,2];
	var peso_mult2 = [11,10,9,8,7,6,5,4,3,2];
	
	for(var i = 0; i < 9; i++)
		soma += peso_mult1[i] * parseInt(cpf.substr(i,1));
	
	var resto = soma % 11;
	if(resto < 2)
		resto = 0;
	else
		resto = 11 - resto;
	
	var digito = resto.toString();
	var parc_cpf = cpf.substr(0,9) + digito;
	soma = 0;
	
	for(var j = 0; j < 10; j++)
		soma += peso_mult2[j] * parseInt(parc_cpf.substr(j,1));
	
	resto = soma % 11;
	if(resto < 2)
		resto = 0;
	else
		resto = 11 - resto;
	
	digito += resto.toString();
	if(cpf.substr(9,2) === digito)
		valida = true;

	return valida;
}