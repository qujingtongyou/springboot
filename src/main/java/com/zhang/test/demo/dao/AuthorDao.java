package com.zhang.test.demo.dao;

import com.zhang.test.demo.entity.Author;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 15939 on 2017/12/21.
 *
 * @author xiaohei
 * @date 2017/12/21 14:48
 */
@Mapper
public interface AuthorDao {

    /**
     * 方法说明：查询所有作者信息
     * @Date：2017/12/21 14:53
     * @Author：xiaohei
     * @param: 
     * @return: 
     * 修改记录：
     */
    public List<Author> queryAllAuthor();
}
