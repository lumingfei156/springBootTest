package com.springboot.inter;

import com.springboot.entity.LearnBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lulu
 * @since 2018/12/10
 * mybatis中的DAO类，用来处理dao请求
 */
@Component(value = "learnResourceDAO")
public interface IlearnResourceDAO {
    /**
     * 新增方法
     * @param l l
     * @return l
     */
    @Insert("insert into learn_resource(author,title,url) values(#{author},#{title},#{url})")
    int add(LearnBean l);

    /**
     * 删除方法
     * @param ids s
     * @return s
     */
    @DeleteProvider(type = LearnSqlBuilder.class,method = "deleteByIds")
    int deleteByIds(@Param("ids") String[] ids);

    /**
     * 修改
     * @param l s
     * @return s
     */
    @Update("update learn_resource set author = #{author},title = #{title},url = #{url} where id = #{id}")
    int update(LearnBean l);

    /**
     * 查询
     * @param id s
     * @return s
     */
    @Select("select * from learn_resource where id = #{id}")
    @Results(
            id = "learnMap",value = {
            @Result(column = "id", property = "id", javaType = Integer.class),
            @Result(column = "author",property = "author",javaType = String.class),
            @Result(column = "title",property = "title",javaType = String.class),
            @Result(column = "url",property = "url",javaType = String.class)})
    LearnBean queryById(@Param("id") int id);

    /**
     * like查询
     * @param param s
     * @return s
     */
    @SelectProvider(type = LearnSqlBuilder.class,method = "queryByLike")
    List<LearnBean> queryByLike(Map<String,String> param);

    class LearnSqlBuilder{

        public String deleteByIds(@Param("ids") final String[] ids){
            StringBuilder sb = new StringBuilder();
            sb.append("delete from learn_resource where id in ( ");
            for (int i = 0;i < ids.length;i++){
                if(i == ids.length - 1){
                    sb.append(ids[i]);
                }else {
                    sb.append(ids[i]).append(",");
                }
            }
            sb.append(" )");
            return sb.toString();
        }


        public String queryByLike(Map<String,String> param){
            String author = "author";
            String title = "title";
            String url = "url";
            String nothing = " ";
            StringBuilder sb = new StringBuilder("select * from learn_resource where 1 = 1 ");

            if(null != param.get(author) && !nothing.equals(param.get(author).trim())){
                sb.append(" and author like '%").append(param.get(author)).append("%'");
            }

            if(null != param.get(title) && !nothing.equals(param.get(title).trim())){
                sb.append(" and title like '%").append(param.get(title)).append("%'");
            }

            if(null != param.get(url) && !nothing.equals(param.get(url).trim())){
                sb.append(" and url like '%").append(param.get(url)).append("%'");
            }
            return sb.toString();
        }
    }
}
