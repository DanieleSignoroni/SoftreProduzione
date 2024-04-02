package it.softre.thip.produzione.raccoltaDati.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.collector.BODataCollector;
import com.thera.thermfw.persist.Factory;
import com.thera.thermfw.persist.KeyHelper;
import com.thera.thermfw.web.ServletEnvironment;
import com.thera.thermfw.web.servlet.Check;

import it.thera.thip.produzione.raccoltaDati.RilevDatiPrdTS;
import it.thera.thip.produzione.raccoltaDati.web.RilevDatiPrdTSDataCollector;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 02/04/2024
 * <br><br>
 * <b></b>
 * <p>Prima stesura.<br>
 * Manage di azione {@value YRilevDatiPrdTSFormActionAdapter#DOCUMENTI_PERS} : <br>
 * servlet aggiunta per fare delle deduzioni sull'oggetto di business prima del display della jsp.<br>
 * La servlet accetta replacement.<br>
 * </p>
 */

public class AzioneDocumentiTS extends Check {

	private static final long serialVersionUID = 1L;

	@Override
	public void processAction(ServletEnvironment se) throws ServletException, IOException, SQLException{
		String action = (String) se.getRequest().getAttribute("Action");
		RilevDatiPrdTSDataCollector boDC  = creaBoDC(se);
		boDC.completaRilevazione(action);
		if (se.isErrorListEmpity())
		{
			boDC.setAutoCheck(false);
			boDC.setServletEnvironment(se); 
			se.getRequest().setAttribute("Action", action);
			actionOnObject(boDC, se);
		}
		closeAction(boDC, se);
		RilevDatiPrdTS bo = (RilevDatiPrdTS) boDC.getBo();
		String url = null; 
		if (se.isErrorListEmpity()){
			if(action.equals(YRilevDatiPrdTSFormActionAdapter.DOCUMENTI_PERS)){
				se.getRequest().setAttribute("Action", action); 
				se.getRequest().setAttribute("myObject", bo);
				url = "it/softre/thip/produzione/raccoltaDati/DocumentiRilevazione.jsp"; 
			}
		}
		else {
			if (areCondizRitornoNuovaDichSuErrore(se)) {	
				se.getRequest().setAttribute("myObject", bo);
				se.getRequest().setAttribute("Action", null);
				se.getRequest().setAttribute("ErroriList", boDC.getErrorList().getErrors());
				url = "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp";
			}
			else {
				url = getURLAzioneSuErrorePers(se, bo);
			} 
		}
		se.getRequest().setAttribute("JspName", url); 
		se.getRequest().setAttribute("PrevJspName", "it/thera/thip/produzione/raccoltaDati/NuovaDichiarazione.jsp" + KeyHelper.KEY_SEPARATOR + ""); 
		url = getUrlPers(se, bo, url);
		se.sendRequest(getServletContext(), url, true); 
	}

	public String getUrlPers(ServletEnvironment se, RilevDatiPrdTS bo, String url) {
		return url;
	}

	protected boolean areCondizRitornoNuovaDichSuErrore(ServletEnvironment se) {
		return true;
	}

	protected String getURLAzioneSuErrorePers(ServletEnvironment se, RilevDatiPrdTS bo) throws ServletException, IOException, SQLException {
		return null;
	}

	public RilevDatiPrdTSDataCollector creaBoDC(ServletEnvironment se) {
		String className = getStringParameter(se.getRequest(), "thClassName");
		String collectorName = getStringParameter(se.getRequest(), "thCollectorName");
		//String action = (String) se.getRequest().getAttribute("Action");
		if (collectorName == null || collectorName.equals(""))
			collectorName = BODataCollector.class.getName();
		ClassADCollection cadc = getClassADCollection(className);
		RilevDatiPrdTSDataCollector boDC = (RilevDatiPrdTSDataCollector) Factory.createObject(collectorName);
		boDC.initialize(className, true, getCurrentLockType(se));
		setValues(cadc, boDC, se);
		return boDC;
	}

}
