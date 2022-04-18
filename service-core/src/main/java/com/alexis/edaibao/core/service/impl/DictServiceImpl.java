package com.alexis.edaibao.core.service.impl;

import com.alexis.edaibao.core.listener.ExcelDictListener;
import com.alexis.edaibao.core.pojo.dto.ExcelDictDTO;
import com.alexis.edaibao.core.pojo.entity.Dict;
import com.alexis.edaibao.core.mapper.DictMapper;
import com.alexis.edaibao.core.service.DictService;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author cc-zj
 * @since 2022-04-12
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importData(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelDictDTO.class, new ExcelDictListener(baseMapper)).sheet().doRead();
        log.info("Excel导入成功");
    }
}
