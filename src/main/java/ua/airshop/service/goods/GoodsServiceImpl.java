package ua.airshop.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.airshop.dao.GoodsDao;
import ua.airshop.service.entity.Goods;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public void removeGoods(String id) {
        goodsDao.removeGoods(id);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    public Goods getGoodsById(String id) {
        throw new UnsupportedOperationException();
    }

}
