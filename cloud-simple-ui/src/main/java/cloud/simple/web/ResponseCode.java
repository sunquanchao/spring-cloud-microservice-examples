package cloud.simple.web;

import net.sf.json.JSON;

import java.io.Serializable;

/**
 * @author Mackchao.Sun
 * @class:Response
 * @description: TODO
 * @date:2020/5/12 16:51
 **/
public class Response<T> implements Serializable {
    private int code;
    private String message;
    private T result;

    public Response() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public Response(ResponseCode reponseCode) {
        this.code = reponseCode.getCode();
        this.message = reponseCode.getMessage();
    }

    public Response(ResponseCode reponseCode, String message) {
        this.code = reponseCode.getCode();
        this.message = message;
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response<T> success(T result) {
        this.code = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
        this.result = result;
        return this;
    }

    public Response<T> failed(int code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public Response<T> failed(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        String resultStr = this.result == null ? "" : JSON.toJSONString(this.result);
        if (resultStr.length() > 4000) {
            resultStr = resultStr.substring(0, 4000) + "....";
        }

        return "Response.len=" + resultStr.length() + ",,code=" + this.code + ",,message=" + this.message + ",,result=" + resultStr;
    }
}
