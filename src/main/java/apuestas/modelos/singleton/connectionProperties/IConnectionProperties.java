package apuestas.modelos.singleton.connectionProperties;

public interface IConnectionProperties {

    void setConnectionProperties();

    String getDriver();

    String getUrl();

    String getUser();

    String getPassword();

}
