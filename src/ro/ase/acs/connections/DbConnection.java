package ro.ase.acs.connections;

public interface DbConnection {
    void connect(String host, String database);

    void close();

    void runOps();
}
