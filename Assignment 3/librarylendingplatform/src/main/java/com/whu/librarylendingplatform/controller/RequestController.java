package com.whu.librarylendingplatform.controller;

import com.whu.librarylendingplatform.domain.Request;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * @Author: Colin
 * @Date: 2020/11/8 14:40
 */

@RestController
@RequestMapping(value="/requests")
public class RequestController {
    static Map<Integer, Request> requests = Collections.synchronizedMap(new HashMap<Integer, Request>());

    @ApiOperation(value="获取请求列表", notes="")
    @RequestMapping(value="/", method= RequestMethod.GET)
    public List<Request> getRequestList() {
        List<Request> r = new ArrayList<Request>(requests.values());
        return r;
    }

    @ApiOperation(value="创建请求", notes="根据Request对象创建请求")
    @ApiImplicitParam(name = "request", value = "请求详细实体request", required = true, dataType = "Request")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postRequest(@ModelAttribute Request request) {
        requests.put(request.getRequestId(), request);
        return "success";
    }

    @ApiOperation(value="获取请求详细信息", notes="根据url的requestId来获取用户详细信息")
    @ApiImplicitParam(name = "requestId", value = "请求ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{requestId}", method=RequestMethod.GET)
    public Request getRequest(@PathVariable Integer requestId) {
        return requests.get(requestId);
    }

    @ApiOperation(value="更新请求详细信息", notes="根据url的requestId来指定更新对象，并根据传过来的request信息来更新请求详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requestId", value = "请求ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "request", value = "请求详细实体request", required = true, dataType = "Request")
    })
    @RequestMapping(value="/{requestId}", method=RequestMethod.PUT)
    public String putRequest(@PathVariable Integer requestId, @ModelAttribute Request request) {
        Request r = requests.get(requestId);
        r.setStuId(request.getStuId());
        r.setBookName((request.getBookName()));
        r.setBookPress(request.getBookPress());
        requests.put(requestId, r);
        return "success";
    }

    @ApiOperation(value="删除请求", notes="根据url的requestId来指定删除对象")
    @ApiImplicitParam(name = "requestId", value = "请求ID", required = true, dataType = "Integer")
    @RequestMapping(value="/{requestId}", method=RequestMethod.DELETE)
    public String deleteRequest(@PathVariable Integer requestId) {
        requests.remove(requestId);
        return "success";
    }

}
