package it.softre.thip.produzione.raccoltaDati.web;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

import com.thera.thermfw.ad.ClassAD;
import com.thera.thermfw.ad.ClassADCollection;
import com.thera.thermfw.ad.ClassADCollectionManager;
import com.thera.thermfw.ad.ClassRD;
import com.thera.thermfw.base.Trace;
import com.thera.thermfw.security.Entity;
import com.thera.thermfw.security.EntityNotFoundException;

import it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgtTM;
import it.thera.thip.cs.web.AziendaDOList;

/**
 * <h1>Softre Solutions</h1>
 * <br>
 * @author Daniele Signoroni 02/04/2024
 * <br><br>
 * <b></b>
 * <p>
 * Prima stesura.<br>
 * E' una specificDOList, serve per filtrare i valori di {@link AssociazioneEntitaTpDgtTM#TABLE_NAME}.<br>
 * In questo caso specifico, voglio mostrare le associazioni entita/tp dgt nel contesto RilevazioneDati.<br>
 * Vado quindi a fare una retrieve, secondo lo standard, delle relazioni di questo descrittore, in seguito
 * cerco l'entita' tramite standard, e se la trovo la inserisco nella IN.<br>
 * 
 * In questo caso saro' poi autonomo di fare delle deduzioni dinamiche tra Documento Digitale <--> Rilevazione dati.<br>
 * </p>
 */

public class YAssDocDgtRilevDoList extends AziendaDOList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setRestrictCondition(ClassAD[] attributes, String[] values) {
		super.setRestrictCondition(attributes, values);
		StringBuilder sqlBuilder = new StringBuilder(" AND ( PRIM."+AssociazioneEntitaTpDgtTM.ID_ENTITA+" IN (");
		try {
			ClassADCollection cadc = ClassADCollectionManager.collectionWithName("RilevazioneDatiProdTes");
			Hashtable hastab = cadc.getRelations();
			Enumeration<String> keys = hastab.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				ClassRD value = (ClassRD) hastab.get(key);
				try {
					Entity entity = Entity.findEntity(com.thera.thermfw.persist.Factory.createObject(value.getRelationHDR().getBOClassName()));
					if(entity != null) {
						sqlBuilder.append("'").append(entity.getId()).append("'");
						if (keys.hasMoreElements()) {
							sqlBuilder.append(", ");
						}
					}
				} catch (EntityNotFoundException e) {
					e.printStackTrace(Trace.excStream);
				} catch (SQLException e) {
					e.printStackTrace(Trace.excStream);
				}
			}
			sqlBuilder.append("))");
		} catch (NoSuchElementException e) {
			e.printStackTrace(Trace.excStream);
		} catch (NoSuchFieldException e) {
			e.printStackTrace(Trace.excStream);
		}
		specificWhereClause += sqlBuilder.toString();
	}

}
