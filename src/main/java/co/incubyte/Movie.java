package co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private String image;
    private String name;
    private int count;
    private String releaseDate;
    private float rating;

        public Movie(@JsonProperty("poster_path") String image,@JsonProperty("title") String name,@JsonProperty("vote_count") int count,@JsonProperty("release_date") String releaseDate,@JsonProperty("vote_average") float rating) {
        this.image = image;
        this.name = name;
        this.count = count;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public float getRating() {
        return rating;
    }
}
