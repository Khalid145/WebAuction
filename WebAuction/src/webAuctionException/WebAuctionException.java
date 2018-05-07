package webAuctionException;

public class WebAuctionException extends Exception {

    /**
     * Creates new <code>CourseException</code> without detail message.
     */
    public WebAuctionException() {
        this("CourseException");
    }

    /**
     * Constructs an <code>CourseException</code> with the specified
     * detail message.
     * @param msg the detail message.
     */
    public WebAuctionException(String msg) {
        super(msg);
    }
}
