package ua.airshop.logic.cart;

import ua.airshop.logic.goods.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart {

    private int totalPrice;

    private Map<String, BuyItem> buyItemMap = new HashMap<>();
    private AtomicInteger ids = new AtomicInteger(0);

    public void addItem(Goods goods/*, int amount*/) {
        BuyItem buyItem = new BuyItem();
        buyItem.setGoods(goods);
        buyItem.setId(Integer.toString(ids.incrementAndGet()));
        this.buyItemMap.put(buyItem.getId(), buyItem);
        /*buyItem.setAmount(amount);*/
    }

    public int getTotalPrice() {
        int totalPrice =0;
        for(BuyItem buyItem : this.buyItemMap.values()){
            totalPrice += buyItem.getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<String, BuyItem> getBuyItemMap() {
        return buyItemMap;
    }

    public void setBuyItemMap(Map<String, BuyItem> buyItemMap) {
        this.buyItemMap = buyItemMap;
    }
}
