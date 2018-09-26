package pl.brokenpipe.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    static List<Types.Article> articles = new ArrayList<>();

    static {
        articles.add(new Types.Article(
                1, "GraphQl is Awesome!", null, "I Love it!", "2018-09-23")
        );
        articles.add(new Types.Article(
                2, "GraphQl is Great!", null, "I really Love it!", "2018-09-23")
        );
        articles.add(new Types.Article(
                3, "GraphQl is Magnificent!", null, "I  definitely Love it!", "2018-09-25")
        );
        articles.add(new Types.Article(
                4, "GraphQl is Useful!", null, "I like it?", "2018-09-26")
        );
        articles.add(new Types.Article(
                5, "I hate GraphQl", null, "I hate it!", "2018-09-27")
        );
    }


    public List<Types.Article> getArticles(int limit, int offset) {
        return articles.stream().skip(offset).limit(limit).collect(Collectors.toList());
    }

    public Types.Article article(int id) {
        return articles.get(id-1);
    }
}
