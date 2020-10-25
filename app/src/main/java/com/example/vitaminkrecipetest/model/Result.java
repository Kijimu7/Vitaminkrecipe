package com.example.vitaminkrecipetest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {
    @SerializedName("q")
    public String q;
    @SerializedName("from")
    public int from;
    @SerializedName("to")
    public int to;
    @SerializedName("more")
    public boolean more;
    @SerializedName("count")
    public int count;
    @SerializedName("hits")
    public List<Hits> hits;


    //    @SerializedName("q")
//    private String q;
//    @SerializedName("from")
//    private Integer from;
//    @SerializedName("to")
//    private Integer to;
//    @SerializedName("hits")
//    List<com.example.vitaminkrecipetest.model.Hits> hits;
//    @SerializedName("image")
//    private String image;
//    @SerializedName("label")
//    private String label;


    public Result(String q, Integer from, Integer to, boolean more, int count, List<Hits> hits) {
        this.q = q;
        this.from = from;
        this.to = to;
        this.more = more;
        this.count = count;
        this.hits = new ArrayList<Hits>();


    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Hits> getHits() {
        return hits;
    }

    public void setHits(List<Hits> hits) {
        this.hits = hits;
    }


}

