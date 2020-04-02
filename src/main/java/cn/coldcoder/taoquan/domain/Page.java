package cn.coldcoder.taoquan.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DX
 * @Description:
 * @Date: 2020/4/1 17:35
 * @Version: 1.0
 */
public class Page {
    public static List<String> creat(String ... imgUrls){
        List<String> list = new ArrayList<String>();
        for (String imgUrl : imgUrls)
            list.add(imgUrl);
        return list;
    }

}
