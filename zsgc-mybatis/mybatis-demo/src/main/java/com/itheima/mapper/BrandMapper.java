package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BrandMapper {
    //蓝色是接口，红色是映射文件
    List<Brand> selectAll();

    /**
     * 查看详情
     * 编写mapper接口
     * 传入id，根据id查询
     * 返回类型：Brand
     * 编写sql语句，sql映射文件
     * test测试
    */
    Brand selectById(int id);

    /**
     * 条件查询
     * 编写mapper接口
     * 传入查询条件，根据条件查询
     * 返回类型：List<Brand>
     * 编写sql语句，sql映射文件
     * test测试
     *
     * 散装参数的格式
     * @Param(" sql语句里面#{}（即参数占位符名称）对应的内容用后面对应传入的参数来填入  ") 类型 名称
     * 例如  sql里面有#{status} 你在方法传参某一参数前加 @Param("Status") 就代表这个参数要对应  #{status}
     *
     * 对象参数
     * 对象属性名称要和参数占位符一致
     *
     * 集合参数
     *
     * 三种方式都可以
     */
    //散装参数的格式
    //List<Brand> selectByCondition(@Param("status")int status,@Param("companyName") String companyName,@Param("brandName") String brandName);

    //对象参数
    //List<Brand> selectByCondition(Brand brand);

    //集合传参
    //List<Brand> selectByCondition(Map map);

    //多条件动态查询
    List<Brand> selectByCondition(Map map);

    //单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    //增加操作
    void add(Brand brand);

    //修改操作
    int update(Brand brand);

    //根据id删除
    int deleteById(int id);

    int deleteByIds(@Param("ids") int[] ids);

    /**
     * MyBatis 参数封装:
     * *单个参数:
     * 1.P0J0类型:直接使用，属性名和参数占位符名称一致
     * 2.Map集合:直接使用，键名和参数占位符名称 一致
     * 3.Collection:封装为Map集合，可以使用Param注解，替换Map集合中默认的arg键名
     * map.put("arg",collection集合);
     * map.put("collection",collection集合);
     * 4.List:封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
     * map.put("arg",list集合);
     * map.put("collection",list集合);
     * map.put("list",list集合);
     * 5.Array:封装为Map集合，可以使用@Param注解，替换Map集合中默认的arq键名
     * map.put("arg",数组);
     * map.put("array",数组);
     * 6.其他类型:直接使用多个参数:封装为Map集合,可以使用@Param注解，替换Map集合中默认的arg键名
     * *多个参数:直接使用多个参数:封装为Map集合,可以使用@Param注解，替换Map集合中默认的arg键名
     *
     *
     *
     * 综上，除了pojo类和map和基本数据类型，都用@Parma注解的写法
     */

    /**
     * 注解，只用于简单的功能
     * 复杂的功能还是用xml映射文件更好
     * @Select
     * @Insert
     * @Update
     * @Delete
     * 一共四个
     * 注解例子:
     */
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById2(int id);
}













