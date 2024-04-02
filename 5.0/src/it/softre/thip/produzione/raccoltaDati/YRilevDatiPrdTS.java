package it.softre.thip.produzione.raccoltaDati;

import java.util.ArrayList;
import java.util.List;

import com.thera.thermfw.base.Trace;

import it.thera.thip.cs.DatiComuniEstesi;
import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdTes;
import it.thera.thip.produzione.raccoltaDati.RilevazioneDatiProdTesTM;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 02/04/2024
 * <br><br>
 * <b></b>
 * <p>Prima stesura.<br>
 * Manage di nuove azioni personalizzate.<br>
 * </p>
 */

public class YRilevDatiPrdTS extends RilevDatiPrdTS {

	@SuppressWarnings("rawtypes")
	public List cercaRilevazioniPerVisualizzazioneDocumenti() {
		List rilevs = new ArrayList();
		String where = RilevazioneDatiProdTesTM.ID_AZIENDA + " ='" + getIdAzienda() + "' AND ";
		where += RilevazioneDatiProdTesTM.R_OPERATORE + " ='" + getIdOperatore() + "' AND " +
				RilevazioneDatiProdTesTM.STATO_RIL + " IN ('" + RilevazioneDatiProdTes.IN_CORSO + "') AND " +
				RilevazioneDatiProdTesTM.STATO + " ='" + DatiComuniEstesi.INCOMPLETO + "' AND " +
				RilevazioneDatiProdTesTM.DATA_FINE+" IS NULL ";
		try{
			rilevs = RilevazioneDatiProdTes.retrieveList(where, RilevazioneDatiProdTesTM.TIPO_DICHIAR, true);
		}catch(Exception ex){
			ex.printStackTrace(Trace.excStream);
		}
		return rilevs;
	}
}
