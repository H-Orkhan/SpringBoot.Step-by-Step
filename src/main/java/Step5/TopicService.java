package Step5;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    public List<Topic> topics = Arrays.asList(
            new Topic(1, "Spring framework", "Description"),
            new Topic(2, "Spring framework2", "Description2"),
            new Topic(3, "Spring framework3", "Description3")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

    @SneakyThrows
    public Topic getTopicByID(int id) {

        return topics.stream()
                .filter(s -> s.getId() == (id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Topics are not found"));
    }
}

