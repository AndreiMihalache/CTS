package ro.ase.acs.operations.sql;

import ro.ase.acs.operations.Operation;
import ro.ase.acs.resources.SqlStrings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read implements Operation<Connection> {
    Statement statement =null;
    ResultSet resultSet =null;

    @Override
    public void execute(Connection connection) {
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SqlStrings.SQLSELECT);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString(2);
                String address = resultSet.getString("address");
                double salary = resultSet.getDouble("salary");
                System.out.println("id: "+id+"\nname: "+name+"\naddress: "+address+"\nsalary: "+salary+"\n");
            }
            resultSet.close();
            statement.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
