package ua.airshop.dao.converters.goods;

import ua.airshop.dao.converters.Converter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.logic.goods.Goods;

public class GoodsModelToGoodsConverter implements Converter<GoodsModel, Goods> {
    @Override
     public Goods convert(GoodsModel goodsModel) {
        Goods goods = new Goods();
        goods.setId(goodsModel.getId());
        goods.setName(goodsModel.getName());
        goods.setDescription(goodsModel.getDescription());
        goods.setPrice(goodsModel.getPrice());
        return goods;
    }
}
