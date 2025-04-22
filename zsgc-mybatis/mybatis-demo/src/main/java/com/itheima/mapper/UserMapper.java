package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    //蓝色是接口，红色是映射文件
    List<User> selectAll();

    User selectById(int id);
    //点alt + enter 来生成
    //只要改别名和写入sql语句就行

}
