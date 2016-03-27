package ua.airshop.web;

import org.springframework.web.bind.annotation.*;
import ua.airshop.logic.goods.Goods;
import ua.airshop.logic.goods.GoodsManager;
import ua.airshop.logic.goods.Group;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Resource(name = "GoodsManagerImpl")
    GoodsManager goodsManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Goods> values() {
        return goodsManager.getAllGoods();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Goods create(@RequestBody Goods goods) {
        goodsManager.addGoods(goods);

        return goods;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Goods update(@RequestBody Goods goods) {
        goodsManager.updateGoods(goods);
        return goods;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        goodsManager.removeGoods(id);
        return id;
    }
}
