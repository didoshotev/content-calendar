package dev.deffect.contentcalendar.repository;

import dev.deffect.contentcalendar.model.Content;
import dev.deffect.contentcalendar.model.Status;
import dev.deffect.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentCollection = new ArrayList<>();

    public ContentCollectionRepository() { }

    @PostConstruct
    private void init() {
        System.out.println("ContentCollectionRepository initiliazed action...");
        Content c = new Content(1, "Deffect", "Deffect is insance", Status.IN_PROGRESS, Type.ARTICLE, LocalDateTime.now(), null,"");
        contentCollection.add(c);
    }

    public List<Content> findAll() {
        return contentCollection;
    }

    public Optional<Content> findById(Integer id) {
        return contentCollection.stream().filter(item -> item.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentCollection.add(content);
    }

    public void update(Content content) {
        contentCollection.removeIf(existingContent -> existingContent.id().equals(content.id()));
        contentCollection.add(content);
    }

    public boolean existsById(Integer id) {
        return contentCollection.stream().filter(item -> item.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentCollection.removeIf(item -> item.id().equals(id));
    }
}
