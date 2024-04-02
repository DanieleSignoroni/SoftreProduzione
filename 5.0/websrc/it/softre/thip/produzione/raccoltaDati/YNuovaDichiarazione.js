function documentiAction() {
	keepOperatoreValue(); 
	setInnerText(document.getElementById("ErroriList"), "");
	var className = eval("document.forms[0].thClassName.value");
	runActionDirect('DOCUMENTI_PERS', 'action_submit', className, null, 'same', 'no');
}