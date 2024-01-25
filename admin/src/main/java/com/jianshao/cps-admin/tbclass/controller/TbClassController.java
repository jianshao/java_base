package com.jianshao.xxx.admin.tbclass.controller;

import com.jianshao.xxx.admin.common.entity.Result;
import com.jianshao.xxx.admin.tbclass.service.ClassResult;
import com.jianshao.xxx.admin.tbclass.service.TbClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.util.Comparator;
import java.util.List;


/**
 * <p>
 * 课程信息表 前端控制器
 * </p>
 *
 * @author jianshao
 * @since 2022-05-07
 */
@RestController
@RequestMapping("/tbClass/")
public class TbClassController {

    @Autowired
    private TbClassService tbClassService;

    @GetMapping("get/{id}")
    public Result<ClassResult> getById(@PathVariable("id") String id, @RequestParam String userId) {
        Integer classId = Integer.parseInt(id);
        Integer uid = Integer.parseInt(userId);
        if (classId.equals(0) || uid.equals(0)) {
            return Result.build(HttpURLConnection.HTTP_BAD_REQUEST, "非法ID", null);
        }

        try {
            ClassResult classResult = tbClassService.getById(classId, uid);
            return Result.build(classResult);
        } catch (Exception e) {
            return Result.build(HttpURLConnection.HTTP_BAD_REQUEST, "数据异常", null);
        }
    }

    @GetMapping("list")
    public Result<List<ClassResult>> list(@RequestParam String userId, @RequestParam String orderBy) {
        Integer uid = Integer.parseInt(userId);
        if (uid.equals(0)) {
            return Result.build(HttpURLConnection.HTTP_BAD_REQUEST, "invalid id", null);
        }
        try {
            List<ClassResult> classResults = tbClassService.list(uid);
            if (orderBy.equals("time")) {
                classResults.sort(Comparator.comparing(ClassResult::getCreatedTime).reversed());
            } else {
                classResults.sort(Comparator.comparing(ClassResult::getJoinCount).reversed());
            }
            return Result.build(classResults);
        } catch (Exception e) {
            return Result.build(HttpURLConnection.HTTP_BAD_REQUEST, "data not existed", null);
        }
    }

}