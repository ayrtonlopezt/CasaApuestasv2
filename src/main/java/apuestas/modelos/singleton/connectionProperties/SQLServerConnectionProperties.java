package apuestas.modelos.singleton.connectionProperties;

public class SQLServerConnectionProperties implements IConnectionProperties {

    private String driver;
    private String url;
    private String user;
    private String password;

    @Override
    public void setConnectionProperties() {
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.url = "jdbc:sqlserver://localhost:1433/equipos";
        this.user = "root";
        this.password = "nod123456";
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
