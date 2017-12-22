package com.zhang.test.demo.service;

import com.zhang.test.demo.dao.AuthorDao;
import com.zhang.test.demo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 15939 on 2017/12/21.
 *
 * @author xiaohei
 * @date 2017/12/21 14:53
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    /**
     * 方法说明：查询所有作者信息
     * @Date：2017/12/21 14:53
     * @Author：xiaohei
     * @param:
     * @return:
     * 修改记录：
     */
    public List<Author> queryAllAuthor(){
        return authorDao.queryAllAuthor();
    }
}
