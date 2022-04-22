package es.fpdual.mybatis.connection;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.fpdual.mybatis.dao.DAOConnection;
import es.fpdual.mybatis.impl.DAOConnectionImpl;

/**
 * Unit test for simple App.
 */
public class ConnectionTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldConnectAndGetMysqlVersion() {
        String mySqlVersion = "10.4.24-MariaDB";

        DAOConnection connection = new DAOConnectionImpl();
        assertTrue(connection.getVersionMysql().equals(mySqlVersion));
    }
}
