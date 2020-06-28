package Services;

import Exceptions.ComponentAlreadyExistsException;
import Exceptions.CouldNotWriteComponentsException;
import Exceptions.ReviewAlreadyExistsException;
import Model.Item;
import Model.ReviewItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewService {

    public ReviewService(){

    }
    protected static List<ReviewItem> reviews = new ArrayList<ReviewItem>();
    private static final Path COMPONENT_PATH = FileSystemService.getPathToFile("config", "reviews.json");

    public static void loadReviewsFromFile() throws IOException {

        if (!Files.exists(COMPONENT_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(ReviewService.class.getClassLoader().getResource("reviews.json")), COMPONENT_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        reviews = objectMapper.readValue(COMPONENT_PATH.toFile(), new TypeReference<List<ReviewItem>>() {
        });
    }
    public static void addReview(String name, String rev) throws ReviewAlreadyExistsException {
        checkReviewDoesNotAlreadyExist(name,rev);
        reviews.add(new ReviewItem(name, rev));
        persistComps();
    }
    private static void checkReviewDoesNotAlreadyExist(String name, String review) throws ReviewAlreadyExistsException {
        for (ReviewItem current: reviews) {
            if (Objects.equals(review,current.getReview()))
                throw new ReviewAlreadyExistsException(name);
        }
    }

    private static void persistComps() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(COMPONENT_PATH.toFile(), reviews);
        } catch (IOException e) {
            throw new CouldNotWriteComponentsException();
        }
    }

}
