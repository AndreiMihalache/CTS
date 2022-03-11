package ro.ase.acs.operations.sql;

import ro.ase.acs.operations.Operation;
import ro.ase.acs.resources.SqlStrings;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create implements Operation<Connection> {

    Statement statement = null;

    @Override
    public void execute(Connection connection) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(SqlStrings.SQLDROP);
            statement.executeUpdate(SqlStrings.SQLCREATE);
            statement.close();
            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
