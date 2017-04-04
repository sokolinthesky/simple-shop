package ua.airshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.airshop.dao.converters.goods.GoodsModelToGoodsConverter;
import ua.airshop.dao.converters.goods.GoodsToGoodsModelConverter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.service.entity.Goods;
import ua.airshop.dao.GoodsDao;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public Goods getGoodsById(String id) {
        return null;
    }

    @Transactional
    @Override
    public void addGoods(Goods goods) {
        template.save(new GoodsToGoodsModelConverter().convert(goods));
    }

    @Transactional
    @Override
    public void updateGoods(Goods goods) {
        GoodsModel goodsModel = template.get(GoodsModel.class, goods.getId());
        goodsModel.setName(goods.getName());
        goodsModel.setDescription(goods.getDescription());
        goodsModel.setPrice(goods.getPrice());
        template.saveOrUpdate(goodsModel);

    }

    @Transactional
    @Override
    public void removeGoods(String id) {
        template.delete(template.get(GoodsModel.class, id));
    }

    @Override
    public List<Goods> getAllGoods() {
        List<GoodsModel> goodsModels = (List<GoodsModel>)this.template.find("from GoodsModel");
        List<Goods> goodses = new ArrayList<Goods>();
        for(GoodsModel model : goodsModels){
            goodses.add(new GoodsModelToGoodsConverter().convert(model));
        }
        return goodses;
    }
}
