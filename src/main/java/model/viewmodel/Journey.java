package model.viewmodel;

import model.sql.CRUD;
import model.sql.CRUD.*;
import model.sql.SQLStatments;
import model.sql.SQLStatments;
import model.sql.TableMapping;
import org.eclipse.swt.events.MouseAdapter;

public class Journey {

    public record DeleteAppointment(MouseAdapter deleteAppointment, MouseAdapter confirm, MouseAdapter back) {}
    public record EditCustomer(MouseAdapter inputCustomerId, MouseAdapter updateCustomer) {}

    public enum JourneyResultType {

        DeleteAppointment(SQL.DELETE, SQLStatments.DeleteAppointment),
        EditCustomer(SQL.UPDATE, SQLStatments.UpdateCustomer);

        private CRUD.SQL crudType;
        private String resultOfSql;

        JourneyResultType(CRUD.SQL crudType, String resultOfSql) {
            this.crudType = crudType;
            this.resultOfSql = resultOfSql;
        }

        public CRUD.SQL getCrudType() {
            return crudType;
        }

        public String getResultOfSql() {
            return resultOfSql;
        }
    }
}
