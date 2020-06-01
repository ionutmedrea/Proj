package Exceptions;

public class ComponentAlreadyExistsException extends Exception {
    private String name;

    public ComponentAlreadyExistsException(String name) {
        super(String.format("A component with the name %s already exists!", name));
        this.name = name;
    }

    public String getComponentName() {
        return name;
    }
}
