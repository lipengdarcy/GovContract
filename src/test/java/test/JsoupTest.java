package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.witsafe.framework.common.Constant;
import com.witsafe.framework.common.util.HtmlUtil;
import com.witsafe.model.Nationstandard;
import com.witsafe.model.NationstandardWithBLOBs;
import com.witsafe.service.NationstandardService;

public class JsoupTest implements Runnable {
	
	public static void main(String[] args) throws IOException, ParseException {

		String type_all = "C51,C52,C57,C60,C62,C65,C66,C67,C68,C69,C70,C71,C72,C73,C75,C77,C78,C80,C83,C85,B09,D09,E09,F09,G09,H09,J09,K09,L09,M09,N09,P09,Q09,R09,S09,T09,U09,V09,W09,X09,Y09";
		String[] typeArray = type_all.split(",");
		for (int i = 0; i < typeArray.length; i++) {			
			JsoupTest test = new JsoupTest();
			test.setType(typeArray[i]);
			Thread t = new Thread(test);
			try {
				Thread.sleep(1000);
				t.start();
			} catch (InterruptedException e) {

			}
		}
	}
	
	private String type;	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public static Nationstandard getNationstandard(String url)
			throws IOException, ParseException {
		// 标准详情
		NationstandardWithBLOBs standard = new NationstandardWithBLOBs();
		Document doc = Jsoup.connect(url).get();
		// 标准号
		String standardno = doc.select("h3").get(0).html();
		standardno = HtmlUtil.delHTMLTag(standardno);
		standard.setStandardno(standardno);
		// 中文题名， 英文题名
		String nameCh = doc.select(".dl-horizontal-more").select("dd").get(0)
				.html();
		String nameEn = doc.select(".dl-horizontal-more").select("dd").get(1)
				.html();
		standard.setNameCh(nameCh);
		standard.setNameEn(nameEn);
		// 发布日期，实施日期
		String publishDate = doc.select(".detailBox:has(.icon_info)")
				.select("dd").get(0).html().replaceAll("发布日期：", "");
		String effectDate = doc.select(".detailBox:has(.icon_info)")
				.select("dd").get(1).html().replaceAll("实施日期：", "");
		standard.setPublishDate(Constant.formatDate.parse(publishDate));
		standard.setEffectDate(Constant.formatDate.parse(effectDate));
		// 适用范围
		String validRange = doc.select(".detailBox:has(.icon_scope)")
				.select("dd").get(0).html();
		validRange = HtmlUtil.delHTMLTag(validRange);
		standard.setValidRange(validRange);
		// 代替标准号
		String standardnoReplace = doc.select(".detailBox:has(.icon_assoc)")
				.select("dd").get(0).select("dd").select("a").html();
		standardnoReplace = HtmlUtil.delHTMLTag(standardnoReplace);
		standard.setStandardnoReplace(standardnoReplace);
		// 中国标准分类, 国际标准分类,
		String typeCh = doc.select("#getCcsCn").get(0).html();
		String typeIso = doc.select("#getIcsCn").get(0).html();
		standard.setTypeCh(typeCh);
		standard.setTypeIso(typeIso);
		return standard;

	}

	public static void getISOStandard() throws IOException, ParseException {
		Document doc_en = null, doc = null;

		String posturl = "http://www.cssn.net.cn/ds?ns=nvsearch&URI=search_base&SERVICE=SevAdvanceSearch";
		String geturl = "http://www.cssn.net.cn/pagesnew/search/search_base_result.jsp?pi=1&iPageSizeSle=2000&flag=null&location=null";
		// 国际标准分类（ICS）：13.100
		Connection conn_en = Jsoup.connect(posturl);
		conn_en.data("paixu", "asc");
		conn_en.data("orderby", "sort_number");
		conn_en.data("en_typenum", "职业安全、工业卫生+");
		conn_en.data("in_stan_typenum", "13.100");
		conn_en.data("bzstatus", "xxk");
		doc_en = conn_en.post();
		// 保存文件
		// FileOutputStream fos = new FileOutputStream("D:/ICS_13.100.html",
		// true);
		// fos.write(doc_en.html().getBytes());
		// fos.close();

		// 读取文件
		File f = new File("D:/ICS_all.html");
		doc = Jsoup.parse(f, "UTF-8");

		Elements ListRow = doc.select("table").select("tr");
		for (int i = 0; i < ListRow.size(); i++) {
			if (i == 0)
				continue;
			Element row = ListRow.get(i);
			String href = row.select("a").first().attr("href");
			// 标准详情
			String url = "http://www.cssn.net.cn/pagesnew/search/" + href;
			Nationstandard standard = getNationstandard(url);

		}

	}

