package BookPlateform.Factory;


public class ReturnRequest extends Request {
    public ReturnRequest() { type = "ReturnRequest"; }

    @Override
    public void showRequest() {
        System.out.println("This is a ReturnRequest");
    }
}