package cn.mldn.hh.mould.service.front;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.hh.mould.dao.IActionDAO;
import cn.mldn.hh.mould.dao.IMemberDAO;
import cn.mldn.hh.mould.dao.IRoleDAO;
import cn.mldn.hh.mould.vo.Member;
@Service
public class MemberServiceFrontImpl implements IMemberServiceFront {
	@Resource
	private IMemberDAO memberDAO ;
	@Resource
	private IRoleDAO roleDAO ;
	@Resource
	private IActionDAO actionDAO ;
	@Override
	public Member get(String mid) {
		return this.memberDAO.findById(mid);
	}

	@Override
	public Map<String, Set<String>> getRoleAndActionByMember(String mid) {
		Map<String, Set<String>> map = new HashMap<>() ;
		map.put("allRoles", this.roleDAO.findAllByMember(mid)) ;
		map.put("allActions", this.actionDAO.findAllByMember(mid)) ;
		return map;
	}

}
