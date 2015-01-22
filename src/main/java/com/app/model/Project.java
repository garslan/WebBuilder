package com.app.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement
@XmlSeeAlso({Platform.class, Widget.class})
public class Project {
    private String id;
    private String name;
    private String description;
    private Platform platform;

    public Project() {
    }

    public String getId() {
        return id;
    }
    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    public Platform getPlatform() {
        return platform;
    }
    @XmlElement
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", platform=" + platform +
                '}';
    }
}
