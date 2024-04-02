<%@page import="it.thera.thip.base.generale.ParametroPsn"%>
<%@page import="com.thera.thermfw.base.ResourceLoader"%>
<%
String documentiBut = ResourceLoader.getString("it.softre.thip.produzione.raccoltaDati.resources.RilevDatiPrdTS",
		"DocumentiBut");
String showDocumenti = ParametroPsn.getValoreParametroPsn("pers.produzione.raccoltaDati", "VisualizzaDocumenti");
if (showDocumenti != null && showDocumenti.equals("Y")) {
%>
<td align="left">
	<button id="DocumentiBut" class="btnFooter" type="button"
		onclick="documentiAction()"><%=documentiBut%></button>
</td>
<%
}
%>
<script>
	function documentiAction() {
		var rilframe = document.getElementById('rilframe');
		rilframe.contentWindow.documentiAction();
	}
</script>