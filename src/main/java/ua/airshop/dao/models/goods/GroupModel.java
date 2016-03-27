package ua.airshop.dao.models.goods;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @OrderBy
    private List<GroupModel> groupModels;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private GroupModel groupModel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    @OrderBy
    private List<GoodsModel> goodsList;

    public GroupModel(){}

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

    public List<GroupModel> getGroupModels() {
        return groupModels;
    }

    public void setGroupModels(List<GroupModel> groupModels) {
        this.groupModels = groupModels;
    }

    public GroupModel getGroupModel() {
        return groupModel;
    }

    public void setGroupModel(GroupModel groupModel) {
        this.groupModel = groupModel;
    }

    public List<GoodsModel> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsModel> goodsList) {
        this.goodsList = goodsList;
    }
}
