package cn.coldcoder.taoquan.domain;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/3/31 16:18
 * @Version: 1.0
 */
public class Material {
    private int id;
    private String description;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
