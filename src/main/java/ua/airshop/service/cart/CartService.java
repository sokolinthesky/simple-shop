package ua.airshop.service.cart;

import ua.airshop.service.entity.BuyItem;
import ua.airshop.service.entity.Goods;

import java.util.Collection;

public interface CartService {

    Collection<BuyItem> getByuItems();

    void addItem(Goods goods);

    int getTotalPrice();

    void removeBuyItem(String id);
}
