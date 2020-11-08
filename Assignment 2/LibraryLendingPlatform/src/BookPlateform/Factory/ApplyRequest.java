package BookPlateform.Factory;

public class ApplyRequest extends Request {
    public ApplyRequest() { type = "ApplyRequest"; }

    @Override
    public void showRequest() {
        System.out.println("This is an ApplyRequest");
    }
}
