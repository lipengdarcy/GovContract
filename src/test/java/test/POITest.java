package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Font;

public class POITest {

	@SuppressWarnings("deprecation")
	public void outExcel(String fundsType, Date tradeDate, String assetsTypeCode) {

		HSSFWorkbook wb = new HSSFWorkbook(); // --->创建了一个excel文件
		HSSFSheet sheet = wb.createSheet("理财资金报表"); // --->创建了一个工作簿
		HSSFDataFormat format = wb.createDataFormat(); // --->单元格内容格式
		sheet.setColumnWidth((short) 3, 20 * 256); // ---》设置单元格宽度，因为一个单元格宽度定了那么下面多有的单元格高度都确定了所以这个方法是sheet的
		sheet.setColumnWidth((short) 4, 20 * 256); // --->第一个参数是指哪个单元格，第二个参数是单元格的宽度
		sheet.setDefaultRowHeight((short) 300); // ---->有得时候你想设置统一单元格的高度，就用这个方法

		// 样式
		HSSFCellStyle style = wb.createCellStyle(); // 样式对象
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		// 设置标题字体格式
		Font font = wb.createFont();
		// 设置字体样式
		font.setFontHeightInPoints((short) 20); // --->设置字体大小
		font.setFontName("Courier New"); // ---》设置字体，是什么类型例如：宋体
		font.setItalic(true); // --->设置是否是加粗
		style.setFont(font); // --->将字体格式加入到style1中
		// style1.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
		// style1.setFillPattern(CellStyle.SOLID_FOREGROUND);设置单元格颜色

		// 样式1
		HSSFCellStyle style1 = wb.createCellStyle(); // 样式对象
		style1.setWrapText(true); // 设置是否能够换行，能够换行为true
		style1.setBorderBottom((short) 1); // 设置下划线，参数是黑线的宽度
		style1.setBorderLeft((short) 1); // 设置左边框
		style1.setBorderRight((short) 1); // 设置有边框
		style1.setBorderTop((short) 1); // 设置下边框
		style1.setDataFormat(format.getFormat("￥#,##0")); // --->设置为单元格内容为货币格式

		style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%")); // --->设置单元格内容为百分数格式

		// 表格第一行
		HSSFRow row1 = sheet.createRow(0); // --->创建一行
		// 四个参数分别是：起始行，起始列，结束行，结束列
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 15));
		row1.setHeightInPoints(25);
		HSSFCell cell1 = row1.createCell((short) 0); // --->创建一个单元格

		cell1.setCellStyle(style);
		cell1.setCellValue("总公司资金运用日报明细表（理财资金）");

		// 表格第二行
		// 样式2
		HSSFCellStyle style2 = wb.createCellStyle(); // 样式对象
		sheet.addMergedRegion(new Region(1, (short) 0, 1, (short) 15));
		HSSFRow row2 = sheet.createRow(1);
		HSSFCell cell2 = row2.createCell((short) 0);
		cell2.setCellValue("报告日期：" + new Date());
		cell2.setCellStyle(style1);

		// 表格第三行
		sheet.addMergedRegion(new Region(2, (short) 0, 2, (short) 15));
		HSSFRow row3 = sheet.createRow(2);
		HSSFCell cell3 = row3.createCell((short) 0);
		cell3.setCellValue("交易日期：" + new Date());
		cell3.setCellStyle(style2);

		// 表格第四行
		sheet.addMergedRegion(new Region(3, (short) 0, 3, (short) 2));
		HSSFRow row4 = sheet.createRow(3);
		row4.setHeightInPoints((short) 75);
		HSSFCell cell4 = row4.createCell((short) 0);
		HSSFCell cell4_0_1 = row4.createCell((short) 1);
		cell4_0_1.setCellStyle(style2);
		HSSFCell cell4_0_2 = row4.createCell((short) 2);
		cell4_0_2.setCellStyle(style2);
		cell4.setCellStyle(style1);
		cell4.setCellValue("代码/品种");

		HSSFCell cell4_1 = row4.createCell((short) 3);
		cell4_1.setCellStyle(style1);
		cell4_1.setCellValue("投资类型");

		HSSFCell cell4_2 = row4.createCell((short) 4);
		cell4_2.setCellStyle(style1);
		cell4_2.setCellValue("证券账户");

		HSSFCell cell4_3 = row4.createCell((short) 5);
		cell4_3.setCellStyle(style1);
		cell4_3.setCellValue("份额\n单位：元");

		HSSFCell cell4_4 = row4.createCell((short) 6);
		cell4_4.setCellStyle(style1);
		cell4_4.setCellValue("结转总成本\n单位：元");

		HSSFCell cell4_5 = row4.createCell((short) 7);
		cell4_5.setCellStyle(style1);
		cell4_5.setCellValue("总市值\n单位：元");

		HSSFCell cell4_6 = row4.createCell((short) 8);
		cell4_6.setCellStyle(style1);
		cell4_6.setCellValue("结转成本价\n单位：元");

		HSSFCell cell4_7 = row4.createCell((short) 9);
		cell4_7.setCellStyle(style1);
		cell4_7.setCellValue("市价\n单位：元");

		HSSFCell cell4_8 = row4.createCell((short) 10);
		cell4_8.setCellStyle(style1);
		cell4_8.setCellValue("持有期收益\n单位：%");

		HSSFCell cell4_9 = row4.createCell((short) 11);
		cell4_9.setCellStyle(style1);
		cell4_9.setCellValue("总收益率(总收益/结转总成本)\n单位：%");

		HSSFCell cell4_10 = row4.createCell((short) 12);
		cell4_10.setCellStyle(style1);
		cell4_10.setCellValue("前一日涨跌幅\n单位：%");

		HSSFCell cell4_11 = row4.createCell((short) 13);
		cell4_11.setCellStyle(style1);
		cell4_11.setCellValue("盈亏\n单位：元");

		HSSFCell cell4_12 = row4.createCell((short) 14);
		cell4_12.setCellStyle(style1);
		cell4_12.setCellValue("以实现收益\n单位：元");

		HSSFCell cell4_13 = row4.createCell((short) 15);
		cell4_13.setCellStyle(style1);
		cell4_13.setCellValue("浮盈（亏）+已实现收益\n单位：元");

		// 第五行
		sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 2));
		HSSFRow row5 = sheet.createRow(4);
		HSSFCell cell5 = row5.createCell((short) 0);
		HSSFCell cell5_1 = row5.createCell((short) 1);
		cell5_1.setCellStyle(style2);
		HSSFCell cell5_2 = row5.createCell((short) 2);
		cell5_2.setCellStyle(style2);
		cell5.setCellValue("投资资产合计");
		cell5.setCellStyle(style2);

		// 第六行
		sheet.addMergedRegion(new Region(5, (short) 0, 5, (short) 2));
		HSSFRow row6 = sheet.createRow(5);
		HSSFCell cell6 = row6.createCell((short) 0);
		HSSFCell cell6_1 = row6.createCell((short) 1);
		cell6_1.setCellStyle(style2);
		HSSFCell cell6_2 = row6.createCell((short) 2);
		cell6_2.setCellStyle(style2);
		cell6.setCellValue("2、股票");
		cell6.setCellStyle(style2);

		// 第七行
		sheet.addMergedRegion(new Region(6, (short) 0, 6, (short) 2));
		HSSFRow row7 = sheet.createRow(6);
		HSSFCell cell7 = row7.createCell((short) 0);
		HSSFCell cell7_1 = row7.createCell((short) 1);
		cell7_1.setCellStyle(style2);
		HSSFCell cell7_2 = row7.createCell((short) 2);
		cell7_2.setCellStyle(style2);
		cell7.setCellValue("2.1、境内A股");
		cell7.setCellStyle(style2);

		// 第八行
		sheet.addMergedRegion(new Region(7, (short) 0, 7, (short) 2));
		HSSFRow row8 = sheet.createRow(7);
		HSSFCell cell8 = row8.createCell((short) 0);
		HSSFCell cell8_1 = row8.createCell((short) 1);
		cell8_1.setCellStyle(style2);
		HSSFCell cell8_2 = row8.createCell((short) 2);
		cell8_2.setCellStyle(style2);
		cell8.setCellValue("非限售股");
		cell8.setCellStyle(style2);

		try {

			HSSFRow rowN = sheet.createRow(8); // 第9行...第n行
			List<String> list = new ArrayList<String>(); // 存放每一行数据
			for (int i = 1; i <= 16; i++) {
				list.add("testString" + i);
			}

			for (int k = 0; k < 16; k++) {
				if (k < 5) {
					HSSFCell cellN = rowN.createCell((short) k);
					cellN.setCellStyle(style1);
					cellN.setCellValue(list.get(k));
				}
				if ((k >= 5 && k <= 9) || (k >= 13)) {
					HSSFCell cellN = rowN.createCell((short) k);
					cellN.setCellStyle(style1);
					cellN.setCellValue(Double.parseDouble(list.get(k)));
				}
				if (k >= 10 && k <= 12) {
					HSSFCell cellN = rowN.createCell((short) k);
					cellN.setCellStyle(style1);
					cellN.setCellValue(Double.parseDouble(list.get(k)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("d:\\workbook.xls");
			wb.write(fileOut);
			// fileOut.close();
			System.out.print("OK");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
