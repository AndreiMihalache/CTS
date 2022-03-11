package ro.ase.acs.mongo;

import com.mongodb.client.MongoDatabase;
import ro.ase.acs.operations.Operateable;
import ro.ase.acs.operations.Operation;

import java.lang.reflect.InvocationTargetException;

public class MongoOperator implements Operateable<MongoDatabase> {
    @Override
    public void operate(MongoDatabase connection, String operationClass) {
        try{
            Operation<MongoDatabase> operation = (Operation<MongoDatabase>) Class.forName(operationClass).getDeclaredConstructor().newInstance();
            operation.execute(connection);
        }
        catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
