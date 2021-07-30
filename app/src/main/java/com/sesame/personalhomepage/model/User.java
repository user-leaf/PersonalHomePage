package com.sesame.personalhomepage.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user")
public class User {

    @PrimaryKey()
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "login", typeAffinity = ColumnInfo.TEXT)
    public String login;

    @ColumnInfo(name = "avatar", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("avatar_url")
    public String avatar;

    @ColumnInfo(name = "htmlUrl", typeAffinity = ColumnInfo.TEXT)
    @SerializedName("html_url")
    public String html;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "company", typeAffinity = ColumnInfo.TEXT)
    public String company;

    @ColumnInfo(name = "blog", typeAffinity = ColumnInfo.TEXT)
    public String blog;

    @ColumnInfo(name = "location", typeAffinity = ColumnInfo.TEXT)
    public String location;

    @ColumnInfo(name = "bio", typeAffinity = ColumnInfo.TEXT)
    public String bio;

    @ColumnInfo(name = "followers", typeAffinity = ColumnInfo.INTEGER)
    public int followers;

    @ColumnInfo(name = "following", typeAffinity = ColumnInfo.INTEGER)
    public int following;

    public User(int id, String avatar, String html, String name, String company, String blog, String location, String bio, int followers, int following) {
        this.id = id;
        this.avatar = avatar;
        this.html = html;
        this.name = name;
        this.company = company;
        this.blog = blog;
        this.location = location;
        this.bio = bio;
        this.followers = followers;
        this.following = following;
    }
}
