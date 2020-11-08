package Account.Strategy;

public class UserContext {
    private UserStrategy userStrategy;

    //标志策略模式的四种操作
    public enum UserOperation{
        Register,
        Login,
        Quit,
        Delete
    }

    //策略模式的执行
    public void execute(String name,int id, String password, UserOperation userOperation){
        switch (userOperation){
            case Register:
                this.userStrategy = new Register();
                break;
            case Login:
                this.userStrategy = new Login();
                break;
            case Quit:
                this.userStrategy = new Quit();
                break;
            case Delete:
                this.userStrategy = new Delete();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + userOperation);
        }
        //调用各个不同策略的方法
        userStrategy.userOperation(name,id,password);
    }
}
