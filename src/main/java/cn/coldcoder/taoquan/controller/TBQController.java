package cn.coldcoder.taoquan.controller;


import cn.coldcoder.taoquan.domain.Config;
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
@RequestMapping(value = "taoquan")
public class TBQController {
    @Autowired
    private TBQService tbqService;

    @RequestMapping(value = "search/prod/{pageNum}/{keyword}",method = RequestMethod.GET)
    public String getOfficalSelected(@PathVariable(value = "keyword") String keyword,
                                     @PathVariable(value = "pageNum") int pageNum){
        String result = tbqService.searchBykeyword(keyword,pageNum);
        while(StringUtils.equals(StringUtils.substring(result,2,7),"error")){
            result=tbqService.searchBykeyword(keyword,pageNum);
        }
       return result;
    }

    @RequestMapping(value = "get/materialId")
    public List<Material> getMaterialId(){
        List<Material> list = new ArrayList<>();
        list.add(new Material(28027,"综合"));
        list.add(new Material(4093,"服饰"));
        list.add(new Material(13369,"数码家电"));
        list.add(new Material(27798,"家居家装"));
        list.add(new Material(3761,"食品"));
        list.add(new Material(3763,"美妆个护"));
        list.add(new Material(27454,"母婴"));

        return list;
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

    @RequestMapping(value = "get/banners")
    public List<String> getBanners(){
        List<String> list= new ArrayList<String>();
        String banner1 = "//img.alicdn.com/i1/2201188731272/O1CN010dPWX61LGcLysrN9d_!!2201188731272.jpg";
        String banner2 = "//img.alicdn.com/i1/2201188731272/O1CN01hyjchT1LGcM2CPSqP_!!2201188731272.jpg";
        String banner3 = "//img.alicdn.com/i3/2201188731272/O1CN01gc5MwC1LGcM0SrOhi_!!2201188731272.jpg";
        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        return list;
    }

    @RequestMapping(value = "get/guide/{index}")
    public List<String> getGuide(@PathVariable(value = "index")int index){

        String page1_img1="//img.alicdn.com/i1/1030582371/O1CN01yyvgae1TNxf6kYHpH_!!1030582371.jpg";
        String page1_img2="//img.alicdn.com/i3/1030582371/O1CN015BY3x01TNxfA8kJgB_!!1030582371.jpg";
        String page1_img3="//img.alicdn.com/i3/1030582371/O1CN019gqUlp1TNxf2p6u5U_!!1030582371.jpg";
        String page1_img4="//img.alicdn.com/i3/1030582371/O1CN017ZnNoo1TNxf1UM6Ct_!!1030582371.jpg";
        if(index==0)
        return  Page.creat(page1_img1,page1_img2,page1_img3,page1_img4);


        String page2_img1="//img.alicdn.com/i3/720250651/O1CN01wLCZ5J1GgCLop4jDr_!!720250651.jpg";
        String page2_img2="//img.alicdn.com/i2/720250651/TB2pznWbYGYBuNjy0FoXXciBFXa_!!720250651.png";
        String page2_img3="//img.alicdn.com/i3/720250651/O1CN01xyagpO1GgCMYBIAmf_!!720250651.jpg";
        String page2_img4="//img.alicdn.com/i3/720250651/O1CN010ozvTu1GgCLqcmbXo_!!720250651.jpg";
        return Page.creat(page2_img1,page2_img2,page2_img3,page2_img4);
    }

    @RequestMapping(value = "get/config")
    public Config getConfig(){
        Config conf = new Config();
        conf.setType_icon1("/static/images/pdd.png");
        conf.setType_icon2("/static/images/jd.png");
        return conf;
    }
}