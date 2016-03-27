package ua.airshop.dao.converters.goods;

import ua.airshop.dao.converters.Converter;
import ua.airshop.dao.models.goods.GoodsModel;
import ua.airshop.dao.models.goods.GroupModel;
import ua.airshop.logic.goods.Goods;
import ua.airshop.logic.goods.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupToGroupModelConverter implements Converter<Group, GroupModel> {
    @Override
    public GroupModel convert(Group group) {
        GroupModel groupModel = new GroupModel();
        groupModel.setId(group.getId());
        groupModel.setName(group.getName());

        List<GroupModel> groupModelList = new ArrayList<GroupModel>();
        for(Group item : group.getChildrenGroups()) {
            groupModelList.add(new GroupToGroupModelConverter().convert(item));
        }
        groupModel.setGroupModels(groupModelList);

        List<GoodsModel> goodses = new ArrayList<GoodsModel>();
        for (Goods goods : group.getGoodses()) {
            goodses.add(new GoodsToGoodsModelConverter().convert(goods));
        }
        groupModel.setGoodsList(goodses);

        return groupModel;
    }
}
