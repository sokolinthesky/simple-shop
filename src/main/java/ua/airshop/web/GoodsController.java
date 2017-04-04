package ua.airshop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.airshop.service.entity.Goods;
import ua.airshop.service.goods.GoodsService;

import java.util.Collection;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Goods> getAll() {
        return goodsService.getAllGoods();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Goods create(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return goods;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Goods update(@RequestBody Goods goods) {
        goodsService.updateGoods(goods);
        return goods;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id) {
        goodsService.removeGoods(id);
        return id;
    }
}
