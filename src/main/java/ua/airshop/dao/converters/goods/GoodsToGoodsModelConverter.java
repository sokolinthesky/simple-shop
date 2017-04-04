package ua.airshop.dao.converters.goods;

import org.springframework.core.convert.converter.Converter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.service.entity.Goods;

public class GoodsToGoodsModelConverter implements Converter<Goods, GoodsModel> {
    @Override
    public GoodsModel convert(Goods goods) {
        GoodsModel model = new GoodsModel();
        model.setId(goods.getId());
        model.setName(goods.getName());
        model.setDescription(goods.getDescription());
        model.setPrice(goods.getPrice());
        return model;
    }
}
