package com.jk.server.chq;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.bean.Area;
import com.jk.bean.address;
import com.jk.bean.menuBean;
import com.jk.bean.menuType;
import com.jk.config.AlipayConfig;
import com.jk.mapper.chq.ChqMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChqServiceImpl implements ChqService {

    @Autowired
    ChqMapper chqMapper;


    @Override
    public List<Area> findArea() {
        List<Area> list =  chqMapper.findArea();
        return list;
    }

    @Override
    public List<menuType> findmenuType() {
        List<menuType> list =  chqMapper.findmenuType();
        return list;
    }
   //找到本店的所有菜品
    @Override
    public List<menuBean> findMenue(String id) {
        List<menuBean> list =  chqMapper.findMenue(id);
        return list;
    }
    //找到本店的菜单类型的菜
    @Override
    public List<menuBean> findMenuetypeId(String id, String typeId) {
        List<menuBean> list = new ArrayList<>();
        if("0".equals(typeId)){
          list =  chqMapper.findMenue(id);
        }else{
            list =  chqMapper.findMenuetypeId(id,typeId);
        }

        return list;
    }

    @Override
    public void ali(HttpServletResponse response, HttpServletRequest request) {
        //设置编码
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        Date date = new Date();
        String s = date.toString();
        String count =(String) request.getSession().getAttribute(s);
        String order_number = s;
        //付款金额，从前台获取，必填
        String total_amount = count;
        //订单名称，必填
        String subject = new String("支付宝沙箱支付（名称随便起）");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(aliPayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        out.println(result);//以下写自己的订单代码

    }

    @Override
    public void add(String area, String phoneNumber) {
        chqMapper.add(area,phoneNumber);
    }

    @Override
    public List<address> queryUserArea(String phoneNumber) {
        List<address> list =chqMapper.queryUserArea(phoneNumber);
        return list;
    }
}
