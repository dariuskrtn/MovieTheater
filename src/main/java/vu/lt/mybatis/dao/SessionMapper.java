package vu.lt.mybatis.dao;

import org.mybatis.cdi.Mapper;
import vu.lt.mybatis.model.Session;

import java.util.List;

@Mapper
public interface SessionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SESSION
     *
     * @mbg.generated Tue May 05 13:09:24 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SESSION
     *
     * @mbg.generated Tue May 05 13:09:24 EEST 2020
     */
    int insert(Session record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SESSION
     *
     * @mbg.generated Tue May 05 13:09:24 EEST 2020
     */
    Session selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SESSION
     *
     * @mbg.generated Tue May 05 13:09:24 EEST 2020
     */
    List<Session> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SESSION
     *
     * @mbg.generated Tue May 05 13:09:24 EEST 2020
     */
    int updateByPrimaryKey(Session record);
}