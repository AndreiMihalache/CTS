package ro.ase.acs.sql;

import ro.ase.acs.operations.Operateable;
import ro.ase.acs.operations.Operation;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;


public class SqlOperator implements Operateable<Connection> {


    @Override
    public void operate(Connection connection, String operationClass){
        try{
            Operation<Connection> operation = (Operation<Connection>) Class.forName(operationClass).getDeclaredConstructor().newInstance();
            operation.execute(connection);
        }
        catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

}
