package com.example.codeTamerBack.rest.v1.model;

import com.example.codeTamerBack.rest.v1.Interfaces.ProjectType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Project {
    @Id
    private String projectId;
    private String name;
    private String description;
    private String link;
    private Integer year;
    private String image;

    private ProjectType type;

    @JsonCreator
    public Project(
      @JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("link") String link,
      @JsonProperty("year") Integer year,
      @JsonProperty("image") String image,
      @JsonProperty("type") ProjectType type
    ) {
        super();
        this.name = name;
        this.description= description;
        this.link = link;
        this.year = year;
        this.image = image;
        this.type = type;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getLink() { return link; }
    public Integer getYear() { return year; }
    public String getImage() { return image; }
    public ProjectType getType() { return type; }
}
