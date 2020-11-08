package BookPlateform.Factory;

/**
 * 工厂模式
 * 请求的抽象类
 */

public abstract class Request {
    String type;


    //获取请求的种类
    public String getType() { return type; }

    public Request() { type = "null"; }

    //抽象方法
    public abstract void showRequest();
}
