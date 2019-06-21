package com.jk.controller.chq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.bean.*;
import com.jk.config.AlipayConfig;
import com.jk.server.chq.ChqService;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient.Builder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class ChqController {
    @Autowired
     private ChqService service;

    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("findBusiness")
    @ResponseBody
    public HashMap<String , Object> findBusiness(Integer start,Integer pageSize , StoreBean storeBean) throws IOException, SolrServerException {
        Builder builder = new Builder("http://192.168.1.128:8983/solr/cmf");
        SolrClient solrClient = builder.build();
        SolrQuery query = new SolrQuery();
        //查询所有数据
        query.setQuery("*:*");
        //条件查询
        if(storeBean.getArea_id()!=null && storeBean.getArea_id().length()>0){

            query.setFilterQueries("area_id:"+storeBean.getArea_id());
        }

        if(storeBean.getStoreName() !=null && storeBean.getStoreName().length()>0) {
            //query.set("q","storeName:*"+storeBean.getStoreName()+"*" );
            query.setQuery("storeName:"+storeBean.getStoreName());

        }
        //目的是查的数据总数返回给前台
        QueryResponse queryResponse = solrClient.query(query);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println("_______"+results);
        //添加分页
        query.setStart(start);
        query.setRows(pageSize);

        //开启高亮
        query.setHighlight(true); // 开启高亮组件或用query.setParam("hl", "true");

        if(storeBean.getStoreName() !=null && storeBean.getStoreName().length()>0) {
            // query.setQuery("name:*"+name+"*"); // 设置查询关键字
            query.setQuery("storeName:"+storeBean.getStoreName()); // 设置查询关键字
            query.setFilterQueries("area_id:"+storeBean.getArea_id());
        }
     /*   if(storeBean.getArea_id()!=null && storeBean.getArea_id().length()>0){

            query.setQuery("area_id:"+storeBean.getArea_id());
        }*/




        query.addHighlightField("storeName");// 高亮字段
        query.setHighlightSimplePre("<font color='red'>");//标记，高亮关键字前缀
        query.setHighlightSimplePost("</font>");//后缀
        query.setHighlightFragsize(100);
        //拿到数据集合,返回查询结果
        QueryResponse queryResponse2 = solrClient.query(query);
        SolrDocumentList results1 = queryResponse2.getResults();

        List<StoreBean> list = queryResponse2.getBeans(StoreBean.class);
        System.out.println(list);
        //开始循环赋值
        Map<String, Map<String, List<String>>> map = queryResponse2.getHighlighting();
        for (int i = 0; i < results1.size(); ++i) {
            String id =  list.get(i).getId();
            if (map.get(id) != null && map.get(id).get("storeName") != null) {

                list.get(i).setStoreName(map.get(id).get("storeName").get(0));
            }
        }
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("total",results.size());
        objectObjectHashMap.put("rows",list);
        return objectObjectHashMap;
    }

    @RequestMapping("findArea")
    @ResponseBody
    public List<Area>  findArea(){
        List<Area> list = null;
        if(redisTemplate.opsForValue().get("findArea")!=null){
            String findArea = (String) redisTemplate.opsForValue().get("findArea");
            list =  JSONArray.parseArray(findArea,Area.class);
        }else{
            list = service.findArea();
            String s = JSON.toJSONString(list);
            redisTemplate.opsForValue().set("findArea",s);
        }
        return list;
    }

    @RequestMapping("goBusinessPage")
    public String goBusinessPage(){

        return "goBusinessPage";
    }

    //进店跳页面
  @RequestMapping("inStore")
   public String inStore(Model model,String id){
        model.addAttribute("id",id);
        return "StorePage";
  }
   //选择菜单的类型
   @RequestMapping("findmenuType")
   @ResponseBody
   public List<menuType>  findmenuType(){
       List<menuType> list = null;
       if(redisTemplate.opsForValue().get("findmenuType")!=null){
           String findmenuType = (String) redisTemplate.opsForValue().get("findmenuType");
           list =  JSONArray.parseArray(findmenuType,menuType.class);
       }else{
           list = service.findmenuType();
           String s = JSON.toJSONString(list);
           redisTemplate.opsForValue().set("findmenuType",s);
       }
       return list;
   }

    /**
     *
     * @param id 商店的编号
     * @param typeId 菜品类型的编号
     * @return
     */

 //找到本店的菜单名字
    @RequestMapping("findMenue")
    @ResponseBody
    public HashMap<String,Object> findMenue(String id,String typeId){
         List<menuBean> list = null;
        HashMap<String, Object> map = new HashMap<>();

        if(typeId==null || "0".equals(typeId)) {

            if (redisTemplate.opsForValue().get("findMenue"+id) != null) {
                String findMenue = (String) redisTemplate.opsForValue().get("findMenue"+id);
                list = JSONArray.parseArray(findMenue, menuBean.class);
            } else {
                list = service.findMenue(id);
                String s = JSON.toJSONString(list);
                redisTemplate.opsForValue().set("findMenue"+id,s);
            }

        }else {
            if (redisTemplate.opsForValue().get("findMenue" +id+typeId) != null){

                String findMenuetypeId = (String) redisTemplate.opsForValue().get("findMenue"+id+typeId);
                list = JSONArray.parseArray(findMenuetypeId, menuBean.class);

            }else {
                list = service.findMenuetypeId(id,typeId);
                String s = JSON.toJSONString(list);
                redisTemplate.opsForValue().set("findMenue"+id +typeId,s);
            }
        }
            map.put("total",list.size());
            map.put("rows",list);

             return map;
    }

   //跳转到购物车的页面
   @RequestMapping("toShopCarPage")
   public  String toShopCarPage(Model model,String id) {
       model.addAttribute("id",id);
       return "toShopCarPage";
   }
   //加入购物车

    /**
     *
     * @param id 这是菜单的id
     *           storeid 商店的Id
     * @param request
     * @return
     */
    @RequestMapping("addShopCar")
    @ResponseBody
    public String addShopCar(String id , HttpServletRequest request,String storeid){
        UserBean user =(UserBean) request.getSession().getAttribute("user");
           //获取redis的K值也就是手机号
           String phoneNumber = user.getPhoneNumber();
           //首先去判断有没有这个购物车
           if(redisTemplate.hasKey(phoneNumber)){
               String menu = (String)redisTemplate.opsForValue().get(phoneNumber);
               List<menuBean> list = JSON.parseArray(menu, menuBean.class);
               boolean isExist = false;
                //然后判断的是有没有
               for(menuBean menuBean : list)
               {
                   if(id.equals(menuBean.getId()))
                   {
                       isExist = true;
                       menuBean.setNumber(menuBean.getNumber()+1);
                       break;
                   }
               }
                //如果他不存在该商品
                 if(!isExist){
                     String findMenue = (String) redisTemplate.opsForValue().get("findMenue"+storeid);
                     List<menuBean> list2 = JSONArray.parseArray(findMenue, menuBean.class);
                     for(menuBean menuBean : list2)
                     {
                         if(id.equals(menuBean.getId()))
                         {
                             //获取到菜品的对象
                             menuBean menuBean2 = menuBean;
                             menuBean2.setNumber(1);
                             //把这个菜品添加到对象中
                             list.add(menuBean2);
                         }
                     }

                 }
               // 把新的list重新存进去redis
               String s = JSON.toJSONString(list);
               redisTemplate.opsForValue().set(phoneNumber,s);
                     return  null;
           }else{
                  //说明我并没有这个k值
               String findMenue = (String) redisTemplate.opsForValue().get("findMenue"+storeid);
               List<menuBean> list2 = JSONArray.parseArray(findMenue, menuBean.class);
               List<menuBean> list = new ArrayList<>();
               for(menuBean menuBean : list2)
               {
                   if(id.equals(menuBean.getId()))
                   {
                       //获取到菜品的对象
                       menuBean menuBean2 = menuBean;
                       menuBean2.setNumber(1);
                       list.add(menuBean2);
                       String s = JSON.toJSONString(list);
                       redisTemplate.opsForValue().set(phoneNumber,s);
                   }
               }
               //缓存过期1天
               redisTemplate.expire(phoneNumber,60*60*24*1, TimeUnit.SECONDS);

               return  null;
           }
    }
    @RequestMapping("queryShopCarMenu")
    @ResponseBody
       //查询购物车的商品
        public HashMap<String,Object> queryShopCarMenu(HttpServletRequest request){
                 HashMap<String,Object> map = new HashMap<>();
        UserBean user = (UserBean) request.getSession().getAttribute("user");
        String phoneNumber = user.getPhoneNumber();
                 String s = (String)redisTemplate.opsForValue().get(phoneNumber);
                 List<menuBean> objects = JSON.parseArray(s, menuBean.class);
                        map.put("rows",objects);
                        map.put("total",objects.size());
                              return map;
        }


     //删除我不要的菜品

    /**
     *
     * @param id 我要删除购物车的菜品id
     * @param request
     * @return
     */
    @RequestMapping("deleteMenuById")
    @ResponseBody
   public  String deleteMenuById(String id,HttpServletRequest request){
        UserBean user =(UserBean)request.getSession().getAttribute("user");
        String phoneNumber = user.getPhoneNumber();
        String menu =(String) redisTemplate.opsForValue().get(phoneNumber);
        List<menuBean> list = JSON.parseArray(menu, menuBean.class);

        for(menuBean menuBean:list)
        {
            if(id.equals(menuBean.getId()))
            {
                //获取到菜品的对象
                menuBean menuBean2 = menuBean;
                //把这个菜品添加到对象中
                 list.remove(menuBean2);
                 break;
            }
        }
        String s = JSON.toJSONString(list);
        redisTemplate.opsForValue().set(phoneNumber,s);
               return null;
    }
    //显示出支付金额
    @RequestMapping("zhifuCount")
    @ResponseBody
      public String zhifuCount(HttpServletRequest request){
        UserBean user =(UserBean)request.getSession().getAttribute("user");
        String phoneNumber = user.getPhoneNumber();
        String menu =(String) redisTemplate.opsForValue().get(phoneNumber);
        List<menuBean> list = JSON.parseArray(menu, menuBean.class);
        String count = "";
        float jine=0;
          for (menuBean menuBean:list){
              String price = menuBean.getPrice();
              int number = menuBean.getNumber();
              float i = Float.parseFloat(price);
              jine += number * i;
          }
            count = jine+"";
           request.getSession().setAttribute("count",jine);
        return count;
    }

    //支付接口

    /**
     *
     * @param request
     * @param response
     * @param price
     * @param id 是商户的id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String goAlipay(HttpServletRequest request, HttpServletRequest response,String price,String id,String msg,String area) throws Exception {


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        Date date = new Date();
        long dateTime = date.getTime();
        //付款金额，必填
        String total_amount = price;
        //订单名称，必填
        String subject = "2016093000627977";
        //商品描述，可空
        String body = "";

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ dateTime +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("返回页面"+ result);
        //新增地址，新增订单，
            //out_trade_no订单号；
            //userId;
            //商户的id；
           String storeid= id;
           String ids = "";
        String numbers = "";
        UserBean user =(UserBean) request.getSession().getAttribute("user");
        String phoneNumber = user.getPhoneNumber();
        String s = (String)redisTemplate.opsForValue().get(phoneNumber);
        List<menuBean> list = JSON.parseArray(s, menuBean.class);
           for(menuBean menuBean :list){
              ids += menuBean.getId()+",";
                numbers += menuBean.getNumber()+",";
           }
        Integer id2 = user.getId();
        service.addOrder(dateTime,id2,storeid,price,msg,area,ids,numbers);



        return result;
    }

    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        response.setContentType("text/html;charset=utf-8");

        boolean verifyResult = rsaCheckV1(request);
        if(verifyResult){
            //验证成功
            //请在这里加上商户的业务逻辑程序代码，如保存支付宝交易号
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            String ids = (String) request.getSession().getAttribute("ids");
            if(!StringUtils.isEmpty(ids)){
                String[] split = ids.split(",");
                for (String s : split) {

                }
            }
            return "redirect:view";

        }else{
            return "redirect:error";

        }
    }
    @RequestMapping("toView")
    public String view(String viewName){
        return viewName;
    }
    public boolean rsaCheckV1(HttpServletRequest request){
        // https://docs.open.alipay.com/54/106370
        // 获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        try {
            boolean verifyResult = AlipaySignature.rsaCheckV1(params,
                    AlipayConfig.merchant_private_key,
                    AlipayConfig.charset,
                    AlipayConfig.sign_type);

            return verifyResult;
        } catch (AlipayApiException e) {

            return true;
        }
    }
    @RequestMapping("view")
    public String view(){
        return "hah";
    }

    @RequestMapping("notify")
    public String notify(HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        // 一定要验签，防止黑客篡改参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder notifyBuild = new StringBuilder("/****************************** alipay notify ******************************/\n");
        parameterMap.forEach((key, value) -> notifyBuild.append(key + "=" + value[0] + "\n") );
//        log.info(notifyBuild.toString());


        boolean flag = this.rsaCheckV1(request);
        if (flag) {
            /**
             * TODO 需要严格按照如下描述校验通知数据的正确性
             *
             * 商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
             * 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
             * 同时需要校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
             *
             * 上述有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
             * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
             * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
             */

            //交易状态
            String tradeStatus = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            // TRADE_FINISHED(表示交易已经成功结束，并不能再对该交易做后续操作);
            // TRADE_SUCCESS(表示交易已经成功结束，可以对该交易做后续操作，如：分润、退款等);
            if(tradeStatus.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
                // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //如果签约的是可退款协议，退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
                //如果没有签约可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。
            } else if (tradeStatus.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，
                // 并判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），并执行商户的业务程序
                //请务必判断请求时的total_fee、seller_id与通知时获取的total_fee、seller_id为一致的
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //如果签约的是可退款协议，那么付款完成后，支付宝系统发送该交易状态通知。

            }

            return "redirect:view";
        }

        return "redirect:view";
    }

     //新增地址
        @RequestMapping("add")
        @ResponseBody
        public String add(String area,HttpServletRequest request){
        UserBean user =(UserBean) request.getSession().getAttribute("user");
       // String phoneNumber = user.getPhoneNumber();
            Integer id = user.getId();
            service.add(area,id);
            return null;
       }
     //查看用户地址
    @RequestMapping("queryUserArea")
    @ResponseBody
    public List<address> queryUserArea(HttpServletRequest request){
        UserBean user =(UserBean) request.getSession().getAttribute("user");
        Integer id = user.getId();
        List<address> list = service.queryUserArea(id);
        return list;
    }

    @RequestMapping("chakanxiangqing")
    public String chakanxiangqing(Integer id,Integer storeid){

        return "redirect:menu"+id+".html";
    };

}
