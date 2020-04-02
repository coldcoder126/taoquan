package cn.coldcoder.taoquan.service.ServiceImpl;

import cn.coldcoder.taoquan.domain.Response;
import cn.coldcoder.taoquan.service.TBQService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkCouponGetRequest;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkCouponGetResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/3/28 13:26
 * @Version: 1.0
 */
@Service
public class TBQServiceImpl implements TBQService {
    String url = "http://gw.api.taobao.com/router/rest";
    String appkey="29100992";
    String secret="dddca6c6667da734c30abcf0a4fb6c63";
    Long id = Long.parseLong("110162750147");
    @Override
    public String searchBykeyword(String keyword,int pageNum) {


        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setPageSize(20L);
        req.setPageNo(Long.parseLong(String.valueOf(pageNum)));
        req.setPlatform(2L);
        req.setStartTkRate(100L);
        req.setHasCoupon(true);
        req.setSort("total_sales");
        req.setQ(keyword);
        req.setAdzoneId(id);
        TbkDgMaterialOptionalResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println("service");
        return rsp.getBody();
    }

    @Override
    public String getOfficalSelected(int pageNum,int materialId) {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
        req.setPageSize(20L);
        req.setAdzoneId(id);
        req.setPageNo(Long.parseLong(String.valueOf(pageNum)));
        req.setMaterialId(Long.parseLong(String.valueOf(materialId)));
        TbkDgOptimusMaterialResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return rsp.getBody();
    }

    @Override
    public Response getTaoToken(String dest_url) {
        int count = 0;
        String taotoken = "";
        String message = "出错啦";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        try {
            dest_url="https:"+java.net.URLDecoder.decode(dest_url, "UTF-8");
            System.out.println("new url");
            System.out.println(dest_url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        req.setUserId("1678872728");
        req.setText("淘口令：");
        req.setUrl(dest_url);

        TbkTpwdCreateResponse rsp = null;


            try {
                rsp = client.execute(req);
            } catch (ApiException e) {
                e.printStackTrace();
            }
        while (!rsp.getBody().toString().contains("￥")&&count<10){
//            如果不包含￥且请求次数小于10，则再次请求
            try {
                rsp = client.execute(req);
                count++;
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        if(rsp.getBody().toString().contains("￥")){
            message = "请复制这段文本，然后打开淘宝手机客户端：";
            taotoken = "￥"+StringUtils.substringBetween(rsp.getBody().toString(),"￥","￥")+"￥";
        }
        System.out.println(taotoken);

        return Response.create(message,taotoken);

    }
    public String getProdId(String itemid){
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkCouponGetRequest req = new TbkCouponGetRequest();
        //req.setMe("nfr%2BYTo2k1PX18gaNN%2BIPkIG2PadNYbBnwEsv6mRavWieOoOE3L9OdmbDSSyHbGxBAXjHpLKvZbL1320ML%2BCF5FRtW7N7yJ056Lgym4X01A%3D");
        req.setItemId(Long.parseLong("566932908065"));
        req.setActivityId("8d7b699d4e5b4a3494a7b98674a875a1");
        TbkCouponGetResponse rsp = null;
        try {
            rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return rsp.getBody();
    }


}
