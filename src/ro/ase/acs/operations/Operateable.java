package ro.ase.acs.operations;

public interface Operateable<T> {
    void operate(T connection, String operationClass) throws ClassNotFoundException;
}
