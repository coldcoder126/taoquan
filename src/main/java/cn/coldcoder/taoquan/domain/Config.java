package cn.coldcoder.taoquan.domain;

import java.util.List;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/4/4 17:54
 * @Version: 1.0
 */
public class Config {
    private String type_icon1;
    private String type_icon2;
    private List<String> detail_share_title;
    private String index_share_title;


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
}
