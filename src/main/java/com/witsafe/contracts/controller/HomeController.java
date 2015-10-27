package com.witsafe.contracts.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.witsafe.contracts.common.Constant;
import com.witsafe.contracts.dao.OrganizationMapper;
import com.witsafe.contracts.entity.common.JqGridData;
import com.witsafe.contracts.entity.common.ResponseData;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.model.Nationstandard;
import com.witsafe.contracts.model.Organization;
import com.witsafe.contracts.model.OrganizationExample;
import com.witsafe.contracts.service.AccountService;
import com.witsafe.contracts.service.NationstandardService;

/**
 * @Description 主页操作，包括查看，编辑，删除通讯录，维护组织机构等
 * @author lipeng
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	private static Logger loggerinfo = Logger.getLogger("InfoLogger");

	@Autowired
	private AccountService accountService;

	@Autowired
	private NationstandardService nationstandardService;

	@Autowired
	private OrganizationMapper organizationMapper;

	/**
	 * 主页面
	 */
	@RequestMapping()
	public String load(ModelMap m) {
		int maxid = organizationMapper.selectMaxId();
		m.put("maxid", maxid);
		return "home/index";
	}

	/**
	 * 新增机构
	 */
	@ResponseBody
	@RequestMapping(value = "/addOrg", method = RequestMethod.POST)
	public ResponseData<Integer> addOrg(HttpSession session, Organization org,
			ModelMap m) {
		ResponseData<Integer> data = new ResponseData<Integer>();
		try {
			organizationMapper.insertSelective(org);
			data.setState("success");
			data.setContent("新增成功！");
			int maxid = organizationMapper.selectMaxId();
			data.setResult(maxid);
			return data;
		} catch (Exception e) {
			data.setState("failed");
			data.setCode(-1);
			data.setContent("新增失败！");
			return data;
		}

	}

	/**
	 * 删除机构
	 */
	@ResponseBody
	@RequestMapping(value = "/delOrg", method = RequestMethod.POST)
	public ResponseData delOrg(HttpSession session, int orgid, ModelMap m) {
		ResponseData data = new ResponseData();
		try {
			organizationMapper.deleteByPrimaryKey(orgid);
			data.setState("success");
			data.setContent("删除成功！");
			return data;
		} catch (Exception e) {
			data.setState("failed");
			data.setCode(-1);
			data.setContent("删除失败！");
			return data;
		}

	}

	/**
	 * 编辑机构
	 */
	@ResponseBody
	@RequestMapping(value = "/editOrg", method = RequestMethod.POST)
	public ResponseData editOrg(HttpSession session, Organization org,
			ModelMap m) {
		ResponseData data = new ResponseData();
		try {
			organizationMapper.updateByPrimaryKeySelective(org);
			data.setState("success");
			data.setContent("编辑成功！");
			return data;
		} catch (Exception e) {
			data.setCode(-1);
			data.setState("failed");
			data.setContent("编辑失败！");
			return data;
		}

	}

	/**
	 * 查询所有机构
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOrg", method = RequestMethod.POST)
	public ResponseData<List<Organization>> queryOrg(ModelMap m) {
		ResponseData<List<Organization>> data = new ResponseData<List<Organization>>();
		try {
			List<Organization> list = organizationMapper
					.selectByExample(new OrganizationExample());
			data.setContent("查询成功！");
			data.setResult(list);
			return data;
		} catch (Exception e) {
			data.setCode(-1);
			data.setState("failed");
			data.setContent("查询失败！");
			return data;
		}

	}

	/**
	 * 国家标准页面
	 */
	@RequestMapping(value = "/standardPage")
	public String standardPage(ModelMap m) {
		return "home/standard";
	}

	/**
	 * 国家标准数据
	 */
	@ResponseBody
	@RequestMapping(value = "/standard")
	public JqGridData<Nationstandard> standard(
			@RequestParam(required = false, defaultValue = "1", value = "page") int pageNumber, // 表示请求页码的参数名称
			@RequestParam(required = false, defaultValue = "20", value = "rows") int pageSize, // 表示请求行数的参数名称
			@RequestParam(required = false, value = "sidx") String sidx, // 表示用于排序的列名的参数名称
			@RequestParam(required = false, value = "sord") String sord, // 表示采用的排序方式的参数名称
			@RequestParam(required = false, value = "_search") boolean search, // 表示是否是搜索请求的参数名称
			@RequestParam(required = false, value = "searchField") String searchField,
			@RequestParam(required = false, value = "searchOper") String searchOper,
			@RequestParam(required = false, value = "searchString") String searchString,
			@RequestParam(required = false, value = "filters") String filters,
			ModelMap m) {

		List<Nationstandard> list = nationstandardService.selectAll(pageNumber,
				pageSize);

		Page p = (Page) list;
		// JqGridData(int total, int page, int records, List<T> rows)
		JqGridData<Nationstandard> data = new JqGridData<Nationstandard>(
				p.getPages(), p.getPageNum(), (int) p.getTotal(), list);

		return data;
	}

	/**
	 * 机构的人员信息
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrgMembers")
	public JqGridData<Account> getOrgMembers(
			@RequestParam(required = false, defaultValue = "1", value = "page") int pageNumber, // 表示请求页码的参数名称
			@RequestParam(required = false, defaultValue = "20", value = "rows") int pageSize, // 表示请求行数的参数名称
			@RequestParam(required = false, value = "sidx") String sidx, // 表示用于排序的列名的参数名称
			@RequestParam(required = false, value = "sord") String sord, // 表示采用的排序方式的参数名称
			@RequestParam(required = false, value = "_search") boolean search, // 表示是否是搜索请求的参数名称
			@RequestParam(required = false, value = "searchField") String searchField,
			@RequestParam(required = false, value = "searchOper") String searchOper,
			@RequestParam(required = false, value = "searchString") String searchString,
			@RequestParam(required = false, value = "filters") String filters,
			Integer orgid, ModelMap m) {
		try {
			List<Account> list = accountService.getOrgMembers(orgid);
			Page p = (Page) list;
			// JqGridData(int total, int page, int records, List<T> rows)
			JqGridData<Account> data = new JqGridData<Account>(p.getPages(),
					p.getPageNum(), (int) p.getTotal(), list);
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 国家标准详情页面
	 */
	@RequestMapping(value = "/standardDetail")
	public String standardDetail(ModelMap m) {
		return "home/standardDetail";
	}
	
	/**
	 * 新增用户
	 */
	@ResponseBody
	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public ResponseData<Integer> addAccount(Account account,
			ModelMap m) {
		ResponseData<Integer> data = new ResponseData<Integer>();
		try {
			accountService.insert(account);
			data.setState("success");
			data.setContent("新增成功！");
			return data;
		} catch (Exception e) {
			data.setCode(-1);
			data.setState("failed");
			data.setContent("新增失败！");
			return data;
		}

	}

}
