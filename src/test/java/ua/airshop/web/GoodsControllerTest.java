package ua.airshop.web;

import org.junit.Test;
import ua.airshop.dao.implementations.GoodsDaoImpl;
import ua.airshop.logic.goods.Goods;

public class GoodsControllerTest {

    @Test
    public void testCreate() throws Exception {
        Goods goods = new Goods();
        goods.setId("777");
        goods.setName("test");
        goods.setDescription("test");
        goods.setPrice(10);

        //GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        //goodsDao.addGoods(goods);
    }
}