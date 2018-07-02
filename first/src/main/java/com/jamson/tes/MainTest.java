package com.jamson.tes;

import com.jamson.tes.po.CityPO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jliu1 on 2018/6/5.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        String resource = "C:\\Users\\jliu1\\Desktop\\project\\mybatis\\first\\src\\main\\resources\\mybatis-config.xml";
        resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            CityPO cityPO = (CityPO) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
        } finally {
            session.close();
        }
    }
}
