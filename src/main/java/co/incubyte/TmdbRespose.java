package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TmdbRespose {
    private int page;
    private List<Movie> results;

    public TmdbRespose(@JsonProperty("page") int page, @JsonProperty("results") List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }
}
