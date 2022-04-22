package es.fpdual.mybatis.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySessionFactory {
    private static MySessionFactory instance;
    private SqlSessionFactory factory;

    private MySessionFactory() {
        String resource = "mybatis-config.xml";
        Reader reader = null;

        try {
            reader = Resources.getResourceAsReader(resource);
            factory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public static MySessionFactory getInstance() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}
