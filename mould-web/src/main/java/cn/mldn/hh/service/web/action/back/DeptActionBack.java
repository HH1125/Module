package cn.mldn.hh.service.web.action.back;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.hh.mould.service.back.IDeptServiceBack;
import cn.mldn.hh.mould.vo.Dept;





@Controller
@RequestMapping("/pages/back/dept/*")
public class DeptActionBack {
	@Resource
	private IDeptServiceBack deptService ;
//	@RequiresAuthentication	// 已经认证过
//	@RequiresRoles("dept")
//	@RequiresPermissions("dept:add")
	@RequestMapping("dept_add")
	@ResponseBody
	public Object add(Dept vo) {
		
		return this.deptService.add(vo) ;
	}
//	@RequiresRoles("dept")
//	@RequiresPermissions("dept:list")
	@RequestMapping("dept_list")
	@ResponseBody
	public Object list() {
		SecurityUtils.getSubject().getSession().setAttribute("name", "我的名字。");
		System.err.println(SecurityUtils.getSubject().getPrincipal());
		return this.deptService.list() ;
	}
//	@RequiresRoles("dept")
//	@RequiresPermissions("dept:remove")
	@RequestMapping("dept_remove")
	@ResponseBody
	public Object remove(Long deptno) { 
		return this.deptService.remove(deptno);
	}
}
