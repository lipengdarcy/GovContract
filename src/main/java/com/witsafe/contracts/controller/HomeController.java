package com.witsafe.contracts.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.witsafe.contracts.entity.common.JqGridData;
import com.witsafe.contracts.entity.common.ResponseData;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.model.Nationstandard;
import com.witsafe.contracts.model.NationstandardWithBLOBs;
import com.witsafe.contracts.model.Organization;
import com.witsafe.contracts.model.OrganizationExample;
import com.witsafe.contracts.service.AccountService;
import com.witsafe.contracts.service.NationstandardService;
import com.witsafe.contracts.service.OrganizationService;

/**
 * @Description 主页操作，包括查看，编辑，删除通讯录，维护组织机构等
 * @author lipeng
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	private static Logger log = Logger.getLogger("InfoLogger");

	@Autowired
	private AccountService accountService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private NationstandardService nationstandardService;

	/**
	 * 主页面
	 */
	@RequestMapping()
	public String load(ModelMap m) {
		log.info("组织机构页面：");
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
			organizationService.insert(org);
			data.setState("success");
			data.setContent("新增成功！");
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
			organizationService.delete(orgid);
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
			organizationService.update(org);
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
			log.info("查询所有机构");
			List<Organization> list = organizationService.selectAll();
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
	public JqGridData<NationstandardWithBLOBs> standard(
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

		List<NationstandardWithBLOBs> list = nationstandardService.selectAll(pageNumber,
				pageSize);

		Page p = (Page) list;
		// JqGridData(int total, int page, int records, List<T> rows)
		JqGridData<NationstandardWithBLOBs> data = new JqGridData<NationstandardWithBLOBs>(
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
		if(orgid==null)
			return null;
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
	 * 新增，编辑，删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "/operateAccount", method = RequestMethod.POST)
	public ResponseData<Integer> operateAccount(Account account, String oper,
			ModelMap m) {
		ResponseData<Integer> data = new ResponseData<Integer>();
		switch (oper) {
		case "add":
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

		case "edit":
			try {
				accountService.update(account);
				data.setState("success");
				data.setContent("编辑成功！");
				return data;
			} catch (Exception e) {
				data.setCode(-1);
				data.setState("failed");
				data.setContent("编辑失败！");
				return data;
			}

		case "del":
			try {
				accountService.delete(account);
				data.setState("success");
				data.setContent("删除成功！");
				return data;
			} catch (Exception e) {
				data.setCode(-1);
				data.setState("failed");
				data.setContent("删除失败！");
				return data;
			}

		default:
			return data;
		}

	}

}
