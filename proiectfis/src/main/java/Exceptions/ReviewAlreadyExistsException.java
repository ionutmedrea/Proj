package Exceptions;

public class ReviewAlreadyExistsException extends Exception{
    private String name;

    public ReviewAlreadyExistsException(String name) {
        super(String.format("A component with this review already exists!"));
        this.name = name;
    }

    public String getComponentName() {
        return name;
    }
}

