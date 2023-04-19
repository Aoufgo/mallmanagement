package com.aouf.mallmanagement.service.impl;

import com.aouf.mallmanagement.bean.bo.AddCategoryBo;
import com.aouf.mallmanagement.bean.bo.SearchCategoryBo;
import com.aouf.mallmanagement.bean.po.Brand;
import com.aouf.mallmanagement.bean.po.Category;
import com.aouf.mallmanagement.bean.po.SpuAttrKey;
import com.aouf.mallmanagement.mapper.CategoryMapper;
import com.aouf.mallmanagement.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

//业务层实现类-负责分类业务
@Service            //代表将当前类型托管给spring框架/将当前类型转换成springbean
public class CategoryService implements ICategoryService {

    //成员属性,下层对象是数据访问层CategoryMapper接口类型(Autowired/Resource注解二选一)
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Category getOne(int cate_id) {
        return categoryMapper.getOne(cate_id);
    }

    @Override
    public PageInfo<Category> getCategoriesByBo(SearchCategoryBo searchCategoryBo) {
        PageHelper.startPage(searchCategoryBo.getPage(),searchCategoryBo.getPageSize());
        return new PageInfo<>(categoryMapper.getCategoriesByBo(searchCategoryBo));
    }

    @Override
    public List<Category> getAllParentCategories() {
        return categoryMapper.getAllParentCategories();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String add(AddCategoryBo addCategoryBo) {
        // 添加角色
        try {
            if (categoryMapper.add(addCategoryBo) > 0) {
                List<Brand> brands = addCategoryBo.getBrands();
                for (Brand brand : brands) {
                    categoryMapper.addBrandCate(brand.getBrand_id(),addCategoryBo.getCate_id());
                }
                List<SpuAttrKey> keys = addCategoryBo.getKeys();
                for (SpuAttrKey key : keys) {
                    categoryMapper.addKeyCate(key.getKey_id(),addCategoryBo.getCate_id());
                }
                return "添加成功";
            }else {
                return  "添加失败";
            }
        }catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "添加失败";
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String update(AddCategoryBo addCategoryBo) {
        try {
            if (categoryMapper.update(addCategoryBo) > 0) {
                categoryMapper.deleteBrandCateByCateId(addCategoryBo.getCate_id());
                // 添加品牌信息
                List<Brand> brands = addCategoryBo.getBrands();
                for (Brand brand : brands) {
                    categoryMapper.addBrandCate(brand.getBrand_id(),addCategoryBo.getCate_id());
                }
                // 删除属性信息
                categoryMapper.deleteKeyCateByCateId(addCategoryBo.getCate_id());
                List<SpuAttrKey> keys = addCategoryBo.getKeys();
                for (SpuAttrKey key : keys) {
                    categoryMapper.addKeyCate(key.getKey_id(),addCategoryBo.getCate_id());
                }
                return "更新成功";
            }else {
                return  "更新失败";
            }
        }catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "更新失败";
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String delete(int[] ids) {
        try{
            if(categoryMapper.delete(ids)>0){
                for(int id :ids) {
                    categoryMapper.deleteKeyCateByCateId(id);
                    categoryMapper.deleteBrandCateByCateId(id);
                }
                return "删除成功";
            }else {
                return "数据已经被删除";
            }
        }catch (Exception e){
            // 可以在出现异常回滚时设置返回值
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return "删除失败";
        }
    }
}
