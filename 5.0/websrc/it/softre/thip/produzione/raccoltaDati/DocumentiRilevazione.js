function RilevDatiPrdTSOL() {
	parent.document.getElementById('Indietro').style.display = displayBlock;
	parent.document.getElementById('Conferma').style.display = displayNone;
	parent.document.getElementById('StampaBolla').style.display = displayNone;
	parent.document.getElementById('ConfermaStampa').style.display = displayNone;
	parent.document.getElementById('ProssimaAtvBut').style.display = displayNone;
	parent.document.getElementById('MonitorBut').style.display = displayNone;
	eval("document.forms[0]." + idFromName['DescrizioneOperatore']).style.background = bCo;
}

function showDocDgt(key) {
	if (Array.isArray(key)) {
		let xOffset = 0;
		let yOffset = 0;
		key.forEach(function(singleKey) {
			let url = "/" + webAppPath + "/ws?id=YSDD&token=" + "" + "&key=" + singleKey;
			window.open(url, "_blank", "width=600,height=400,left=" + (window.screenX + xOffset) + ",top=" + (window.screenY + yOffset));
			xOffset += 150;
			yOffset += 150;
		});
	} else {
		let url = "/" + webAppPath + "/ws?id=YSDD&token=" + "" + "&key=" + key;
		window.open(url, "_blank", "width=600,height=400");
	}
}

function showDocDgtNavigation(url) {
	let url = "/" + webAppPath + url;
	window.open(url, "_blank", "width=600,height=400");
}