	public static void getCHSStandard() throws IOException {
		Document doc_ch = null;
		String posturl = "http://www.cssn.net.cn/ds?ns=nvsearch&URI=search_base&SERVICE=SevAdvanceSearch";

		// 中国标准分类（CCS）：
		/*
		 * C51、C52、C57、C60、C62、C65、C66、C67、C68、C69、C70、C71、C72、C73、C75、C77、C78
		 * 、C80、C83、C85 B09、D09、E09、F09、G09、H09、J09、K09、L09、M09、N09、P09、Q09、R09
		 * 、S09、T09、U09、V09、W09、X09、Y09
		 */
		String type_all = "C51,C52,C57,C60,C62,C65,C66,C67,C68,C69,C70,C71,C72,C73,C75,C77,C78,C80,C83,C85,B09,D09,E09,F09,G09,H09,J09,K09,L09,M09,N09,P09,Q09,R09,S09,T09,U09,V09,W09,X09,Y09";
		String[] typeArray = type_all.split(",");
		Connection conn_ch = Jsoup.connect(posturl);
		conn_ch.data("paixu", "asc");
		conn_ch.data("orderby", "sort_number");
		// String type_ch =
		// "C51+C52+C57+C60+C62+C65+C66+C67+C68+C69+C70+C71+C72+C73+C75+C77+C78+C80+C83+C85+B09+D09+E09+F09+G09+H09+J09+K09+L09+M09+N09+P09+Q09+R09+S09+T09+U09+V09+W09+X09+Y09";
		String type_ch = "C51";
		conn_ch.data("chn_standard_typenum", type_ch);
		conn_ch.data("bzstatus", "xxk");

		Map<String, String> cookies = null;
		String geturl = "http://www.cssn.net.cn/pagesnew/search/search_base_result.jsp?pi=1&iPageSizeSle=5000&flag=null&location=null";
		for (int i = 0; i < typeArray.length; i++) {
			type_ch = typeArray[i];
			conn_ch.data("chn_standard_typenum", type_ch);
			// 保存cookie
			Response res = conn_ch.timeout(30000).execute();
			cookies = res.cookies();
			doc_ch = Jsoup.connect(geturl).cookies(cookies).timeout(30000)
					.get();
			// 保存文件

			FileOutputStream fos = new FileOutputStream("D:/CCS_" + type_ch
					+ ".html", true);
			fos.write(doc_ch.html().getBytes());
			fos.close();
			System.out.println(i + 1 + " 成功生成文件：CCS_" + type_ch + ".html");

			JsoupTest test = new JsoupTest();
			Thread t = new Thread(test);
			try {
				Thread.sleep(1000);
				t.start();
			} catch (InterruptedException e) {

			}
		}

	}

	public void generateFile(String type_ch) throws IOException {
		Document doc_ch = null;
		String posturl = "http://www.cssn.net.cn/ds?ns=nvsearch&URI=search_base&SERVICE=SevAdvanceSearch";

		Connection conn_ch = Jsoup.connect(posturl);
		conn_ch.data("paixu", "asc");
		conn_ch.data("orderby", "sort_number");
		conn_ch.data("chn_standard_typenum", type_ch);
		conn_ch.data("bzstatus", "xxk");

		Map<String, String> cookies = null;
		String geturl = "http://www.cssn.net.cn/pagesnew/search/search_base_result.jsp?pi=1&iPageSizeSle=5000&flag=null&location=null";
		conn_ch.data("chn_standard_typenum", type_ch);
		// 保存cookie
		Response res = conn_ch.timeout(30000).execute();
		cookies = res.cookies();
		doc_ch = Jsoup.connect(geturl).cookies(cookies).timeout(30000).get();
		// 保存文件
		FileOutputStream fos = new FileOutputStream("D:/CCS_" + type_ch
				+ ".html", true);
		fos.write(doc_ch.html().getBytes());
		fos.close();
		System.out.println("成功生成文件：CCS_" + type_ch + ".html");

	}

