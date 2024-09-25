package com.example.oral.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    public BaseServiceImpl() {}

    public boolean saveOrUpdate(T entity) {
        this.beforeSaveOrUpdate(entity);
        return super.saveOrUpdate(entity) ? afterSaveOrUpdate(entity) : false;
    }

    public boolean save(T entity) {
        this.beforeSaveOrUpdate(entity);
        return super.save(entity) ? this.afterSaveOrUpdate(entity) : false;
    }

    public void beforeSaveOrUpdate(T entity) {}

    public boolean afterSaveOrUpdate(T entity) {
        return true;
    }

    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    public IPage<T> queryPageList(T object, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        // QueryWrapper<T> queryWrapper = QueryGenerator.initQueryWrapper(object, req.getParameterMap());
        Page<T> page = new Page((long)pageNo, (long)pageSize);
        IPage<T> pageList = this.page(page, new QueryWrapper<>());
        log.debug("查询当前页：" + pageList.getCurrent());
        log.debug("查询当前页数量：" + pageList.getSize());
        log.debug("查询结果数量：" + pageList.getRecords().size());
        log.debug("数据总数：" + pageList.getTotal());
        return pageList;
    }
}
