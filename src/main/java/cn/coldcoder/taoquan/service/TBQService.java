package cn.coldcoder.taoquan.service;

import cn.coldcoder.taoquan.domain.Response;

/**
 * @Author: DX
 * @Description: 淘宝券服务(TBQService)
 * @Date: 2020/3/26 15:24
 * @Version: 1.0
 */
public interface TBQService {

    String searchBykeyword(String keyword,int pageNum);

    String getOfficalSelected(int pageNum,int materialId);

    Response getTaoToken(String url);

    String getProdId(String itemid);

    String getFavoriteList();




}
