package ua.airshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ua.airshop.service.cart.CartService;
import ua.airshop.service.entity.BuyItem;
import ua.airshop.service.entity.Goods;

import java.util.Collection;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<BuyItem> buyItems() {
        return cartService.getByuItems();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addBuyItem(@RequestBody Goods goods) {
        cartService.addItem(goods);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBuyItem(@PathVariable String id) {
        cartService.removeBuyItem(id);
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public int totalPrice() {
        return cartService.getTotalPrice();
    }
}
