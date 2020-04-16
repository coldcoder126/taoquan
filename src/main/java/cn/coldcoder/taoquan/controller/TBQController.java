package cn.coldcoder.taoquan.controller;


import cn.coldcoder.taoquan.domain.TQConfig;
import cn.coldcoder.taoquan.domain.Material;
import cn.coldcoder.taoquan.domain.Page;

import cn.coldcoder.taoquan.domain.Response;
import cn.coldcoder.taoquan.service.TBQService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DX
 * @Description: 所有关于淘券的请求都请求这里
 * @Date: 2020/3/26 11:31
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "zmlh/taobao/")
public class TBQController {
    @Autowired
    private TBQService tbqService;
    @Autowired
    private TQConfig tqConfig;

    @RequestMapping(value = "search/prod/{pageNum}/{keyword}",method = RequestMethod.GET)
    public String searchProd(@PathVariable(value = "keyword") String keyword,
                             @PathVariable(value = "pageNum") int pageNum){
        String result = tbqService.searchBykeyword(keyword,pageNum);
        while(StringUtils.equals(StringUtils.substring(result,2,7),"error")){
            result=tbqService.searchBykeyword(keyword,pageNum);
        }
       return result;
    }

    @RequestMapping(value = "get/officalselected/{pageNum}/{materialId}")
    public String getOfficalSelected(@PathVariable(value = "pageNum") int pageNum,
                                     @PathVariable(value = "materialId") int materialId){

        return tbqService.getOfficalSelected(pageNum,materialId);
    }

    @RequestMapping(value = "get/taotoken/{url}")
    public Response getTaoToken(@PathVariable(value = "url") String url){
        return tbqService.getTaoToken(url);

    }

    @RequestMapping(value = "getpid/{itemid}")
    public String getProdId(@PathVariable (value = "itemid") String itemid){
        return tbqService.getProdId(itemid);
    }




    @RequestMapping(value = "get/config")
    public TQConfig getConfig(){
        return tqConfig;
    }
}
