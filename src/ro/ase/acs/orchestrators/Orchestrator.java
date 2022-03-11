package ro.ase.acs.orchestrators;

import ro.ase.acs.connections.DbConnection;

import java.lang.reflect.InvocationTargetException;

public class Orchestrator {

    private DbConnection db = null;

    public Orchestrator(String Dbms){
        try {
            db = (DbConnection) Class.forName(Dbms).getDeclaredConstructor().newInstance();
        }
        catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void execute(String host, String database)
    {
        db.connect(host, database);
        db.runOps();
        db.close();
    }
}
