package com.penn.mobile.auth;

import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/30.
 *
 * @Description: add a description
 * @CreateDate: 2018/1/30 15:03
 * @Version: 1.0
 */
@Controller
@RequestMapping("/system")
public class WxAuthController {

    private static Logger logger = Logger.getLogger(WxAuthController.class);

    public static final String TOKEN = "043pj8934t3pj398ru3jhto38";

    @RequestMapping("/auth.do")
    public void preDetail(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上，GET请求携带参数
            String signature = request.getParameter("signature");// 微信加密签名（token、timestamp、nonce。）
            String timestamp = request.getParameter("timestamp");// 时间戳
            String nonce = request.getParameter("nonce");// 随机数
            String echostr = request.getParameter("echostr");// 随机字符串
            PrintWriter out = response.getWriter();
            logger.info("---wx auth params:"+signature+","+timestamp+","+nonce+","+echostr);
            // 将token、timestamp、nonce三个参数进行字典序排序
            String[] params = new String[] { TOKEN, timestamp, nonce };
            Arrays.sort(params);
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            String clearText = params[0] + params[1] + params[2];
            String algorithm = "SHA-1";
            String sign = new String(
                    Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
            // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            if (signature.equals(sign)) {
                logger.info("---wx auth success!");
                response.getWriter().print(echostr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
