package morrison.stream;

/**
 * @author Daniel Morrison
 * @since 20/11/2018.
 */
public class Message {

    private Integer id;
    private String message;

    public Integer getId() {
        return id;
    }

    public Message setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }
}
