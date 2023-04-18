package com.aouf.mallmanagement.service;

import com.aouf.mallmanagement.bean.bo.AddAdminBo;
import com.aouf.mallmanagement.bean.bo.SearchAdminBo;
import com.aouf.mallmanagement.bean.po.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAdminService extends UserDetailsService {
    List<Admin> getAdminsByBo(SearchAdminBo searchAdminBo);
    Integer getAdminsByBoCount(SearchAdminBo searchAdminBo);
    String  delete(int[] ids);
    String add(AddAdminBo addAdminBo);
    String update(AddAdminBo addAdminBo);
    Admin getAdminByIdOrName(Integer admin_id,String admin_name);

}
