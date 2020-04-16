package cn.coldcoder.taoquan.service;

/**
 * @Author: DX
 * @Description: 拼多多service接口
 * @Date: 2020/4/12 15:04
 * @Version: 1.0
 */
public interface PDDService {
    String getThemeList();

    String getTopList();

    String getQRCode(String goods_id,String p_id);

    String getPromotionUrl(String goods_id,String search_id);

    String getGoodsDetail(String goods_id,String search_id);

    String searchGoodsByKeyword(String keyword,int isBrand, int withCoupon,int pageNum,String listId);

    String searchGoodsById(String goods_id);

    String getSelected(int pageNum,int is_brand,int with_coupon);

    String getRecommend(int channel_type,int pageNum);

    String getThemePromUrl();

    String getPromToolUrl(int channel_type);

}
