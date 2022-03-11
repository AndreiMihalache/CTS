package ro.ase.acs.operations.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.acs.operations.Operation;

public class Read implements Operation<MongoDatabase> {
    @Override
    public void execute(MongoDatabase connection) {
        MongoCollection<Document> collection = connection.getCollection("employees");
        FindIterable<Document> result = collection.find();
        for(Document doc : result) {
            System.out.println(doc);
        }
    }
}
