/*
 * @(#)YAssDocDgtRilevTM.java
 */

/**
 * YAssDocDgtRilevTM
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
import com.thera.thermfw.common.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YAssDocDgtRilevTM extends TableManager {

  
  /**
   * Attributo ID_AZIENDA
   */
  public static final String ID_AZIENDA = "ID_AZIENDA";

  /**
   * Attributo STATO
   */
  public static final String STATO = "STATO";

  /**
   * Attributo R_UTENTE_CRZ
   */
  public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

  /**
   * Attributo TIMESTAMP_CRZ
   */
  public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

  /**
   * Attributo R_UTENTE_AGG
   */
  public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

  /**
   * Attributo TIMESTAMP_AGG
   */
  public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

  /**
   * Attributo ID_ENTITA
   */
  public static final String ID_ENTITA = "ID_ENTITA";

  /**
   * Attributo ID_TIPO_DOC_DGT
   */
  public static final String ID_TIPO_DOC_DGT = "ID_TIPO_DOC_DGT";

  /**
   * Attributo SHOW
   */
  public static final String SHOW = "SHOW";

  /**
   *  TABLE_NAME
   */
  public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YASS_DOC_DGT_RILEV";

  /**
   *  instance
   */
  private static TableManager cInstance;

  /**
   *  CLASS_NAME
   */
  private static final String CLASS_NAME = it.softre.thip.produzione.raccoltaDati.YAssDocDgtRilev.class.getName();

  
  /**
   *  getInstance
   * @return TableManager
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public synchronized static TableManager getInstance() throws SQLException {
    if (cInstance == null) {
      cInstance = (TableManager)Factory.createObject(YAssDocDgtRilevTM.class);
    }
    return cInstance;
  }

  /**
   *  YAssDocDgtRilevTM
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  public YAssDocDgtRilevTM() throws SQLException {
    super();
  }

  /**
   *  initialize
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    CodeGen     Codice generato da CodeGenerator
   *
   */
  protected void initialize() throws SQLException {
    setTableName(TABLE_NAME);
    setObjClassName(CLASS_NAME);
    init();
  }

  /**
   *  initializeRelation
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  protected void initializeRelation() throws SQLException {
    super.initializeRelation();
    addAttribute("Show", SHOW);
    addAttribute("IdAzienda", ID_AZIENDA);
    addAttribute("IdEntita", ID_ENTITA);
    addAttribute("IdTipoDocDgt", ID_TIPO_DOC_DGT);
    
    addComponent("DatiComuniEstesi", DatiComuniEstesiTTM.class);
    setKeys(ID_AZIENDA + "," + ID_ENTITA + "," + ID_TIPO_DOC_DGT);

    setTimestampColumn("TIMESTAMP_AGG");
    ((it.thera.thip.cs.DatiComuniEstesiTTM)getTransientTableManager("DatiComuniEstesi")).setExcludedColums();
  }

  /**
   *  init
   * @throws SQLException
   */
  /*
   * Revisions:
   * Date          Owner      Description
   * 02/04/2024    Wizard     Codice generato da Wizard
   *
   */
  private void init() throws SQLException {
    configure(SHOW + ", " + ID_AZIENDA + ", " + ID_ENTITA + ", " + ID_TIPO_DOC_DGT
         + ", " + STATO + ", " + R_UTENTE_CRZ + ", " + TIMESTAMP_CRZ + ", " + R_UTENTE_AGG
         + ", " + TIMESTAMP_AGG);
  }

}

