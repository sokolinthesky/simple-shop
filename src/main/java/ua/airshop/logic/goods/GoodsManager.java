package ua.airshop.logic.goods;

import java.util.List;

public interface GoodsManager {
    Group getRootGroup();
    void addGroup(Group group);
    void updateGroup(String name);
    void removeGroup(String id);
    Group getById(String id);

    Goods getGoodsById(String id);
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void removeGoods(String id);
    List<Goods> getAllGoods();
}
