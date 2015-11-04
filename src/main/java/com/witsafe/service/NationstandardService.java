package com.witsafe.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.witsafe.dao.NationstandardMapper;
import com.witsafe.framework.common.Constant;
import com.witsafe.framework.common.util.HtmlUtil;
import com.witsafe.model.Nationstandard;
import com.witsafe.model.NationstandardExample;
import com.witsafe.model.NationstandardWithBLOBs;

@Service
public class NationstandardService implements Runnable {

	private String url;

	private static Logger loggerinfo = Logger
			.getLogger(NationstandardService.class);

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Autowired
	private NationstandardMapper nationstandardMapper;

	/**
	 * 获取国家标准文献的详情
	 */
	public NationstandardWithBLOBs getNationstandard(String url) {
		// 标准详情
		NationstandardWithBLOBs standard = new NationstandardWithBLOBs();
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			loggerinfo.error("连接出错或超时，url：" + url);
			return null;
		}

		String standardno = null, nameCh = null, nameEn = null;
		try {
			// 标准号
			standardno = doc.select("h3").get(0).html();
			standardno = HtmlUtil.delHTMLTag(standardno).replaceAll("现行", "");
			standard.setStandardno(standardno);
			// 中文题名， 英文题名
			nameCh = doc.select(".dl-horizontal-more").select("dd").get(0)
					.html();
			nameEn = doc.select(".dl-horizontal-more").select("dd").get(1)
					.html();
			standard.setNameCh(nameCh);
			standard.setNameEn(nameEn);
		} catch (Exception e) {
			loggerinfo.info("标准号：" + standardno + " 的中文题名， 英文题名为空或者格式不正确");
			standard.setNameCh(nameCh);
			standard.setNameEn(nameEn);
		}
		// 发布日期，实施日期
		String publishDate = null, effectDate = null;
		try {
			publishDate = doc.select(".detailBox:has(.icon_info)").select("dd")
					.get(0).html().replaceAll("发布日期：", "");
			effectDate = doc.select(".detailBox:has(.icon_info)").select("dd")
					.get(1).html().replaceAll("实施日期：", "");
			standard.setPublishDate(Constant.formatDate.parse(publishDate));
			standard.setEffectDate(Constant.formatDate.parse(effectDate));
		} catch (Exception e) {
			loggerinfo.info("标准号：" + standardno + " 的发布日期，实施日期为空或者格式不正确");
			standard.setPublishDate(null);
			standard.setEffectDate(null);
		}

		try {
			// 适用范围
			String validRange = doc.select(".detailBox:has(.icon_scope)")
					.select("dd").get(0).html();
			validRange = HtmlUtil.delHTMLTag(validRange);
			standard.setValidRange(validRange);
			// 代替标准号
			Elements replace = doc.select(".detailBox:has(.icon_assoc)")
					.select("dd");
			if (!replace.isEmpty()) {
				String standardnoReplace = doc
						.select(".detailBox:has(.icon_assoc)").select("dd")
						.get(0).select("dd").select("a").html();
				standardnoReplace = HtmlUtil.delHTMLTag(standardnoReplace);
				standard.setStandardnoReplace(standardnoReplace);
			}
			// 中国标准分类, 国际标准分类,
			String typeCh = doc.select("#getCcsCn").get(0).html();
			String typeIso = doc.select("#getIcsCn").get(0).html();
			standard.setTypeCh(typeCh);
			standard.setTypeIso(typeIso);
		} catch (Exception e) {
			loggerinfo.info("标准号：" + standardno
					+ " 的适用范围，代替标准号，中国标准分类, 国际标准分类 为空或者格式不正确");
		}
		return standard;

	}

	public Nationstandard selectByPrimaryKey(int id) {
		return nationstandardMapper.selectByPrimaryKey(id);
	}
	
	// 分页查询 
	public List<NationstandardWithBLOBs> selectAll(int pageNumber, int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		return nationstandardMapper.selectByExampleWithBLOBs(new NationstandardExample());
	}


	/**
	 * 保存国际标准文献资料到数据库
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public int insertNationstandardISO() throws IOException, ParseException {

		int count = 0;
		Document doc = null;
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
			System.setProperty("sun.net.client.defaultConnectTimeout",
					String.valueOf(10000));// （单位：毫秒）
			System.setProperty("sun.net.client.defaultReadTimeout",
					String.valueOf(10000)); // （单位：毫秒）

			String url = "http://www.cssn.net.cn/pagesnew/search/" + href;

			NationstandardService service = new NationstandardService();
			service.setUrl(url);
			Thread t = new Thread(service);

			try {
				Thread.sleep(1000);
				t.start();
			} catch (InterruptedException e) {

			}
			NationstandardWithBLOBs standard = getNationstandard(url);
			if (standard != null) {
				count += nationstandardMapper.insertSelective(standard);
				loggerinfo.info("序号:" + count + ", 标准号:"
						+ standard.getStandardno());
			}
		}

		if (count > 0)
			return count;
		else
			return -1;
	}

	/**
	 * 保存国家标准文献资料到数据库
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public int insertNationstandardCH() throws IOException, ParseException {
		int count = 0;
		Document doc = null;
		String type_all = "C51,C52,C57,C60,C62,C65,C66,C67,C68,C69,C70,C71,C72,C73,C75,C77,C78,C80,C83,C85,B09,D09,E09,F09,G09,H09,J09,K09,L09,M09,N09,P09,Q09,R09,S09,T09,U09,V09,W09,X09,Y09";
		String[] typeArray = type_all.split(",");
		for (int k = 0; k < typeArray.length; k++) {
			// 读取文件
			File f = new File("D:/CCS_" + typeArray[k] + ".html");
			doc = Jsoup.parse(f, "UTF-8");
			loggerinfo.info("标准类别：" + typeArray[k]);
			
			Elements ListRow = doc.select("table").select("tr");
			for (int i = 0; i < ListRow.size(); i++) {
				if (i == 0)
					continue;
				Element row = ListRow.get(i);
				String href = row.select("a").first().attr("href");
				// 标准详情
				System.setProperty("sun.net.client.defaultConnectTimeout",
						String.valueOf(10000));// （单位：毫秒）
				System.setProperty("sun.net.client.defaultReadTimeout",
						String.valueOf(10000)); // （单位：毫秒）

				String url = "http://www.cssn.net.cn/pagesnew/search/" + href;

				NationstandardService service = new NationstandardService();
				service.setUrl(url);
				Thread t = new Thread(service);

				try {
					Thread.sleep(1000);
					t.start();
				} catch (InterruptedException e) {

				}
				NationstandardWithBLOBs standard = getNationstandard(url);
				if (standard != null) {
					count += nationstandardMapper.insertSelective(standard);
					loggerinfo.info("序号:" + count + ", 标准号:"
							+ standard.getStandardno());
				}
			}
		}

		if (count > 0)
			return count;
		else
			return -1;
	}

	@Override
	public void run() {
		getNationstandard(url);
	}

}
