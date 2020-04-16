package cn.coldcoder.taoquan.service.ServiceImpl;

import cn.coldcoder.taoquan.service.PDDService;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.request.*;
import com.pdd.pop.sdk.http.api.response.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/4/12 15:05
 * @Version: 1.0
 */
@Service
public class PDDServiceImpl implements PDDService {
    String clientId = "01002d67373140c6ae70e02e5cb4eec4";
    String clientSecret = "f579295b49d89c0d55407578d2ec2f9911aa4693";
    String pId = "10162072_137110956";
    PopClient client = new PopHttpClient(clientId, clientSecret);

    @Override
    public String getThemeList() {
        PddDdkThemeListGetRequest request = new PddDdkThemeListGetRequest();
        request.setPage(1);
        request.setPageSize(20);
        PddDdkThemeListGetResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getTopList() {
        PddDdkTopGoodsListQueryRequest request = new PddDdkTopGoodsListQueryRequest();
        request.setLimit(30);
        //request.setListId("");
        request.setOffset(0);
        request.setPId("10162072_137110956");
        request.setSortType(2);
        PddDdkTopGoodsListQueryResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getQRCode(String goods_id, String p_id) {
        PddDdkWeappQrcodeUrlGenRequest request = new PddDdkWeappQrcodeUrlGenRequest();
        request.setGenerateMallCollectCoupon(true);
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(Long.parseLong(goods_id));
        request.setGoodsIdList(goodsIdList);
        request.setPId(p_id);
        PddDdkWeappQrcodeUrlGenResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getPromotionUrl(String goods_id,String search_id) {
        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        request.setCustomParameters("str");
        request.setGenerateMallCollectCoupon(false);
        request.setGenerateQqApp(false);
        request.setGenerateSchemaUrl(false);
        request.setGenerateShortUrl(false);
        request.setGenerateWeappWebview(false);
        request.setGenerateWeiboappWebview(false);
        request.setGenerateWeApp(true);
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(Long.parseLong(goods_id));
        request.setGoodsIdList(goodsIdList);
        request.setMultiGroup(false);
        request.setPId(pId);
        request.setSearchId(search_id);
        PddDdkGoodsPromotionUrlGenerateResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getGoodsDetail(String goods_id, String search_id) {
        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        request.setCustomParameters("str");
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(Long.parseLong(goods_id));
        request.setGoodsIdList(goodsIdList);
        request.setPid(pId);
        request.setPlanType(0);
        request.setSearchId(search_id);
        PddDdkGoodsDetailResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String searchGoodsByKeyword(String keyword,int isBrand, int withCoupon,int pageNum,String listId) {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        List<Integer> activityTags = new ArrayList<Integer>();
        activityTags.add(0);
        request.setActivityTags(activityTags);
        request.setIsBrandGoods(isBrand==1);
        request.setKeyword(keyword);
        request.setListId(listId);
        request.setPage(pageNum);
        request.setPageSize(30);
        request.setPid(pId);
        request.setSortType(0);
        request.setWithCoupon(withCoupon==1);
        PddDdkGoodsSearchResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String searchGoodsById(String goods_id) {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        List<Long> goodsIdList = new ArrayList<Long>();
        goodsIdList.add(Long.parseLong(goods_id));
        request.setGoodsIdList(goodsIdList);
        request.setPage(1);
        request.setPageSize(30);
        request.setPid(pId);
        PddDdkGoodsSearchResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getSelected(int pageNum, int is_brand, int with_coupon) {
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        request.setIsBrandGoods(is_brand==1);
        request.setPage(pageNum);
        request.setPageSize(30);
        request.setPid(pId);
        request.setWithCoupon(with_coupon==1);
        PddDdkGoodsSearchResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getRecommend(int channel_type, int pageNum) {
        PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
        request.setChannelType(channel_type);
        request.setCustomParameters("str");
        request.setLimit(30);
        request.setListId("str");
        request.setOffset(30*(pageNum-1));
        request.setPid(pId);
        PddDdkGoodsRecommendGetResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getThemePromUrl() {
        PddDdkThemePromUrlGenerateRequest request = new PddDdkThemePromUrlGenerateRequest();
        request.setGenerateMobile(false);
        request.setGenerateQqApp(false);
        request.setGenerateSchemaUrl(false);
        request.setGenerateShortUrl(false);
        request.setGenerateWeappWebview(false);
        request.setGenerateWeApp(false);
        request.setPid(pId);
        List<Long> themeIdList = new ArrayList<Long>();
        themeIdList.add(1L);
        request.setThemeIdList(themeIdList);
        PddDdkThemePromUrlGenerateResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }

    @Override
    public String getPromToolUrl(int channel_type) {
        PddDdkRpPromUrlGenerateRequest request = new PddDdkRpPromUrlGenerateRequest();
        request.setChannelType(channel_type);

        request.setGenerateQqApp(false);
        request.setGenerateSchemaUrl(false);
        request.setGenerateShortUrl(false);
        request.setGenerateWeApp(true);
        List<String> pIdList = new ArrayList<String>();
        pIdList.add(pId);
        request.setPIdList(pIdList);
        PddDdkRpPromUrlGenerateResponse response = null;
        try {
            response = client.syncInvoke(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtil.transferToJson(response);
    }
}
