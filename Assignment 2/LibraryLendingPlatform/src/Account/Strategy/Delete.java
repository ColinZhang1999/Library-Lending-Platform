package Account.Strategy;

public class Delete implements UserStrategy {
    @Override
    public void userOperation(String name, int id, String password) {
        /**
         * 数据库交换
         */
        System.out.println(name+"/"+id+" is deleted" );
    }
}
