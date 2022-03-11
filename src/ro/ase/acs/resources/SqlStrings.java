package ro.ase.acs.resources;

public class SqlStrings {
    public static String SQLConnection = "ro.ase.acs.sql.SqlConnection";
    public static String JDBC = "org.sqlite.JDBC";
    public static String DATABASE = "jdbc:sqlite:database.db";
    public static String SQLDROP = "DROP TABLE IF EXISTS employees";
    public static String SQLCREATE = "CREATE TABLE employees(id INTEGER PRIMARY KEY, name TEXT, address TEXT, salary REAL)";
    public static String SQLINSERT = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
    public static String SQLINSERTPARAMS = "INSERT INTO employees VALUES (?,?,?,?)";
    public static String SQLSELECT = "SELECT * FROM employees";
    public static String CreateOp = "ro.ase.acs.operations.sql.Create";
    public static String InsertOp = "ro.ase.acs.operations.sql.Insert";
    public static String ReadOp = "ro.ase.acs.operations.sql.Read";
}
