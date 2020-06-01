package Services;


import Exceptions.ComponentAlreadyExistsException;
import Exceptions.CouldNotWriteComponentsException;
import Model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComponentService {

    private static List<Item> items = new ArrayList<Item>();
    private static final Path COMPONENT_PATH = FileSystemService.getPathToFile("config", "items.json");

    public static void loadCompsFromFile() throws IOException {

        if (!Files.exists(COMPONENT_PATH)) {
            FileUtils.copyURLToFile(ComponentService.class.getClassLoader().getResource("items.json"), COMPONENT_PATH.toFile());

        }

        ObjectMapper objectMapper = new ObjectMapper();
        items = objectMapper.readValue(COMPONENT_PATH.toFile(), new TypeReference<List<Item>>() {});
    }

    public static void addComp(String name, int price, int gradComp) throws ComponentAlreadyExistsException {
        checkCompDoesNotAlreadyExist(name);
        items.add(new Item(name, price, gradComp));
        persistComps();
    }

    private static void checkCompDoesNotAlreadyExist(String name) throws ComponentAlreadyExistsException {
        for (Item item : items) {
            if (Objects.equals(name,item.getName()))
                throw new ComponentAlreadyExistsException(name);
        }
    }

    private static void persistComps() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(COMPONENT_PATH.toFile(), items);
        } catch (IOException e) {
            throw new CouldNotWriteComponentsException();
        }
    }
}
