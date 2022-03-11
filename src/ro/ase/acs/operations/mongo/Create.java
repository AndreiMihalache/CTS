package ro.ase.acs.operations.mongo;

import com.mongodb.client.MongoDatabase;
import ro.ase.acs.operations.Operation;

public class Create implements Operation<MongoDatabase> {
    @Override
    public void execute(MongoDatabase connection) {
        connection.getCollection("employees");
        connection.getCollection("employees").drop();
        connection.createCollection("employees");
    }
}
