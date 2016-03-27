package ua.airshop.logic.goods;

public interface GroupDao {
    Group getRootGroup();
    void addGroup(Group group);
    void updateGroup(String name, String id);
    void removeGroup(String id);
    Group getById(String id);
}
