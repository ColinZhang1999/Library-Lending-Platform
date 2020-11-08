package main;

import Account.Strategy.UserContext;
import BookPlateform.Factory.RequestFactory;
import BookPlateform.Service.UserRequest;

public class LibraryLendingPlatform {
    public static void main(String[] args) {
        /**
         * 利用策略模式
         * 登录与注册
         */
        UserContext userContext = new UserContext();
        userContext.execute("student",01,"studentpwd", UserContext.UserOperation.Register);
        userContext.execute("student",01,"studentpwd", UserContext.UserOperation.Login);
        userContext.execute("admin",02,"adminpwd", UserContext.UserOperation.Register);
        userContext.execute("admin",02,"adminpwd", UserContext.UserOperation.Login);

        UserRequest userRequest = new UserRequest();
        userRequest.post(RequestFactory.RequestType.BorrowRequest);
        userRequest.post(RequestFactory.RequestType.ReturnRequest);
        userRequest.post(RequestFactory.RequestType.ApplyRequest);

        /**
         * 退出登录
         */
        userContext.execute("student",01,"studentpwd", UserContext.UserOperation.Quit);
        userContext.execute("admin",02,"adminpwd", UserContext.UserOperation.Quit);
    }
}
