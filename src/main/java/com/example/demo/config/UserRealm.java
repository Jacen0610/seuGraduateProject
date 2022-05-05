package com.example.demo.config;

import com.example.demo.pojo.User;
import com.example.demo.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo SAInfo = new SimpleAuthorizationInfo();



        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();

        SAInfo.addStringPermission(currentUser.getCapacity());

        return SAInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        User user = userService.getUserById(userToken.getUsername());
        if(user==null){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
