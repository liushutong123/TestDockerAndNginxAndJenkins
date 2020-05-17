package com.bs.gas.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bs.gas.api.entity.Information;
import com.bs.gas.api.dto.InformationPage;
import com.bs.gas.base.R;
import com.bs.gas.api.service.IInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lst
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/information")
@Api(value = "加油信息查询控制器")
public class InformationController {

    @Autowired
    IInformationService iInformationService;

    @GetMapping("/add")
    @ApiOperation(value = "新增加油信息")
    public R addInformation(@RequestParam("mercuryName") @ApiParam(value = "加油站名称") String mercuryName,
                            @RequestParam("refuelingType") @ApiParam(value = "加油类型") String refuelingType,
                            @RequestParam("num") @ApiParam(value = "数量(单位L)") String num){
        boolean i;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Information information = new Information();
        information.setCreator("xxx");
        information.setCreatorTime(sdf.format(new Date()));
        information.setNum(num);
        information.setMercuryName(mercuryName);
        information.setRefuelingType(refuelingType);
        try {
            i = iInformationService.save(information);
            if(!i){
                throw new Exception("数据库执行错误，请检查数据");
            }
        }catch (Exception e){
            return R.fail(e.getMessage(),null);
        }
       return R.success(null);
    }

    @PostMapping("/selectInformation")
    @ApiOperation(value = "查询加油信息")
    public R selectInformation(@RequestBody InformationPage informationPage){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        QueryWrapper<Information> wrapper = new QueryWrapper();
        IPage<Information> page = new Page<>();
        page.setPages(informationPage.getPage());
        page.setSize(informationPage.getPageSize());
        if(!StringUtils.isEmpty(informationPage.getMonth())){
            List<String> list = getAllMonthDays(informationPage.getMonth());
            wrapper.in("creator_time",list);
        }
        if(!StringUtils.isEmpty(informationPage.getType())){
            wrapper.like("refueling_type",informationPage.getName());
        }
        if(!StringUtils.isEmpty(informationPage.getName())){
            wrapper.like("mercury_name",informationPage.getName());
        }
        return R.success(iInformationService.page(page,wrapper));
    }
    /**
     * 获取某一月份的所有日期
     * date 年月;格式:"2018-10"
     * @return
     */
    public static List<String> getAllMonthDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5));
        SimpleDateFormat dateFormatYYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
        List<String> fullDayList = new ArrayList<>(32);
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month-1 );
        // 当月1号
        cal.set(Calendar.DAY_OF_MONTH,1);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 1; j <= count ; j++) {
            fullDayList.add(dateFormatYYYYMMDD.format(cal.getTime()));
            cal.add(Calendar.DAY_OF_MONTH,1);
        }
        return fullDayList;
    }

/*    @GetMapping("/add")
    public R addInformation(@PathVariable("roleCode") String roleCode){

    }

    @PostMapping
    public R addInformation(){

    }*/
}

