package ro.ase.acs.operations.sql;

import ro.ase.acs.operations.Operation;
import ro.ase.acs.resources.SqlStrings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert implements Operation<Connection> {

    Statement statement = null;
    PreparedStatement preparedStatement = null;


    @Override
    public void execute(Connection connection) {
        try {
            statement = connection.createStatement();
            statement.executeUpdate(SqlStrings.SQLINSERT);
            statement.close();

            preparedStatement = connection.prepareStatement(SqlStrings.SQLINSERTPARAMS);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
