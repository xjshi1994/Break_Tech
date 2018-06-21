public class TestConn {
    public static void main(String[] args) {
        String schemaName = "link_financial_customer";
        String propertiesPath = "src/main/resources/dbconnection.properties";
        DBHepler dbHepler = new DBHepler(schemaName, propertiesPath);
        dbHepler.connectRemoteMachine(propertiesPath);
    }
}
