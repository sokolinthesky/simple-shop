package ua.airshop.logic.goods;

import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<Group> childrenGroups;
    private List<Goods> goodses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getChildrenGroups() {
        return childrenGroups;
    }

    public void setChildrenGroups(List<Group> childrenGroups) {
        this.childrenGroups = childrenGroups;
    }

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }
}
