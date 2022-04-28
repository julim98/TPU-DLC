package soporte;

import java.sql.*;

public class Coneccion {

    public static final String POSTGRES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String H2_DRIVER_NAME = "org.h2.Driver";
    public static final String SQLSERVER_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static final String user = "";
    private static final String password = "";
    private static final String url = "";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public void executeStatement(String query) throws SQLException {
        Connection c = conectar();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);



        close(rs);
        close(st);
        close(c);
    }

    public void close(Connection c) throws SQLException {
        c.close();
    }

    public void close(Statement c) throws SQLException {
        c.close();
    }

    public void close(ResultSet c) throws SQLException {
        c.close();
    }
}
