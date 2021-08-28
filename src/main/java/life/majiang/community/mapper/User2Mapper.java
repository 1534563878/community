package life.majiang.community.mapper;

import life.majiang.community.model.User2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author zyq
 * @description
 * @create 2021/6/3
 **/
@Mapper
public interface User2Mapper {
    @Select("select * from user2 where name = #{name}")
    User2 isRegister(@Param("name") String name);
    @Insert("INSERT INTO user2(NAME ,PASSWORD) VALUES(#{name},#{password})")
    void register(@Param("name") String name, @Param("password") String password);

}
