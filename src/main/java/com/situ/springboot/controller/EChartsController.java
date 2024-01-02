package com.situ.springboot.controller;

import com.situ.springboot.pojo.vo.BlogTypeCountVO;
import com.situ.springboot.service.IBlogTypeService;
import com.situ.springboot.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/echarts")
public class EChartsController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @RequestMapping("/toECharts")
    public String toECharts() {
        return "echarts";
    }

    @RequestMapping("/selectBlogTypeCount")
    @ResponseBody
    public Result selectBlogTypeCount() {
        List<BlogTypeCountVO> list = blogTypeService.selectBlogTypeCount();
        return Result.ok(list);
    }
}