package controller;

import controller.sql.QueryExecutor;
import controller.sql.ResultHandler;
import model.sql.CRUD;
import model.viewmodel.Journey;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryController {

    private ResultHandler handler;
    private QueryExecutor executor;

    public QueryController(String ip) {
        handler = new ResultHandler(this);
        executor = new QueryExecutor(handler, ip);
    }

    public void query(String sql, ArrayList<Object> param, Journey.JourneyResultType type) {
        try {
            executor.executeSQL(sql, param, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public QueryExecutor getExecutor() {
        return executor;
    }

}
