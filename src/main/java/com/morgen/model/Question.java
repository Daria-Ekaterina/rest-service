package com.morgen.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Answer")
    private String answer;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Theme> theme;

    public Question() {
    }

    public Question(String name, String answer, Set<Theme> theme) {
        this.name = name;
        this.answer = answer;
        this.theme = theme;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Set<Theme> getTheme() {
        return theme;
    }

    public void setTheme(Set<Theme> theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.name != other.name) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        return Objects.equals(this.id, other.id);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.answer);
        hash = 79 * hash+Objects.hashCode(this.theme);
        return hash;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", name=" + name
                + "answer=" + answer + '}';
    }
}
