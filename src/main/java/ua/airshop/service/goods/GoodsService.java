package ua.airshop.service.goods;

import ua.airshop.service.entity.Goods;

import java.util.List;

public interface GoodsService {

    Goods getGoodsById(String id);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void removeGoods(String id);

    List<Goods> getAllGoods();
}
