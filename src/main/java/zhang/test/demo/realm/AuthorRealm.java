package com.zhang.test.demo.realm;

import com.zhang.test.demo.service.AuthorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 15939 on 2017/12/21.
 *
 * @author xiaohei
 * @date 2017/12/21 18:21
 */
public class AuthorRealm extends AuthorizingRealm{

    @Autowired
    AuthorService authorService;

    /**
     * 方法说明：用户授权
     * @Date：2017/12/26 10:30
     * @Author：xiaohei
     * @param: 
     * @return: 
     * 修改记录：
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 方法说明：登陆认证
     * @Date：2017/12/26 10:28
     * @Author：xiaohei
     * @param: 
     * @return: 
     * 修改记录：
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        String username = uToken.getUsername();
        return null;
    }
}
