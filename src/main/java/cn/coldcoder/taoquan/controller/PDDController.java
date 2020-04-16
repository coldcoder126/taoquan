package cn.coldcoder.taoquan.controller;

import cn.coldcoder.taoquan.service.PDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/4/12 15:04
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "pdd/")
public class PDDController {
    @Autowired
    private PDDService pddService;

    @RequestMapping(value = "get/themelist")
    public String getThemeList(){
        return pddService.getThemeList();
    }

    @RequestMapping(value = "get/toplist")
    public String getTopList(){
        return pddService.getTopList();
    }

    //获取单个商品推广的小程序码，不可用
    @RequestMapping(value = "get/qrcode/{goods_id}/{p_id}")
    public String getQRCode(@PathVariable(value = "goods_id") String goods_id,
                            @PathVariable(value = "p_id") String p_id){
        return pddService.getQRCode(goods_id,p_id);
    }

    @RequestMapping(value = "get/purchase/{goods_id}/{search_id}")
    public String getPurchaseUrl(@PathVariable(value = "goods_id") String goods_id,
                                 @PathVariable(value = "search_id",required = false) String search_id){
        return pddService.getPromotionUrl(goods_id,search_id);
    }

    //获取商品详情
    @RequestMapping(value = "get/goods/detail/{goods_id}/{search_id}")
    public String getGoodsDetail(@PathVariable(value = "goods_id") String goods_id,
                                 @PathVariable(value = "search_id")String srarch_id){
        return pddService.getGoodsDetail(goods_id,srarch_id);
    }

    //获取销售火爆的作为主页推荐商品显示
    @RequestMapping(value = "get/selected/{pageNum}/{is_brand}/{with_coupon}")
    public String getSelected(@PathVariable(value = "pageNum") int pageNum,
                              @PathVariable(value = "is_brand") int is_brand,
                              @PathVariable(value = "with_coupon") int with_coupon){
        return pddService.getSelected(pageNum,is_brand,with_coupon);
    }

    //获取官方推广的三种活动
    @RequestMapping(value = "get/recommend/{channel_type}/{pageNum}")
    public String getRecommend(@PathVariable(value = "channel_type") int channel_type,
                               @PathVariable(value = "pageNum") int pageNum){
        return pddService.getRecommend(channel_type,pageNum);
    }

    //获取营销主题
    @RequestMapping(value = "get/theme/prom")
    public String getThemeProm(){
        return pddService.getThemePromUrl();
    }

    //获取推广链接工具url(主要是获取红包等玩法)
    @RequestMapping(value = "get/prom/toolurl/{channel_type}")
    public String getPromToolUrl(@PathVariable(value = "channel_type") int channel_type ){
        return pddService.getPromToolUrl(channel_type);
    }

    @RequestMapping(value = "search/goods/{keyword}/{isBrand}/{withCoupon}/{pageNum}/{listId}")
    public String searchGoodsByKeyword(@PathVariable(value = "keyword") String keyword,
                              @PathVariable(value = "isBrand") int isBrand,
                              @PathVariable(value = "withCoupon") int withCoupon,
                              @PathVariable(value = "pageNum") int pageNum,
                              @PathVariable(value = "listId",required = false) String listId){
        return pddService.searchGoodsByKeyword(keyword,isBrand,withCoupon,pageNum,listId);
    }


    @RequestMapping(value = "search/goods_id/{goodsId}")
    public String searchGoodsById(@PathVariable(value = "goodsId") String goodsId){
        return pddService.searchGoodsById(goodsId);
    }
}
