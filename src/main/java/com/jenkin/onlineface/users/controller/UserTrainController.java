package com.jenkin.onlineface.users.controller;


import com.jenkin.onlineface.commons.anno.AutoDoc;
import com.jenkin.onlineface.commons.anno.EnableErrorCatch;
import com.jenkin.onlineface.commons.http.Response;
import com.jenkin.onlineface.users.entity.UserTrain;
import com.jenkin.onlineface.users.service.UserTrainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jenkin
 * @since 2020-03-12
 */
@RestController
@CrossOrigin
@Api(tags = "用户开始做题的接口")
@RequestMapping("/users/user-train")
@EnableErrorCatch("user-train")
public class UserTrainController {

    @Autowired
    private UserTrainService userTrainService;

    @PostMapping("/createUserTrain")
    @ApiOperation("用户点击开始做题，会为用户生成一套题目")
    @AutoDoc(paramClass = UserTrain.class)
    public Response<Object> createUserTrain(@RequestBody UserTrain userTrain){
        userTrainService.startTrain(userTrain);
        return Response.ok();
    }
    @GetMapping("/hasTrainByType")
    @ApiOperation("根据类型判断是否已经有了正在做的题目")
    public Response<Boolean> hasTrainByType(String trainType){
        UserTrain trainByType = userTrainService.getCurrentUserTrainByType(trainType);
        return Response.ok(trainByType!=null);
    }

    @GetMapping("/getDoc")
    public Response getDoc(){
        return Response.ok();

    }

}

