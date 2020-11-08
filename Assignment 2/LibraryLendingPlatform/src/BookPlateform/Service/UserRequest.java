package BookPlateform.Service;

import BookPlateform.Factory.Request;
import BookPlateform.Factory.RequestFactory;

public class UserRequest implements RequestService {
    /**
     * 发布消息
     */
    @Override
    public void post(RequestFactory.RequestType requestType) {
        //运用工厂创建消息
        RequestFactory requestFactory = new RequestFactory();
        Request request = requestFactory.createRequest(requestType);
        /**
         * 与数据库交互的代码
         */
        //发布消息
        System.out.println("post a/an " + request.getType());
    }
}


