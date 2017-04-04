package ua.airshop.dao.converters.goods;

import org.springframework.core.convert.converter.Converter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.service.entity.Goods;

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
