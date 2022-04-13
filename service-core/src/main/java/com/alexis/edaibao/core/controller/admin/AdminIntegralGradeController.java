package com.alexis.edaibao.core.controller.admin;

import com.alexis.edaibao.common.result.R;
import com.alexis.edaibao.core.pojo.entity.IntegralGrade;
import com.alexis.edaibao.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cc-zj
 * @create 2022-04-12 17:45
 */
@Api(tags = "积分等级列表")
@RestController
@CrossOrigin
@RequestMapping("admin/core/integralGrade")
public class AdminIntegralGradeController {
    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("积分等级列表")
    @GetMapping("/list")
    public R listAll() {
        List<IntegralGrade> list = integralGradeService.list();
        return R.ok().data("list",list).message("获取列表成功");
    }

    @ApiOperation(value = "根据id删除数据记录", notes = "逻辑删除数据")
    @DeleteMapping("remove/{id}")
    public R removeById(@ApiParam("数据id") @PathVariable long id) {
        boolean result = integralGradeService.removeById(id);
        if(result){
            return R.ok().message("删除成功");
        }else {
            return R.ok().message("删除失败");
        }
    }
}
