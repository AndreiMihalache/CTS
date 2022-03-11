package ro.ase.acs.operations.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ro.ase.acs.operations.Operation;
import org.bson.Document;

public class Insert implements Operation<MongoDatabase> {
    @Override
    public void execute(MongoDatabase connection) {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);
        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);

        MongoCollection<Document> collection = connection.getCollection("employees");
        collection.insertOne(employee1);
        collection.insertOne(employee2);
    }
}