	private static void test() throws IOException {
		try {
			// //eg1:解析百度音乐
			Document doc = Jsoup.connect(
					"http://list.mp3.baidu.com/top/singer/A.html").get();
			Element singerListDiv = doc.getElementsByAttributeValue("class",
					"content").first();
			Elements links = singerListDiv.getElementsByTag("a");

			for (Element link : links) {
				String linkHref = link.attr("href");
				String linkText = link.text().trim();
				System.out.println(linkHref);
			}

			//
			// //eg2:解析万年历
			Document doc2 = Jsoup.connect(
					"http://www.nongli.com/item4/index.asp?dt=2012-03-03")
					.get();
			Element infoTable = doc2.getElementsByAttributeValue("class",
					"table002").first();
			Elements tableLineInfos = infoTable.select("tr");
			for (Element lineInfo : tableLineInfos) {
				String lineInfoContent = lineInfo.select("td").last().text()
						.trim();
				System.out.println("jsoup is :" + lineInfoContent);
			}

			// eg3:解析指定段落的内容----注意此代码中的语法：<div class="artHead">
			Document doc3 = Jsoup.connect("http://passover.blog.51cto.com")
					.get();
			Elements divs = doc3.select("div.artHead");
			for (Element div : divs) {
				System.out.println(div.select("h3[class=artTitle]"));
			}

			// eg4：
			// Document doc =
			// Jsoup.connect("http://passover.blog.51cto.com").get();

			// //eg5:查找html元素 s
			File input = new File("/tmp/input.html");
			Document doc1 = Jsoup.parse(input, "UTF-8",
					"http://www.oschina.net/");
			Elements links1 = doc1.select("a[href]"); // 链接
			Elements pngs = doc1.select("img[src$=.png]"); // 所有 png 的图片
			Element masthead = doc1.select("div.masthead").first();// div with
																	// class=masthead
			Elements resultLinks = doc1.select("h3.r > a"); // direct a after h3

			// //test
			// File input = new File("D:/test.html");
			// Document doc =
			// Jsoup.parse(input,"UTF-8","http://www.oschina.net/");

			/*
			 * 项目数据准备
			 */

			// eg5：万年历：http://www.zdic.net/nongli/2012-3-7.htm

			// data1：dayFav（宜）
			// Document doc =
			// Jsoup.connect("http://www.zdic.net/nongli/2012-3-7.htm").get();
			// Element dayFav = doc.getElementsByAttributeValue("class",
			// "ly2").first();
			// Elements dayFavItems = dayFav.getElementsByTag("a");
			// for (Element dayFavItem:dayFavItems) {
			// System.out.println(dayFavItem.text());
			// }

			// data2：dayUnfav（忌）
			// Element dayUnfav = doc.getElementsByAttributeValue("class",
			// "lj2").first();
			// Elements dayUnfavItems = dayUnfav.getElementsByTag("a");
			// for (Element dayUnfavItem:dayUnfavItems) {
			// System.out.println(dayUnfavItem.text());
			// }

			// data3:taiSheng(胎神)
			// Element taiSheng = doc.getElementsByAttributeValue("class",
			// "lts2").first();
			// System.out.println(taiSheng.text());

			// data4:chong sha(冲煞信息)
			// Element chong = doc.getElementsByAttributeValue("class",
			// "lcs").first();
			// Element sha = doc.getElementsByAttributeValue("class",
			// "lcs").get(1);
			// System.out.println(chong.text());
			// System.out.println(sha.text());

			// data5:zhengChong(正冲)和zhiXing（值星）
			// Element zhengChong = doc.getElementsByAttributeValue("class",
			// "lzc2").first();
			// Element zhiXing = doc.getElementsByAttributeValue("class",
			// "lzx2").first();
			// System.out.println(zhengChong.text());
			// System.out.println(zhiXing.text());

			// data6：godFav（吉神宜趋）
			// Element godUnfav = doc.getElementsByAttributeValue("class",
			// "js2").first();
			// System.out.println(godUnfav.text());

			// data7：godUnfav（凶神宜忌）
			// Element godFav = doc.getElementsByAttributeValue("class",
			// "xs2").first();
			// System.out.println(godFav.text());

			// data8：pengZuBaiJi（彭祖百忌）
			// Element pengZuBaiJi = doc.getElementsByAttributeValue("class",
			// "pz2").first();
			// System.out.println(pengZuBaiJi.text());

			// data9：wuXing（五行）
			// Element wuXing = doc.getElementsByAttributeValue("class",
			// "wuh2").first();
			// System.out.println(wuXing.text());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			generateFile(type);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
