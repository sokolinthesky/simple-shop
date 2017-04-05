package ua.airshop.service.cart;

import org.springframework.stereotype.Service;
import ua.airshop.service.entity.BuyItem;
import ua.airshop.service.entity.Goods;

import java.util.*;

@Service
public class CartServiceInMemory implements CartService {
    private List<BuyItem> items = new ArrayList<>();

    @Override
    public void addItem(Goods goods) {
        BuyItem buyItem = new BuyItem();
        buyItem.setGoods(goods);
        buyItem.setId(UUID.randomUUID().toString());
        this.items.add(buyItem);
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for(BuyItem buyItem : this.items) {
            totalPrice += buyItem.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void removeBuyItem(String id) {
        for (BuyItem item : items) {
            if (item.getId().equals(id)) {
                items.remove(item);
                break;
            }
        }
    }

    @Override
    public List<BuyItem> getByuItems() {
        return this.items;
    }
}
