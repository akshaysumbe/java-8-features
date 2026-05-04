package streams.model;

public class GSTBreakdown {
    private double gst;
    private double cgst;
    private double sgst;

    public GSTBreakdown(double gst, double cgst, double sgst) {
        this.gst = gst;
        this.cgst = cgst;
        this.sgst = sgst;
    }

    @Override
    public String toString() {
        return "GSTBreakdown{" +
                "gst=" + gst +
                ", cgst=" + cgst +
                ", sgst=" + sgst +
                '}';
    }
}
