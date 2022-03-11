package ro.ase.acs.operations;

public interface Operation<T> {
    void execute(T connection);
}
