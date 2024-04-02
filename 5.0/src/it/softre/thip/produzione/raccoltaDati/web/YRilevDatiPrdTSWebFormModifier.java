package it.softre.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.jsp.JspWriter;

import com.thera.thermfw.base.ResourceLoader;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.collector.BaseBOValidationGroup;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.security.Entity;
import com.thera.thermfw.web.WebElement;

import it.softre.thip.produzione.raccoltaDati.YAssDocDgtRilev;
import it.softre.thip.produzione.raccoltaDati.YAssDocDgtRilevTM;
import it.softre.thip.produzione.raccoltaDati.YRilevDatiPrdTS;
import it.thera.thip.base.azienda.Azienda;
import it.thera.thip.base.documentoDgt.DocDgtEntita;
import it.thera.thip.base.documentoDgt.DocDgtEntitaTM;
import it.thera.thip.base.documentoDgt.DocumentoDgtOggetto;
import it.thera.thip.base.documentoDgt.DocumentoDigitale;
import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.produzione.ordese.PersDatiPrdCausaleRilev;
import it.thera.thip.produzione.ordese.PersDatiPrdUtenteRilev;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdTes;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSWebFormModifier;

public class YRilevDatiPrdTSWebFormModifier extends RilevDatiPrdTSWebFormModifier {

	public static String documentiPersTitle = WebElement.formatStringForHTML(ResourceLoader.getString("it.softre.thip.produzione.raccoltaDati.resources.RilevDatiPrdTS", "DocumentiTitle"));

	@Override
	public void writeBodyEndElements(JspWriter out) throws IOException {
		super.writeBodyEndElements(out);
		RilevDatiPrdTS bo = (RilevDatiPrdTS) getBODataCollector().getBo();
		bo.setIdAzienda(Azienda.getAziendaCorrente()); 
		String action = (String) getRequest().getAttribute("Action");
		if(action != null && action.equals(YRilevDatiPrdTSFormActionAdapter.DOCUMENTI_PERS)) {
			out.println("<script>");
			setTitle(out, documentiPersTitle);
			hideDescrizioneMacchina(out, bo);
			out.println("</script>");
		}
	}

