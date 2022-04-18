package com.alexis.edaibao.core.listener;

import com.alexis.edaibao.core.mapper.DictMapper;
import com.alexis.edaibao.core.pojo.dto.ExcelDictDTO;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc-zj
 * @create 2022-04-15 14:16
 */
@Slf4j
@NoArgsConstructor
public class ExcelDictListener extends AnalysisEventListener<ExcelDictDTO> {
    private DictMapper dictMapper;
    /**
     * 数据列表
     */
    private List<ExcelDictDTO> list = new ArrayList<>();
    /**
     * 生产环境临界值约为3000
     * 测试 暂定5条
     */
    private static final int BATCH_COUNT = 5;

    public ExcelDictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext analysisContext) {
        log.info("解析到一条数据记录: {}", data);
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 当最后数据记录数字不足BATCH_COUNT一次存储
        log.info("剩余最终 {} 条数据被存储到数据库...", list.size());
        saveData();
        log.info("所有数据解析完成");
    }

    private void saveData() {
        log.info("{} 条数据被存储到数据库...", list.size());
        // 调用mapper进行save存储
        dictMapper.insertBatch(list);
        log.info("{} 条数据被存储到数据库成功!", list.size());
    }
}
