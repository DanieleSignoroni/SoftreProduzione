/*
 * @(#)YAssDocDgtRilevPO.java
 */

/**
 * null
 *
 * <br></br><b>Copyright (C) : Thera SpA</b>
 * @author Wizard 02/04/2024 at 12:14:06
 */
/*
 * Revisions:
 * Date          Owner      Description
 * 02/04/2024    Wizard     Codice generato da Wizard
 *
 */
package it.softre.thip.produzione.raccoltaDati;
import com.thera.thermfw.persist.*;
import java.sql.*;
import java.util.*;
import it.thera.thip.base.azienda.AziendaEstesa;
import it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgt;
import it.thera.thip.cs.*;
import com.thera.thermfw.common.*;
import it.thera.thip.base.azienda.Azienda;
import com.thera.thermfw.security.*;

public abstract class YAssDocDgtRilevPO extends EntitaAzienda implements BusinessObject, Authorizable, Deletable, Conflictable {

  
  /**
   *  instance
   */
  private static YAssDocDgtRilev cInstance;

  /**
   * Attributo iShow
   */
  protected boolean iShow = false;

  /**
   * Attributo iAssociazioneentitatpdgt
   */
  protected Proxy iAssociazioneentitatpdgt = new Proxy(it.thera.thip.base.documentoDgt.AssociazioneEntitaTpDgt.class);

  
  /**
   *  retrieveList
   * @param where
   * @param orderBy
   * @param optimistic
   * @return Vector
   * @throws SQLException
   * @throws ClassNotFoundException
   * @throws InstantiationException
   * @throws IllegalAccessException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static Vector retrieveList(String where, String orderBy, boolean optimistic) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    if (cInstance == null)
      cInstance = (YAssDocDgtRilev)Factory.createObject(YAssDocDgtRilev.class);
    return PersistentObject.retrieveList(cInstance, where, orderBy, optimistic);
  }

  /**
   *  elementWithKey
   * @param key
   * @param lockType
   * @return YAssDocDgtRilev
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public static YAssDocDgtRilev elementWithKey(String key, int lockType) throws SQLException {
    return (YAssDocDgtRilev)PersistentObject.elementWithKey(YAssDocDgtRilev.class, key, lockType);
  }

  /**
   * YAssDocDgtRilevPO
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public YAssDocDgtRilevPO() {
    setShow(false);
    setIdAzienda(Azienda.getAziendaCorrente());
  }

  /**
   * Valorizza l'attributo. 
   * @param show
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setShow(boolean show) {
    this.iShow = show;
    setDirty();
  }

  /**
   * Restituisce l'attributo. 
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean getShow() {
    return iShow;
  }

  /**
   * Valorizza l'attributo. 
   * @param associazioneentitatpdgt
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
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

  /**
   * Restituisce l'attributo. 
   * @return AssociazioneEntitaTpDgt
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public AssociazioneEntitaTpDgt getAssociazioneentitatpdgt() {
    return (AssociazioneEntitaTpDgt)iAssociazioneentitatpdgt.getObject();
  }

  /**
   * setAssociazioneentitatpdgtKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setAssociazioneentitatpdgtKey(String key) {
    iAssociazioneentitatpdgt.setKey(key);
    String idAzienda = KeyHelper.getTokenObjectKey(key, 1);
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * getAssociazioneentitatpdgtKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getAssociazioneentitatpdgtKey() {
    return iAssociazioneentitatpdgt.getKey();
  }

  /**
   * Valorizza l'attributo. 
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdAzienda(String idAzienda) {
    setIdAziendaInternal(idAzienda);
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdAzienda() {
    String key = iAzienda.getKey();
    return key;
  }

  /**
   * Valorizza l'attributo. 
   * @param idEntita
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdEntita(String idEntita) {
    String key = iAssociazioneentitatpdgt.getKey();
    iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key , 2, idEntita));
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdEntita() {
    String key = iAssociazioneentitatpdgt.getKey();
    String objIdEntita = KeyHelper.getTokenObjectKey(key,2);
    return objIdEntita;
    
  }

  /**
   * Valorizza l'attributo. 
   * @param idTipoDocDgt
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setIdTipoDocDgt(String idTipoDocDgt) {
    String key = iAssociazioneentitatpdgt.getKey();
    iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key , 3, idTipoDocDgt));
    setDirty();
    setOnDB(false);
  }

  /**
   * Restituisce l'attributo. 
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getIdTipoDocDgt() {
    String key = iAssociazioneentitatpdgt.getKey();
    String objIdTipoDocDgt = KeyHelper.getTokenObjectKey(key,3);
    return objIdTipoDocDgt;
  }

  /**
   * setEqual
   * @param obj
   * @throws CopyException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setEqual(Copyable obj) throws CopyException {
    super.setEqual(obj);
    YAssDocDgtRilevPO yAssDocDgtRilevPO = (YAssDocDgtRilevPO)obj;
    iAssociazioneentitatpdgt.setEqual(yAssDocDgtRilevPO.iAssociazioneentitatpdgt);
  }

  /**
   * checkAll
   * @param components
   * @return Vector
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public Vector checkAll(BaseComponentsCollection components) {
    Vector errors = new Vector();
    components.runAllChecks(errors);
    return errors;
  }

  /**
   *  setKey
   * @param key
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public void setKey(String key) {
    setIdAzienda(KeyHelper.getTokenObjectKey(key, 1));
    setIdEntita(KeyHelper.getTokenObjectKey(key, 2));
    setIdTipoDocDgt(KeyHelper.getTokenObjectKey(key, 3));
  }

  /**
   *  getKey
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String getKey() {
    String idAzienda = getIdAzienda();
    String idEntita = getIdEntita();
    String idTipoDocDgt = getIdTipoDocDgt();
    Object[] keyParts = {idAzienda, idEntita, idTipoDocDgt};
    return KeyHelper.buildObjectKey(keyParts);
  }

  /**
   * isDeletable
   * @return boolean
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public boolean isDeletable() {
    return checkDelete() == null;
  }

  /**
   * toString
   * @return String
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  public String toString() {
    return getClass().getName() + " [" + KeyHelper.formatKeyString(getKey()) + "]";
  }

  /**
   *  getTableManager
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected TableManager getTableManager() throws SQLException {
    return YAssDocDgtRilevTM.getInstance();
  }

  /**
   * setIdAziendaInternal
   * @param idAzienda
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void setIdAziendaInternal(String idAzienda) {
    iAzienda.setKey(idAzienda);
        String key2 = iAssociazioneentitatpdgt.getKey();
    iAssociazioneentitatpdgt.setKey(KeyHelper.replaceTokenObjectKey(key2, 1, idAzienda));
  }

}

