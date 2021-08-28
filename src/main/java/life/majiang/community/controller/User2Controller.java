package life.majiang.community.controller;
import life.majiang.community.mapper.User2Mapper;
import life.majiang.community.model.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * @author zyq
 * @description
 * @create 2021/6/3
 **/
@Controller
public class User2Controller {
    @Autowired
    private User2Mapper user2Mapper;
    @GetMapping("/registers")
    public String register(){
        //页面
        return "register" ;
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam(value = "name") String name, @RequestParam(value ="password") String password){
        User2 user2 = user2Mapper.isRegister(name);
        if (user2 == null) {
            user2Mapper.register(name,password);
            return "login";
        }else {
            return "register";
        }
    }
    @GetMapping("/logins")
    public String logins() {
        return "login";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        User2 user2 = user2Mapper.isRegister(name);
        if (name.equals(user2.getName())&& password.equals(user2.getPassword())){
            return  "redirect:/";
        }else {
            return "register";
        }
    }
}
