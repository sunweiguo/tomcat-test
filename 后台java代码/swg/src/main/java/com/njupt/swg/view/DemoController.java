package com.njupt.swg.view;

import com.njupt.swg.common.Result;
import com.njupt.swg.pojo.UsernamePasswordPOJO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author swg.
 * @Date 2021/11/13 23:06
 * @CONTACT 317758022@qq.com
 * @DESC 登录接口、注册接口
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    Map<String,String> userMap = new HashMap<>();

    @RequestMapping("/test")
    public String test(){
        return "测试成功！";
    }

    @RequestMapping("/login")
    public Result login(UsernamePasswordPOJO usernamePasswordPOJO){
        String username = usernamePasswordPOJO.getUsername();
        String password = usernamePasswordPOJO.getPassword();
        //校验用户名密码是否正确
         return check(username,password);
    }

    @RequestMapping("/register")
    public Result register(UsernamePasswordPOJO usernamePasswordPOJO){
        String username = usernamePasswordPOJO.getUsername();
        String password = usernamePasswordPOJO.getPassword();
        if(userMap.containsKey(username)){
            return Result.error(500,"用户名已存在，请换一个",null);
        }
        userMap.put(username,password);
        return Result.success("恭喜你，注册成功",null);
    }

    private Result check(String username, String password) {
        if(username.equals("") || password.equals("")){
            return Result.error(500,"用户名或密码不能为空",null);
        }
        if(!userMap.containsKey(username)){
            return Result.error(500,"用户名不存在",null);
        }
        if(!userMap.get(username).equals(password)){
            return Result.error(500,"密码不正确",null);
        }
        return Result.success("登录成功",null);
    }


}
