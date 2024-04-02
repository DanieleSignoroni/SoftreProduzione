package it.softre.thip.produzione.raccoltaDati;

import com.thera.thermfw.persist.*;
import java.sql.*;
import com.thera.thermfw.base.*;
import it.thera.thip.cs.*;

public class YAssDocDgtRilevTM extends TableManager {

	public static final String ID_AZIENDA = "ID_AZIENDA";

	public static final String STATO = "STATO";

	public static final String R_UTENTE_CRZ = "R_UTENTE_CRZ";

	public static final String TIMESTAMP_CRZ = "TIMESTAMP_CRZ";

	public static final String R_UTENTE_AGG = "R_UTENTE_AGG";

	public static final String TIMESTAMP_AGG = "TIMESTAMP_AGG";

	public static final String ID_ENTITA = "ID_ENTITA";

	public static final String ID_TIPO_DOC_DGT = "ID_TIPO_DOC_DGT";

	public static final String SHOW = "SHOW";

	public static final String TABLE_NAME = SystemParam.getSchema("THIPPERS") + "YASS_DOC_DGT_RILEV";

	private static TableManager cInstance;

	private static final String CLASS_NAME = it.softre.thip.produzione.raccoltaDati.YAssDocDgtRilev.class.getName();

	public synchronized static TableManager getInstance() throws SQLException {
		if (cInstance == null) {
			cInstance = (TableManager)Factory.createObject(YAssDocDgtRilevTM.class);
		}
		return cInstance;
	}

	public YAssDocDgtRilevTM() throws SQLException {
		super();
	}

	protected void initialize() throws SQLException {
		setTableName(TABLE_NAME);
		setObjClassName(CLASS_NAME);
		init();
	}

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

	private void init() throws SQLException {
		configure();
	}

}

