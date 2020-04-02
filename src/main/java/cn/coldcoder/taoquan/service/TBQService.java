package cn.coldcoder.taoquan.service;

import cn.coldcoder.taoquan.domain.Response;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkContentGetRequest;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkShopGetRequest;
import com.taobao.api.response.TbkContentGetResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkShopGetResponse;
import org.springframework.stereotype.Service;

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

    public String getProdId(String itemid);





}
