package com.alexis.edaibao.core.service;

import com.alexis.edaibao.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
public interface DictService extends IService<Dict> {
    /**
     * 导入字典数据
     * @param inputStream
     */
    void importData(InputStream inputStream);
}
