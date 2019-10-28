package com.qf.realm;

import com.qf.pojo.User;
import com.qf.service.PermissionService;
import com.qf.service.RoleService;
import com.qf.service.UserService;
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


@Setter
public class MyRealm  extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("从realm中查询...");
        //  获取当前用户名
        String username =(String) principals.getPrimaryPrincipal();

        // RoleService roleService = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl",RoleService.class);
        // PermissionService permissionService = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        //查询用户的权限/角色信息
        Set<String> role = roleService.queryAllRoleByUsername(username); // 查询用户角色
        Set<String> permisson = permissionService.querypermissionByUsername(username);// 查询用户权限
        // 封装查询信息

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(role);
        simpleAuthorizationInfo.setStringPermissions(permisson);
        return simpleAuthorizationInfo;
    }






    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取客户端传来的用户名
        String  username =(String) token.getPrincipal();
        // 查询
        User user = userService.selectUserByName(username);
        if (user==null){
            return null;
        }
        // 将用户信息封装到 AuthenticationInfo

         return new SimpleAuthenticationInfo(
                         user.getUsername(),
                         user.getPassword(),
                         ByteSource.Util.bytes(user.getSolt()),
                            this.getName()
         );
    }
}
