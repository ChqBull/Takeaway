package com.jk.controller.yfz;
import com.jk.bean.UohaBean;
import com.jk.service.yfz.UohaService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

@Controller
public class UohaController {

    @Autowired
    UohaService uohaService;

    /*财务信息查询*/
    @RequestMapping("findUohaList")
    @ResponseBody
    public HashMap<String, Object> findUohaList(Integer page, Integer rows, UohaBean uohaBean){
        HashMap<String,Object> hashMap = uohaService.findUohaList(page,rows,uohaBean);
        return hashMap;
    }
    /*删除*/
   /* @RequestMapping("deleteUoha")
    @ResponseBody
    public Boolean deleteUoha(Integer id) {
        try {
            uohaService.deleteUoha(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
    /*导出财务报表*/
    @RequestMapping("ExcelDownloadsPoi")
    public void download(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        /*CompanyModel companyModel = (CompanyModel) session.getAttribute(session.getId());*/
        Integer companyId = 1;

        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        HSSFSheet sheet = workbook.createSheet("用户表");

        //创建表头
        setTitle(workbook, sheet);
        List<UohaBean> li = uohaService.getWithdrawalRecordsIop(companyId);

        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (UohaBean uohaBean:li) {
            HSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(uohaBean.getOrderNum());
            row.createCell(1).setCellValue(uohaBean.getStoreName());
            row.createCell(2).setCellValue(uohaBean.getOrderStartTime());
            row.createCell(3).setCellValue(uohaBean.getRealName());
            row.createCell(4).setCellValue(uohaBean.getAddress());
            row.createCell(5).setCellValue(uohaBean.getHorsemanName());
            row.createCell(6).setCellValue(uohaBean.getOrderMoney());

            rowNum++;
        }
        String fileName = "WithdrawalRecords.xls";
        //清空response

        response.reset();
        //设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename="+ fileName);
        OutputStream os = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        //将excel写入到输出流中
        workbook.write(os);
        os.flush();
        os.close();
    }

    /***
     * 设置表头
     * @param workbook
     * @param sheet
     */
    private void setTitle(HSSFWorkbook workbook, HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度

        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("订单号");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("商家名称");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("订单日期");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("用户姓名");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("送餐地址");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("配送骑手");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("订单金额");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("审核状态");
        cell.setCellStyle(style);
    }


}
