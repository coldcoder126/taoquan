package cn.coldcoder.taoquan.domain;

import java.util.List;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/4/8 20:11
 * @Version: 1.0
 */
public class Banner {
    private String banner;
    private List<String> guide_imgs;

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<String> getGuide_imgs() {
        return guide_imgs;
    }

    public void setGuide_imgs(List<String> guide_imgs) {
        this.guide_imgs = guide_imgs;
    }
}
