package ua.airshop.logic.goods;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component(value = "GoodsManagerImpl")
public class GoodsManagerImpl implements GoodsManager {

    @Resource
    GoodsDao goodsDao;
    @Resource
    GroupDao groupDao;

    public Group getRootGroup() {
        return groupDao.getRootGroup();
    }

    public void addGroup(Group group) {

    }

    public void updateGroup(String name) {

    }

    public void removeGroup(String id) {

    }

    @Override
    public Group getById(String id) {
        return groupDao.getById(id);
    }

    public Goods getGoodsById(String id) {
        return null;
    }

    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    public void removeGoods(String id) {
        goodsDao.removeGoods(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }
}
