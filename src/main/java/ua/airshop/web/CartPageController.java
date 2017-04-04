package ua.airshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartPageController {

    @RequestMapping(value = "/cartpage", method = RequestMethod.GET)
    public String getCart() {
        return "cart";
    }
}
