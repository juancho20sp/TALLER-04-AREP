package spring.examples;

import spring.Service;

public class StatusService {
    @Service("/status")
    public static String Status() {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n"
                + "</head>"
                + "<body>"
                + "<p>Service status</p>"
                + "</body>"
                + "</html>";
    }
}
