package com.example.demo.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.AppOutletDAO;
import com.example.demo.dao.AppUserDAO;
import com.example.demo.entity.AppOutlet;
import com.example.demo.utils.WebUtils;

import io.github.ccincharge.newsapi.NewsApi;
import io.github.ccincharge.newsapi.datamodels.Article;
import io.github.ccincharge.newsapi.requests.RequestBuilder;
import io.github.ccincharge.newsapi.responses.ApiArticlesResponse;
 
@Controller
public class MainController {
    
    @Autowired
    private AppUserDAO appUserDAO;
	
    
    //Do I need this for the main app
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "adminPage";
    }
    
    //needed
    @RequestMapping(value = { "/", "/welcome", "/login" }, method = RequestMethod.GET)
    public String loginPage(Model model) {
    	
        return "loginPage";
    }
    
    //needed
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
    
    //needed
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal, Model m) {
    	
    	
        // After user login successfully.
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
        
        
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        
        return "userInfoPage";
    }
    
    @RequestMapping(value = "/curated", method = RequestMethod.GET)
    public String userInfo(Model model) {
    
        
        List<AppOutlet> outlets = this.appUserDAO.findUserSelectedOutlets();
        
		NewsApi newsApi = new NewsApi("08608b2e91f94ed39a37ecb896e32312");
		RequestBuilder Request = new RequestBuilder();
		ArrayList<Article> all = new ArrayList<Article>();
        
        for (AppOutlet outlet : outlets) {
        	Request.setSources(outlet.getOutletName());
        	ApiArticlesResponse ArticlesResponse = newsApi.sendTopRequest(Request);
        	all.addAll( ArticlesResponse.articles());
        };
        
        model.addAttribute("articles", all);
        model.addAttribute("time", LocalDateTime.now().toString().substring(11, 19));
        
       
        
        System.out.println(LocalDateTime.now().toString().substring(11, 19));
       
        
        return "curatedPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
 
}