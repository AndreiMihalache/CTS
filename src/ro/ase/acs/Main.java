package ro.ase.acs;

import ro.ase.acs.orchestrators.Orchestrator;
import ro.ase.acs.resources.MongoStrings;
import ro.ase.acs.resources.SqlStrings;

public class Main {
    public static void main(String[] args) {
        Orchestrator orchestrator;
        orchestrator = new Orchestrator(SqlStrings.SQLConnection);
        orchestrator.execute(SqlStrings.JDBC, SqlStrings.DATABASE);

        orchestrator = new Orchestrator(MongoStrings.MongoConnection);
        orchestrator.execute(MongoStrings.MongoHost, MongoStrings.DATABASE);
    }
}
