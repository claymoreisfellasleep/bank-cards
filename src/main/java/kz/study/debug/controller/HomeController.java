package kz.study.debug.controller;

import kz.study.debug.model.Card;
import kz.study.debug.model.User;
import kz.study.debug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String signinPage(){
        return "signin";
    }

    @GetMapping(value = "/sign-up-page")
    public String signupPage(){
        return "signup";
    }

    @GetMapping(value = "/test-page")
    public String testPage(){
        return "test-page";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/add-card-page")
    public String addcardPage(){
        return "add-card";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDenied(){
        return "403";
    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage(){
        return "update-password";
    }

    @PostMapping(value = "to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName){
        if(password.equals(repeatPassword)){
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if(newUser != null){
                return "redirect:/sign-up-page?success";
            }else{
                return "redirect:/sign-up-page?emailerror";
            }
        }else{
            return "redirect:/sign-up-page?passworderror";
        }
    }

    @PostMapping(value = "to-update-password")
    public String toUpdatePassword(
                            @RequestParam(name = "user_old_password") String oldPassword,
                            @RequestParam(name = "user_new_password") String newPassword,
                            @RequestParam(name = "user_repeat_new_password") String repeatNewPassword){
        if(newPassword.equals(repeatNewPassword)){
            User user = userService.updatePassword(newPassword, oldPassword);
            if(user!=null){
                return "redirect:/update-password-page?success";
            }else{
                return "redirect:/update-password-page?oldpassworderror";
            }
        }else{
            return "redirect:/update-password-page?passwordmismatch";
        }
    }
//
//    @PostMapping(value = "add-card")
//    public String addCard(@RequestParam(name = "card_amount") int amount,
//                           @RequestParam(name = "card_name") String name,
//                           @RequestParam(name = "card_number") String number){
//        Card card = new Card();
//        card.setName(name);
//        card.setNumber(number);
//        card.setAmount(amount);
//        Card newCard = userService.addCard(card);
//
//    }
}
