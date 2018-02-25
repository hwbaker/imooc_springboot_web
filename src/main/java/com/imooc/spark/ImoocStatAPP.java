package com.imooc.spark;


import com.imooc.dao.CourseClickCountDAO;
import com.imooc.domain.CourseClickCount;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WEB层开发
 */
@RestController
public class ImoocStatAPP {
    private static Map<String, String> courses = new HashMap<>();
    static {
        courses.put("112", "Spark SQL实战");
        courses.put("130", "Hadoop基础");
        courses.put("131", "Storm实战");
        courses.put("144", "Spark Streaming实战");
        courses.put("160", "大数据面试");
        courses.put("181", "Kafka时间环境搭建");
        courses.put("79", "Flume实战");
        courses.put("92", "error92");
        courses.put("96", "error96");
    }

    @Autowired
    CourseClickCountDAO courseClickCountDAO;

//    @RequestMapping(value = "/course_click_dynamic", method = RequestMethod.GET)
//    public ModelAndView courseClickCount() throws Exception {
//        ModelAndView view = new ModelAndView("index");
//
//        //使用json,引用dependency：pom.xml添加依赖
//        List<CourseClickCount> list = courseClickCountDAO.query("20180224");
//        for (CourseClickCount model : list) {
//            model.setName(courses.get(model.getName().substring(9)));
//        }
//        JSONArray json = JSONArray.fromObject(list);
//
//        view.addObject("data_json", json);
//
//        return view;
//    }

    @RequestMapping(value = "/course_click_dynamic", method = RequestMethod.POST)
    @ResponseBody
    public List<CourseClickCount> courseClickCount() throws Exception {

        List<CourseClickCount> list = courseClickCountDAO.query("20180224");
        for (CourseClickCount model : list) {
            model.setName(courses.get(model.getName().substring(9)));
        }
        return list;
    }

    @RequestMapping(value = "/echarts", method = RequestMethod.GET)
    public ModelAndView echarts() {
        return new ModelAndView("echarts");
    }

}
