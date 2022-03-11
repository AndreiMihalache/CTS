package ro.ase.acs.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import ro.ase.acs.connections.DbConnection;
import ro.ase.acs.resources.MongoStrings;



public class MongoConnection implements DbConnection {

    private MongoClient mongoClient =null;
    private MongoDatabase mongodb=null;

    @Override
    public void connect(String host, String database) {
        try{
        mongoClient = MongoClients.create(host);
        mongodb = mongoClient.getDatabase(database);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try{mongoClient.close();}
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void runOps() {
        MongoOperator operator = new MongoOperator();
        operator.operate(mongodb, MongoStrings.CreateOp);
        operator.operate(mongodb, MongoStrings.InsertOp);
        operator.operate(mongodb, MongoStrings.ReadOp);
    }
}
