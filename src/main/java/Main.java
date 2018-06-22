import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Main {

    public static void main(String[] args){

        Cluster c= Cluster.builder()
                    .addContactPoint("10.115.2.201")
                    .addContactPoint("10.115.2.202")
                    .withPort(9042)
                    .build();

        Session s = c.connect("project");
        ResultSet rs = s.execute("SELECT * FROM utilisateur");

        for(Row r : rs.all()){
            System.out.println(r.getString("nom"));
        }

        //Sample of create new KEYSPACE
        //s.execute("CREATE KEYSPACE project WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};");

        s.close();
        c.close();

    }
}
