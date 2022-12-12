package model.viewmodel;

import model.sql.CRUD;
import model.sql.CRUD.*;
import model.sql.SqlBefehle;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.SelectionAdapter;

public class Reise {

    public record ErstelleTermin(MouseAdapter eingabeKundenId, MouseAdapter erstelleTermin, SelectionAdapter waehleHund, SelectionAdapter waehleMa,
                                 SelectionAdapter waehleDatum, MouseAdapter zeigeBuchung, MouseAdapter zurueck) {}
    public record BestaetigeTermin(MouseAdapter bestaetige, MouseAdapter zurueck) {}
    public record EntferneTermin(MouseAdapter entferneTermin, MouseAdapter bestaetige, MouseAdapter zurueck) {}
    public record BearbeiteKunde(MouseAdapter eingabeKundenId, MouseAdapter bestaetige, MouseAdapter zurueck, MouseAdapter bearbeiteKunde) {}

    public enum ReiseResultatsTyp {

        ErstelleTermin(SQL.CREATE, SqlBefehle.ErstelleTermin),
        EntferneTermin(SQL.DELETE, SqlBefehle.EntferneBuchung),
        BearbeiteKunde(SQL.UPDATE, SqlBefehle.BearbeiteKunde);

        private CRUD.SQL crudTyp;
        private String ergebnisSql;

        ReiseResultatsTyp(CRUD.SQL crudTyp, String ergebnisSql) {
            this.crudTyp = crudTyp;
            this.ergebnisSql = ergebnisSql;
        }

        public CRUD.SQL getCrudTyp() {
            return crudTyp;
        }

        public String getErgebnisSql() {
            return ergebnisSql;
        }
    }
}
