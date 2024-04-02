package it.softre.thip.produzione.raccoltaDati;

import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgt;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YAssDocDgtRilevPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

	private static YAssDocDgtRilev cInstance;

	protected boolean iShow = false;

	protected Proxy iAssociazioneentitatpdgt = new Proxy(it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgt.class);

	@SuppressWarnings("rawtypes")
	public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (cInstance == null)
			cInstance = (YAssDocDgtRilev)Factory.createObject(YAssDocDgtRilev.class);
		return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
	}

	public static YAssDocDgtRilev elementWithKey(String key, int lockType) throws SQLException {
		return (YAssDocDgtRilev)PersistentObject.elementWithKey(YAssDocDgtRilev.class, key, lockType);
	}

	public YAssDocDgtRilevPO() {
		setShow(false);
		setIdAzienda(Azienda.getAziendaCorrente());
	}

	public void setShow(boolean show) {
		this.iShow = show;
		setDirty();
	}

	public boolean getShow() {
		return iShow;
	}

	public void setAssociazioneentitatpdgt(AssociazioneEntitaTpDgt associazioneentitatpdgt) {
		String idAzienda = getIdAzienda();
		if (associazioneentitatpdgt != null) {
			idAzienda = KeyHelper.getTokenObjectKey(associazioneentitatpdgt.getKey(), 1);
		}
		setIdAziendaInternal(idAzienda);
		this.iAssociazioneentitatpdgt.setObject(associazioneentitatpdgt);
		setDirty();
		setOnDB(false);
	}

	public AssociazioneEntitaTpDgt getAssociazioneentitatpdgt() {
		return (AssociazioneEntitaTpDgt)iAssociazioneentitatpdgt.getObject();
	}

	public void setAssociazioneentitatpdgtKey(String key) {
		iAssociazioneentitatpdgt.setKey(key);
		String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getAssociazioneentitatpdgtKey() {
		return iAssociazioneentitatpdgt.getKey();
	}

	public void setIdAzienda(String idAzienda) {
		setIdAziendaInternal(idAzienda);
		setDirty();
		setOnDB(false);
	}

	public String getIdAzienda() {
		String key = iAzienda.getKey();
		return key;
	}

	public void setIdEntita(String idEntita) {
		String key = iAssociazioneentitatpdgt.getKey();
		iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idEntita));
		setDirty();
		setOnDB(false);
	}

	public String getIdEntita() {
		String key = iAssociazioneentitatpdgt.getKey();
		String objIdEntita = KeyHelper.getTokenObjectKey(key,2);
		return objIdEntita;

	}

	public void setIdTipoDocDgt(String idTipoDocDgt) {
		String key = iAssociazioneentitatpdgt.getKey();
		iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key , 3, idTipoDocDgt));
		setDirty();
		setOnDB(false);
	}

	public String getIdTipoDocDgt() {
		String key = iAssociazioneentitatpdgt.getKey();
		String objIdTipoDocDgt = KeyHelper.getTokenObjectKey(key,3);
		return objIdTipoDocDgt;
	}

	public void setEqual(Copyable obj) throws CopyException {
		super.setEqual(obj);
		YAssDocDgtRilevPO yAssDocDgtRilevPO = (YAssDocDgtRilevPO)obj;
		iAssociazioneentitatpdgt.setEqual(yAssDocDgtRilevPO.iAssociazioneentitatpdgt);
	}

	@SuppressWarnings("rawtypes")
	public Vector checkAll(BaseComponentsCollection components) {
		Vector errors = new Vector();
		components.runAllChecks(errors);
		return errors;
	}

	public void setKey(String key) {
		setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
		setIdEntita(KeyHelper.getTokenObjectKey(key, 2));
		setIdTipoDocDgt(KeyHelper.getTokenObjectKey(key, 3));
	}

	public String getKey() {
		String idAzienda = getIdAzienda();
		String idEntita = getIdEntita();
		String idTipoDocDgt = getIdTipoDocDgt();
		Object[] keyParts = {idAzienda, idEntita, idTipoDocDgt};
		return KeyHelper.buildObjectKey(keyParts);
	}

	public boolean isDeletable() {
		return checkDelete() == null;
	}

	public String toString() {
		return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
	}

	protected TableManager getTableManager() throws SQLException {
		return YAssDocDgtRilevTM.getInstance();
	}

	protected void setIdAziendaInternal(String idAzienda) {
		iAzienda.setKey(idAzienda);
		String key2 = iAssociazioneentitatpdgt.getKey();
		iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
	}

}

