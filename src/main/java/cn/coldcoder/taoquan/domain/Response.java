package cn.coldcoder.taoquan.domain;

import java.io.Serializable;

/**
 * @Author: DX
 * @Description: error response
 * @Date: 2020/3/29 8:58
 * @Version: 1.0
 */
public class Response implements Serializable {
    private Object Data;
    private String message;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static Response create(String msg, Object data){
        Response response = new Response();
        response.setMessage(msg);
        response.setData(data);
        return response;
    }


}
