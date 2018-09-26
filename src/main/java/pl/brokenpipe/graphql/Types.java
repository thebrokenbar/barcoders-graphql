package pl.brokenpipe.graphql;

public class Types {
    public static class Article {

        public int id;
        public String title;
        public Author author;
        public String contents;
        public String releaseDate;

        public Article(int id, String title, Author author, String contents, String releaseDate) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.contents = contents;
            this.releaseDate = releaseDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }

    public static class Author {
        public String name;

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
