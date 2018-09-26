package pl.brokenpipe.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ArticleResolver implements GraphQLResolver<Types.Article> {
    static Map<Integer, Types.Author> authors =  new HashMap<>();

    static {
        authors.put(1, new Types.Author("Me"));
        authors.put(2, new Types.Author("Me"));
        authors.put(3, new Types.Author("Me"));
        authors.put(4, new Types.Author("Me"));
        authors.put(5, new Types.Author("Me after 10h of debugging"));
    }

    public Types.Author getAuthor(Types.Article article) {
        return authors.get(article.id);
    }

}
