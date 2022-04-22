package es.fpdual.mybatis.impl;

import org.apache.ibatis.session.SqlSession;

import es.fpdual.mybatis.dao.DAOConnection;
import es.fpdual.mybatis.dao.MySessionFactory;

public class DAOConnectionImpl implements DAOConnection {

    private final MySessionFactory instance = MySessionFactory.getInstance();

    @Override
    public String getVersionMysql() {
        String version = "";
        SqlSession session = null;

        try {
            session = instance.getFactory().openSession();
            version = session.selectOne("mysqlVersion");
        } catch (Exception error) {
            System.out.println(error);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return version;
    }

}
