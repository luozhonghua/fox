package com.st.fox.admin.service.web;

import com.github.pagehelper.PageInfo;
import com.st.fox.admin.service.domain.SysAdminUserService;
import com.st.fox.admin.service.model.SysAdminLog;
import com.st.fox.admin.service.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by luozhonghua on 2018/8/16.
 */
@RestController
@RequestMapping("/admin/logs")
@Api(value = "LogController", description = "日志接口")
public class LogController extends CommonController{
    @Autowired
    private SysAdminUserService sysAdminUserService;

    @ApiOperation(value = "列表", httpMethod="GET")
    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public  String   list( ) {
        PageInfo<SysAdminLog> userPage=null;
        return FastJsonUtils.resultSuccess(200, "成功", userPage);
    }

    @ApiOperation(value = "删除", httpMethod="GET")
    @RequestMapping(value = "/del/{id}", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String del(HttpServletRequest request, @PathVariable Long id) {
        SysAdminLog goup =null;
        return FastJsonUtils.resultSuccess(200, "成功", goup);
    }

}
