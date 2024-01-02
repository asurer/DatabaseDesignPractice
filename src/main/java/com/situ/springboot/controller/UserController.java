package com.situ.springboot.controller;
import com.situ.springboot.pojo.entity.User;
import com.situ.springboot.service.IUserService;
import com.situ.springboot.util.PageInfo;
import com.situ.springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user_login";
    }

    @RequestMapping("/login")
    @ResponseBody //返回json格式数据
    public Result login(String name, String password, String code, HttpSession session) {
        //先验证验证码对不对，验证码正确再验证用户名密码是否正确
        //如果验证码不对，直接返回错误，后面也不需要执行
        String codeInSession = (String)session.getAttribute("codeInSession");
        if(!codeInSession.equalsIgnoreCase(code)) {
            return Result.error("验证码错误");
        }
        //根据name和password查这个用户有没有
        User user = userService.login(name, password);
        if(user != null) {
            if (user.getStatus() == 0) {
                //这个用户禁用
                return Result.error("该用户已经禁用");
            }
            //如果有代表登录成功，跳转到首页
            //将用户的登陆凭证发到Session，Session可以理解为当前用户的会话
            //一个用户对应一个session
            session.setAttribute("user", user);
    //        Result result = new Result();
    //        result.setCode(0);
    //        result.setMsg("添加成功");
    //        return result;
            return Result.ok("登录成功");
//            return "redirect:/";
        }
        else {
            //登录失败，跳转到登录页面
//            return "redirect:/user/toLogin";
            return Result.error("用户名或密码错误");
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, Model model) {
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "user_update";
    }
    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user/selectAll";
    }
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user_add";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.add(user);
        return "redirect:/user/selectAll";
    }

    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        userService.deleteById(id);
        //删除完，显示最新数据
        return "redirect:/user/selectAll";
    }

    // http://localhost:8080/user/selectAll
    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        //soutm
        System.out.println("UserController.selectAll");
        List<User> list = userService.selectAll();
        //把list数据放到内存里
        model.addAttribute("list", list);
        //转发到user_list界面展示
        return "user_list";
    }
    @RequestMapping("/selectByPage")
    public String selectByPage(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize, Model model) {
        //soutm
        System.out.println("UserController.selectByPage");
        PageInfo pageInfo = userService.selectByPage(pageNo, pageSize);
        //把list数据放到内存里
        model.addAttribute("pageInfo", pageInfo);
        //转发到user_list界面展示
        return "user_list";
    }
    /*
    //@ResponseBody 返回json格式数据
    // http://localhost:8080/user/selectAll
    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll() {
        //soutm
        System.out.println("UserController.selectAll");
        List<User> list = userService.selectAll();

        //转发到user_list界面展示
        return "user_list";
    }
    */
}
