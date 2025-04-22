package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brand = brandMapper.selectAll();
        System.out.println(brand);

        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //假设从外界收到的id为
        int id = 1;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();
    }

    //条件查询，一下三种都可以，对应使用
      //散装参数
//    @Test
//    public void testSelectByCondition() throws IOException {
//        //假设从外界收到的id为
//        int status = 1;
//        String companyName = "华为";
//        String brandName = "华为";
//
//        companyName = "%" + companyName + "%";
//        brandName = "%" +brandName + "%";
//
//        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//
//
//        List<Brand> brand = brandMapper.selectByCondition(status,companyName,brandName);
//        System.out.println(brand);
//
//        sqlSession.close();
//    }

    //对象传参
//    @Test
//    public void testSelectByCondition() throws IOException {
//        //假设从外界收到的id为
//        int status = 1;
//        String companyName = "华为";
//        String brandName = "华为";
//
//        companyName = "%" + companyName + "%";
//        brandName = "%" +brandName + "%";
//
//        Brand t = new Brand();
//        t.setBrandName(brandName);
//        t.setCompanyName(companyName);
//        t.setStatus(status);
//
//        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//
//
//        List<Brand> brand = brandMapper.selectByCondition(t);
//        System.out.println(brand);
//
//        sqlSession.close();
//    }

    //集合传参
//    @Test
//    public void testSelectByCondition() throws IOException {
//        //假设从外界收到的id为
//        int status = 1;
//        String companyName = "华为";
//        String brandName = "华为";
//
//        companyName = "%" + companyName + "%";
//        brandName = "%" +brandName + "%";
//
//        Map map = new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
//        map.put("brandName",brandName);
//
//        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//
//
//        List<Brand> brand = brandMapper.selectByCondition(map);
//        System.out.println(brand);
//
//        sqlSession.close();
//    }

    //多条件动态查询传参
    @Test
    public void testSelectByCondition() throws IOException {
        //假设从外界收到的id为
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" +brandName + "%";

        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brand = brandMapper.selectByCondition(map);
        System.out.println(brand);

        sqlSession.close();
    }

    //单条件动态查询
    @Test
    public void testSelectByConditionSingle() throws IOException {
        //假设从外界收到的id为
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" + companyName + "%";
        brandName = "%" +brandName + "%";

        Brand t = new Brand();
        //t.setBrandName(brandName);
        t.setCompanyName(companyName);
        //t.setStatus(status);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brand = brandMapper.selectByConditionSingle(t);
        System.out.println(brand);

        sqlSession.close();
    }

    //增加操作
    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机，手机中的战斗机";
        int ordered = 100;

//        companyName = "%" + companyName + "%";
//        brandName = "%" +brandName + "%";

        Brand t = new Brand();
        t.setBrandName(brandName);
        t.setCompanyName(companyName);
        t.setStatus(status);
        t.setDescription(description);
        t.setOrdered(ordered);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(t);
        //提交事务
        sqlSession.commit();


        //自动提交事务
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        brandMapper.add(t);

        Integer id = t.getId();
        System.out.println(id);

        sqlSession.close();
    }


    //修改操作
    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 200;
        int id = 6;

//        companyName = "%" + companyName + "%";
//        brandName = "%" +brandName + "%";

        Brand t = new Brand();
        //t.setBrandName(brandName);
        //t.setCompanyName(companyName);
        t.setStatus(status);
        t.setDescription(description);
        t.setOrdered(ordered);
        t.setId(id);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int cnt = brandMapper.update(t);
        //提交事务
        sqlSession.commit();


        //自动提交事务
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        brandMapper.add(t);

        System.out.println(cnt);

        sqlSession.close();
    }


    //根据id删除操作
    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 5;


        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int cnt = brandMapper.deleteById(id);
        //提交事务
        sqlSession.commit();

        System.out.println(cnt);

        sqlSession.close();
    }

    //根据id批量删除操作
    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] id = {5,6,7};


        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int cnt = brandMapper.deleteByIds(id);
        //提交事务
        sqlSession.commit();

        System.out.println(cnt);

        sqlSession.close();
    }

    //注解
    @Test
    public void testSelectById2() throws IOException {
        //假设从外界收到的id为
        int id = 1;

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();
    }
}
