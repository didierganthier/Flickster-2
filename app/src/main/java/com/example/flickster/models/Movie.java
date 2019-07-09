package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie
{
    String posterPath, overview, title, backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException
    {
        posterPath = jsonObject.getString("poster_path");
        overview = jsonObject.getString("overview");
        title = jsonObject.getString("title");
        backdropPath = jsonObject.getString("backdrop_path");
    }

    public static List<Movie> fromjsonArray(JSONArray movieJsonArray)
    {
        List<Movie> movies = new ArrayList<>();

        for(int i=0;i<movieJsonArray.length();i++)
        {
            try
            {
                movies.add(new Movie(movieJsonArray.getJSONObject(i)));
            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public String getPosterPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdropPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getOverview()
    {
        return overview;
    }

    public String getTitle()
    {
        return title;
    }
}
