package com.sdh.realm;

import com.sdh.pojo.User;
import com.sdh.service.PermissionService;
import com.sdh.service.RoleService;
import com.sdh.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 17:22
 * @Version 1.0
 */
@Setter
@Getter
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        // 查询当前用户的权限信息
        Set<String> roles = roleService.queryAllRolenameByUsername(username);
        Set<String> perms = permissionService.queryAllPermissionByUsername(username);
        // 将查询出的信息 封装
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.queryUserByUsername(username);
        System.out.println(user);
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
    }
}
