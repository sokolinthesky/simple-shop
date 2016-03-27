package ua.airshop.dao.implementations;
import org.junit.Test;
import ua.airshop.dao.models.goods.GroupModel;
import ua.airshop.logic.goods.Group;

public class GroupDaoImplTest {

    @Test
    public void testGetRootGroup() throws Exception {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        Group group = groupDao.getRootGroup();


    }
}