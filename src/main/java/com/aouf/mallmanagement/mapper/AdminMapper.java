package com.aouf.mallmanagement.mapper;

import com.aouf.mallmanagement.bean.bo.AddAdminBo;
import com.aouf.mallmanagement.bean.bo.SearchAdminBo;
import com.aouf.mallmanagement.bean.po.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> getAdminsByBo(SearchAdminBo searchAdminBo);
    Integer getAdminsByBoCount(SearchAdminBo searchAdminBo);
    Integer delete(int[] ids);
    Integer add(AddAdminBo addAdminBo);
    Integer update(AddAdminBo addAdminBo);

    Admin getAdminByIdOrName(Integer admin_id,String admin_name);
}
