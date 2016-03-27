package ua.airshop.dao.converters.goods;

import ua.airshop.dao.converters.Converter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.dao.models.goods.GroupModel;
import ua.airshop.logic.goods.Goods;
import ua.airshop.logic.goods.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupModelToGroupConverter implements Converter<GroupModel, Group> {
    @Override
    public Group convert(GroupModel groupModel) {
        Group group = new Group();
        group.setId(groupModel.getId());
        group.setName(groupModel.getName());

        List<Group> groups = new ArrayList<Group>();
        for(GroupModel model : groupModel.getGroupModels()) {
            groups.add(new GroupModelToGroupConverter().convert(model));
        }
        group.setChildrenGroups(groups);

        List<Goods> goodsList = new ArrayList<Goods>();
        for(GoodsModel model : groupModel.getGoodsList()) {
            goodsList.add(new GoodsModelToGoodsConverter().convert(model));
        }
        group.setGoodses(goodsList);

        return group;
    }
}
