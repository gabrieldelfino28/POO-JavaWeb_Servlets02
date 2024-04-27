/**
 * 
 */

//Manipulação simples de atributo hehe

var label = document.getElementById("labelGaragem");
var garagem = document.getElementById("areaGaragem");

 function disableGaragem(){
	 label.setAttribute("hidden", "hidden");
	 label.removeAttribute("required", "required");
	 
	 garagem.setAttribute("hidden", "hidden");
	 garagem.removeAttribute("required", "required");
 }
 
 function enableGaragem(){
	 label.setAttribute("required", "required");
	 label.removeAttribute("hidden", "hidden");
	 
	 garagem.setAttribute("required", "required");
	 garagem.removeAttribute("hidden", "hidden");
 }