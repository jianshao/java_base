package com.jianshao.xxx.admin;

import com.jianshao.xxx.admin.common.entity.Result;
import com.jianshao.xxx.admin.tbuser.controller.TbUserReq;
import com.jianshao.xxx.admin.tbuser.entity.TbUserVo;
import com.jianshao.xxx.admin.tbuser.service.TbUserService;
import com.jianshao.xxx.admin.util.JwtUtil;
import com.jianshao.xxx.admin.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     */
    @PostMapping("login")
    public Result<String> login(@RequestBody TbUserVo entityVo){
        //只关注用户名、密码
        if(StringUtils.isEmpty(entityVo.getUsername()) || StringUtils.isEmpty(entityVo.getPassword())){
            return Result.build(400,"账号或密码不能为空......","");
        }
        TbUserReq tbUserReq = new TbUserReq();
        TbUserVo tbUserVo = new TbUserVo();
        tbUserVo.setUsername(entityVo.getUsername());
        //密码MD5加密后密文存储，匹配时先MD5加密后匹配
        tbUserVo.setPassword(MD5Util.getMD5(entityVo.getPassword()));
        List<TbUserVo> listResult = tbUserService.list(tbUserReq);
        if(listResult.size() > 0){
            TbUserVo userVo = listResult.get(0);

            //token
            String token = JwtUtil.sign(userVo.getId()+"");

            return Result.build(Result.OK,"登录成功！",token);
        }
        return Result.build(400,"账号或密码错误...","");
    }

    /**
     * 登出
     */
    @PostMapping("logout")
    public Result<String> logout(HttpServletResponse response){
        //清除cookie
        Cookie cookie = new Cookie("PORTAL_TOKEN", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return Result.build(Result.OK,"此路是我开，此树是我栽，要从此路过，留下token令牌！","");
    }

    /**
     * 通过token令牌获取登录用户
     */
    @PostMapping("getUserByToken")
    public Result<TbUserVo> getUserByToken(@RequestBody TbUserVo entityVo){
        String userId = JwtUtil.getUserIdByToken(entityVo.getToken());
        TbUserVo result = tbUserService.get(userId);
        result.setPassword(null);
        return userId == null ? Result.build(500,"操作失败！",new TbUserVo()) : Result.build(result);
    }
}
