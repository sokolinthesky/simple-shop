package ua.airshop.dao.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.airshop.dao.converters.goods.GroupModelToGroupConverter;
import ua.airshop.dao.converters.goods.GroupToGroupModelConverter;
import ua.airshop.dao.models.goods.GroupModel;
import ua.airshop.logic.goods.Group;
import ua.airshop.logic.goods.GroupDao;


@Service
public class GroupDaoImpl implements GroupDao {
    @Autowired
    HibernateTemplate template;

    private static final String ROOT_ID = "1";

    @Override
    public Group getRootGroup() {
        Group group = new GroupModelToGroupConverter().convert(template.get(GroupModel.class, ROOT_ID));
        return group;
    }

    @Transactional
    @Override
    public void addGroup(Group group) {
        template.save(new GroupToGroupModelConverter().convert(group));
    }

    @Transactional
    @Override
    public void updateGroup(String name, String id) {
        GroupModel groupModel = template.get(GroupModel.class, id);
        groupModel.setName(name);
        template.saveOrUpdate(groupModel);
    }

    @Transactional
    @Override
    public void removeGroup(String id) {
        template.delete(template.get(GroupModel.class, id));
    }

    @Transactional
    @Override
    public Group getById(String id) {
        return new GroupModelToGroupConverter().convert(template.get(GroupModel.class, id));
    }
}
