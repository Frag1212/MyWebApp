package ru.anton.mywebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("first/")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value="name", required=false) String name,
                            @RequestParam(value="surname", required=false) String surname,
                            Model model)
    {
        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);


        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int aint,//@RequestParam("a") String a,
                                 @RequestParam("b") String b,
                                 @RequestParam("action") String action,
                                 Model model)
    {
        //System.out.println("Controller start");
        //try{
            //int aint = Integer.parseInt(a);
            int bint = Integer.parseInt(b);
            Integer result = null;
            if("multiplication".equals(action))
                result = aint * bint;
            else if("addition".equals(action))
                result = aint + bint;
            else if("subtraction".equals(action))
                result = aint - bint;
            else if("division".equals(action))
                result = aint / bint;
            if(result != null)
                model.addAttribute("calculationResult", result);
        /*}
        catch(Exception ignore)
        {}*/

        return "first/calculator";
    }
}
