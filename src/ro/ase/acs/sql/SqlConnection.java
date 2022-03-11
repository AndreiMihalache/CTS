package ro.ase.acs.sql;

import ro.ase.acs.connections.DbConnection;
import ro.ase.acs.resources.SqlStrings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnection implements DbConnection{

    private Connection connection=null;

    @Override
    public void connect(String host, String database) {

        try{
            Class.forName(host);
            connection = DriverManager.getConnection(database);
            connection.setAutoCommit(false);
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        try{
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void runOps()
    {
        SqlOperator operator = new SqlOperator();
        operator.operate(connection, SqlStrings.CreateOp);
        operator.operate(connection, SqlStrings.InsertOp);
        operator.operate(connection, SqlStrings.ReadOp);
    }

}
