package ua.airshop.service.entity;

public class BuyItem {
    private String id;
    private Goods goods;
    private int amount = 1;

    public int getPrice() {
        return getGoods().getPrice() * amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
