package com.alexis.edaibao.core.mapper;

import com.alexis.edaibao.core.pojo.dto.ExcelDictDTO;
import com.alexis.edaibao.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
public interface DictMapper extends BaseMapper<Dict> {
    /**
     * 批量存储数据
     * @param list
     */
    void insertBatch(List<ExcelDictDTO> list);
}
