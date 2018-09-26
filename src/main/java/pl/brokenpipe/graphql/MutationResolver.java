package pl.brokenpipe.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import static pl.brokenpipe.graphql.ArticleResolver.authors;
import static pl.brokenpipe.graphql.QueryResolver.articles;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    public Types.Article addArticle(String authorName, String title, String contents) {
        Optional<Types.Author> authorOptional = authors.entrySet().stream()
                .filter(integerAuthorEntry -> integerAuthorEntry.getValue().name.equals(authorName))
                .map(Map.Entry::getValue)
                .findFirst();
        Types.Author author = authorOptional.orElseGet(() -> new Types.Author(authorName));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        Types.Article article = new Types.Article(articles.size()+1, title, null, contents, date);

        articles.add(article);
        authors.put(article.id, author);
        return article;
    }

}
