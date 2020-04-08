package cn.coldcoder.taoquan.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DX
 * @Description: 配置文件
 * @Date: 2020/4/4 17:54
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "tqconfig")
@Component
public class TQConfig {
    //显示商品图标的类型
    private String type_icon1;
    private String type_icon2;

    //商品详情分享时的title
    private List<String> detail_share_title;

    //首页被分享时候的title
    private String index_share_title;

    //物料id及其描述
    private List<Material> materials;

    //banner及其对应guideimages
    private List<Banner> banners;



    public String getType_icon1() {
        return type_icon1;
    }

    public void setType_icon1(String type_icon1) {
        this.type_icon1 = type_icon1;
    }

    public String getType_icon2() {
        return type_icon2;
    }

    public void setType_icon2(String type_icon2) {
        this.type_icon2 = type_icon2;
    }

    public List<String> getDetail_share_title() {
        return detail_share_title;
    }

    public void setDetail_share_title(List<String> detail_share_title) {
        this.detail_share_title = detail_share_title;
    }

    public String getIndex_share_title() {
        return index_share_title;
    }

    public void setIndex_share_title(String index_share_title) {
        this.index_share_title = index_share_title;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
