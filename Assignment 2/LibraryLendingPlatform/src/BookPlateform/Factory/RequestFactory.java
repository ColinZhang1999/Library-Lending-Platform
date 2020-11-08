package BookPlateform.Factory;

//请求工厂
public class RequestFactory {
    //三种不同的请求类型
    public enum RequestType{
        BorrowRequest,
        ReturnRequest,
        ApplyRequest
    }

    //工厂通过不同参数生成不同类的请求对象
    public Request createRequest(RequestType requestType){
        switch(requestType){
            case BorrowRequest:
                return new BorrowRequest();
            case ReturnRequest:
                return new ReturnRequest();
            case ApplyRequest:
                return new ApplyRequest();
            default:
                throw new IllegalStateException("Unexpected value: " + requestType);
        }
    }
}