	@Override
	public void writeFormEndElements(JspWriter out) throws IOException {
		super.writeFormEndElements(out);
		RilevDatiPrdTS bo = (RilevDatiPrdTS) getBODataCollector().getBo();
		String action = (String) getRequest().getAttribute("Action");
		if(action != null && action.equals(YRilevDatiPrdTSFormActionAdapter.DOCUMENTI_PERS)) {
			if(bo instanceof YRilevDatiPrdTS)
				displayVisualizzazioneDocumentiPers(out,bo);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayVisualizzazioneDocumentiPers(JspWriter out, RilevDatiPrdTS bo) throws IOException {
		List rilevs = ((YRilevDatiPrdTS) bo).cercaRilevazioniPerVisualizzazioneDocumenti();
		try {
			Vector associazioni = YAssDocDgtRilev.retrieveList(YAssDocDgtRilev.class, " "+YAssDocDgtRilevTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' ", "", false);
			String width = "\"width:117px\"";
			if(bo.getPersDatiPrdUtenteRilev().getRisoluzioneVideo()== PersDatiPrdUtenteRilev.RISOL_800_600) {
				width = "\"width:100px\"" ;
			}
			out.println("<table cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%\">");
			out.println("<tr valign=\"top\">");
			out.println("<td style=\"height:0px\"></td>"); 
			out.println("<tr>");
			out.println("<td width=\"15px\"></td>");
			out.println("<td>");
			out.println("<td>");
			out.println("  <table id=\"extraTable\" cellpadding=\"1\" cellspacing=\"3\" class=\"monitorListTable\">");
			out.println("  <tr>");
			out.println("    <th class=\"cell\" >" + WebElement.formatStringForHTML(ResourceLoader.getString(RilevDatiPrdTS.RES_FILE, "N_ritorno")) + "</th>");
			out.println("    <th class=\"cell\" >" + WebElement.formatStringForHTML(ResourceLoader.getString(RilevDatiPrdTS.RES_FILE, "N_ord_bolla")) + "</th>");
			out.println("    <th class=\"cell\" >" + WebElement.formatStringForHTML(ResourceLoader.getString(RilevDatiPrdTS.RES_FILE, "Articolo")) + "</th>");
			out.println("    <th class=\"cell\" >" + WebElement.formatStringForHTML(ResourceLoader.getString(RilevDatiPrdTS.RES_FILE, "Risorsa")) + "</th>");
			out.println("    <th class=\"cell\" >" + WebElement.formatStringForHTML(ResourceLoader.getString(RilevDatiPrdTS.RES_FILE, "Qta_UM")) + "</th>");
			out.println("  </tr>");
			Iterator iter = rilevs.iterator();
			int index = 0;
			while (iter.hasNext()) {
				RilevazioneDatiProdTes testata = (RilevazioneDatiProdTes) iter.next();
				String bollaLav = testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.NON_PRODUTTIVA && testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.FERMO ? testata.getNumeroRitorno() : "";
				String descrRilev = "";
				String numOrdFmt = "";
				String commessa = "";
				String idArticolo = "";
				String descrArticolo = "";
				String articolo_Config = "";
				String idMacchina = ""; 
				String descrMacchina = ""; 
				String idUmPrimaria = "";
				String idUmSecondaria = "";
				BigDecimal[] qtaDaProdurre = new BigDecimal[2];
				if (testata.getTipoBolla() == RilevazioneDatiProdTes.BOLLA_CUCITA) {
					numOrdFmt = testata.getBollaCucita().getNumeroBolFmt();
				}else if (testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.NON_PRODUTTIVA && testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.FERMO) {
					if (testata.getAttivitaEsecutiva() == null) 
						continue; 
					numOrdFmt = testata.getOrdineEsecutivo().getNumeroOrdFmt();
					idArticolo = testata.getOrdineEsecutivo().getIdArticolo();
					idMacchina = testata.getIdRisorsa(); 
					descrMacchina = testata.getRisorsa().getDescrizione().getDescrizione(); 
					descrArticolo = testata.getOrdineEsecutivo().getArticolo().getDescrizioneArticoloNLS().getDescrizione();
					idUmPrimaria = testata.getIdUMPrm();
					idUmSecondaria = testata.getIdUMSec();
					qtaDaProdurre = RilevDatiPrdTS.calcolaQuantitaDaPorduire(testata.getAttivitaEsecutiva());
					if(testata.getOrdineEsecutivo().getIdCommessa() != null)
						commessa = testata.getOrdineEsecutivo().getIdCommessa();
					if(testata.getOrdineEsecutivo().getConfigurazione() != null) {
						articolo_Config = testata.getOrdineEsecutivo().getConfigurazione().getIdEsternoConfig(); 
					}
				}
				out.println("    <tr>");
				if(testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.NON_PRODUTTIVA && testata.getTipoDichiarazione() != PersDatiPrdCausaleRilev.FERMO) {
					out.println("    <td id=\"BollaLavTD" + index + "\" class=\"cell\" >" + WebElement.formatStringForHTML(bollaLav) + "<br>" + WebElement.formatStringForHTML(descrRilev) + "</td>");
				}
				else{
					out.println("    <td id=\"BollaLavTD" + index + "\" class=\"cell\" ></td>");
					out.println("    <td class=\"cell\" >" + WebElement.formatStringForHTML(descrRilev) + "</td>");
				}
				out.println("    <td class=\"cell\" nowrap=\"true\" >" + WebElement.formatStringForHTML(numOrdFmt) + "<br>" + WebElement.formatStringForHTML(commessa) + "</td>");
				if(articolo_Config.equals("")) {
					out.println("    <td class=\"cell\" nowrap=\"true\" >" + WebElement.formatStringForHTML(idArticolo) + "<br>" + WebElement.formatStringForHTML(descrArticolo) + "</td>");  
				}else {
					out.println("    <td class=\"cell\" nowrap=\"true\" >" + WebElement.formatStringForHTML(idArticolo) + "<br>" + WebElement.formatStringForHTML(articolo_Config) + "<br>" + WebElement.formatStringForHTML(descrArticolo) + "</td>");
				}
				if(bo.getIdMacchina() == null)
					out.println("    <td class=\"cell\" nowrap=\"true\" >" + WebElement.formatStringForHTML(idMacchina) + "<br>" + WebElement.formatStringForHTML(descrMacchina) + "</td>");
				if(idUmSecondaria != null) {
					out.println("    <td class=\"cell\" nowrap=\"true\" >" + getValue(qtaDaProdurre[0], 2) + " " + WebElement.formatStringForHTML(idUmPrimaria) + "<br>" + getValue(qtaDaProdurre[1], 2) + " " + WebElement.formatStringForHTML(idUmSecondaria) + "</td>");
				}
				else {
					out.println("    <td class=\"cell\" nowrap=\"true\" >" + getValue(qtaDaProdurre[0], 2) + " " + WebElement.formatStringForHTML(idUmPrimaria) + "<br>&nbsp</td>");
				}
				//cerco i bottoni da mostrare, lo faccio qui dato che uso il BODC e non voglio usarlo in un livello + basso
				BODataCollector boDC = (BODataCollector) Factory.createObject(BODataCollector.class);
				boDC.initialize("RilevazioneDatiProdTes");
				boDC.setBo(testata);
				boDC.retrieve(testata.getKey());
				List<DocDgtEntita> btns = new ArrayList<DocDgtEntita>();
				for (Iterator iterator = associazioni.iterator(); iterator.hasNext();) {
					YAssDocDgtRilev associazione = (YAssDocDgtRilev) iterator.next();
					Entity entita = associazione.getAssociazioneentitatpdgt().getEntity();
					String hdr = entita.getClassHdrName();
					for(int i = 0; i < boDC.getRelationGroups().size(); i++) {
						BaseBOValidationGroup g = (BaseBOValidationGroup) boDC.getRelationGroups().get(i);
						if(g.getClassRD().getRelationHDR().getClassName().endsWith(hdr)) {
							String where = " "+DocDgtEntitaTM.ID_AZIENDA+" = '"+Azienda.getAziendaCorrente()+"' AND "+
									" "+DocDgtEntitaTM.ID_ENTITA+" = '"+entita.getId()+"' AND "+
									" "+DocDgtEntitaTM.KEY_ENTITA+" = '"+g.getRelatedKey()+"' AND " +
									" "+DocDgtEntitaTM.ID_TIPO_DOC_DGT+" = '"+associazione.getAssociazioneentitatpdgt().getIdTipoDocDgt()+"' AND "+ 
									" "+DocDgtEntitaTM.STATO+" = '"+DatiComuniEstesi.VALIDO+"' ";
							Vector lst = DocDgtEntita.retrieveList(DocDgtEntita.class, where, "",false);
							if(lst.size() > 0) {
								btns.addAll(lst);
							}
						}
					}
				}
				if(btns.size() == 1) {
					DocDgtEntita bottone = btns.get(0);
					DocumentoDigitale docDgt = bottone.getDocumentoDgt();
					if(docDgt.getOggetti().size() == 0)
						continue;
					out.println("    <td class=\"cell\"><button type=\"button\" onclick=\"setCurrentEvent(event); showDocDgt(");
					if (bottone.getDocumentoDgt().getOggetti().size() == 1) {
						out.print("'" + ((DocumentoDgtOggetto)bottone.getDocumentoDgt().getOggetti().get(0)).getKey() + "'");
					} else {
						out.print("[");
						for (int i = 0; i < bottone.getDocumentoDgt().getOggetti().size(); i++) {
							if (i > 0) {
								out.print(", ");
							}
							out.print("'" + ((DocumentoDgtOggetto)bottone.getDocumentoDgt().getOggetti().get(i)).getKey() + "'");
						}
						out.print("]");
					}
					out.println(")\" style=\"" + width + "\">" + bottone.getDocumentoDgt().getDescrRidotta() + "</button></td>");

				}else if(btns.size() > 1) {
					//aprire la visualizzazione multipla dei documenti digitali, la navigazione insomma
					String url = "it.thera.thip.base.documentoDgt.web.FiltroDocumentoDgtServlet?thKey=-&thClassName=FiltroDocumentoDgt&thCollectorName=it.thera.thip.base.documentoDgt.web.NavigazioneDocumentiDigitaliDataCollector";
					url += "&IdEntita"+btns.get(0).getIdEntita();
					url +="&ChiaveEntita="+btns.get(0).getChiaveEntita()+"&thMode=UPDATE&thAction=ESEGUI";
					out.println("    <td class=\"cell\"><button type=\"button\" onclick=\"setCurrentEvent(event); showDocDgtNavigation('"+url+"')\" style=\"" + width + "\">" +"Naviga"+ "</button></td>");
				}
				out.println("    </tr>");
				index = index + 1;
			}
			out.println("  </table>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>"); 
			out.println("<td colspan=\"5\" style=\"height:100%\"></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width=\"5px\">");
			out.println("</td>");
			out.println("<td colspan=\"5\">");
			out.println("<table cellpadding=\"3\" cellspacing=\"3\">"); 
			out.println("<tr>");
			out.println("<td><label class=\"labelError\" id=\"ErroriList\"></label></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		} catch (ClassNotFoundException e) {
			e.printStackTrace(Trace.excStream);
		} catch (InstantiationException e) {
			e.printStackTrace(Trace.excStream);
		} catch (IllegalAccessException e) {
			e.printStackTrace(Trace.excStream);
		} catch (SQLException e) {
			e.printStackTrace(Trace.excStream);
		}

	}
}
