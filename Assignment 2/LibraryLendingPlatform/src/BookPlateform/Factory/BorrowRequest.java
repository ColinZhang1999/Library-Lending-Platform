package BookPlateform.Factory;


public class BorrowRequest extends Request {
    public BorrowRequest() { type = "BorrowRequest"; }

    @Override
    public void showRequest() {
        System.out.println("This is a BorrowRequest");
    }
}