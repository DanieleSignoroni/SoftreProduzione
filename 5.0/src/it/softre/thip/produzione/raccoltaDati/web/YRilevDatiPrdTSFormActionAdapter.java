package it.softre.thip.produzione.raccoltaDati.web;

import java.io.IOException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.web.ServletEnvironment;

import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSFormActionAdapter;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 02/04/2024
 * <br><br>
 * <b></b>
 * <p>Prima stesura.<br>
 * Manage di nuove azioni personalizzate.
 * </p>
 */

public class YRilevDatiPrdTSFormActionAdapter extends RilevDatiPrdTSFormActionAdapter {

	private static final long serialVersionUID = 1L;

	public static final String DOCUMENTI_PERS = "DOCUMENTI_PERS";

	@Override
	protected void otherActions(ClassADCollection cadc, ServletEnvironment se) throws ServletException, IOException {
		String azione = getStringParameter(se.getRequest(), ACTION).toUpperCase();
		if(azione.equals(DOCUMENTI_PERS)) {
			azioneDocumentiPers(azione, se);
		}else {
			super.otherActions(cadc, se);
		}
	}

	protected void azioneDocumentiPers(String azione, ServletEnvironment se) throws ServletException, IOException {
		se.getRequest().setAttribute("Action", azione);
		se.sendRequest(getServletContext(), se.getServletPath() + Factory.getName("it.softre.thip.produzione.raccoltaDati.web.AzioneDocumentiTS", Factory.CLASS), true);
	}
}
