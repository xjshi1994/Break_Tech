import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String schemaName = "link_financial_customer";
        String sql = "select name, primary_mobile, financing_amount from potential_customer_info where gender = ?";
        String propertiesPath = "src/main/resources/dbconnection.properties";
        DBHepler dbHelper = new DBHepler(schemaName, propertiesPath);
        PreparedStatement pstmt = dbHelper.prepareStatement(sql);
        int k = 0;
        try {
            for (int i =1 ; i <=2; i++) {
                pstmt.setInt(1, i);
                ResultSet rs = pstmt.executeQuery();
                if (i == 1) {
                    System.out.println("potential male customer following:");
                } else {
                    System.out.println("potential female customer following:");
                }
                while (rs.next()) {
                    k++;
                    String name = rs.getString("name");
                    String mobile = rs.getString("primary_mobile");
                    long financing_amount = rs.getLong("financing_amount");
                    System.out.printf("name: %s mobile: %s amount:%d%n", name, mobile, financing_amount);
                }
            }
            System.out.println("total num:" + k);
            dbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
