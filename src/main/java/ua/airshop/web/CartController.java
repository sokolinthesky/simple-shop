package ua.airshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.airshop.logic.cart.BuyItem;
import ua.airshop.logic.cart.Cart;
import ua.airshop.logic.goods.Goods;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    private Cart cart = new Cart();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Cart ByuItems() {
        if(cart.getBuyItemMap().isEmpty()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("cart", this.cart);
            Goods goods = new Goods();
            goods.setId("777");
            goods.setName("test");
            goods.setDescription("test");
            goods.setPrice(12);
            cart.addItem(goods);
            cart.addItem(goods);
        }

        return cart;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Cart addBuyItem(@RequestBody Goods goods/*, int amount*/) {
        System.out.println("addItem method run");
        cart.addItem(goods/*,amount*/);
        return cart;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Cart deleteBuyItem(@PathVariable String id) {
        cart.getBuyItemMap().remove(id);
        return cart;
    }
}
