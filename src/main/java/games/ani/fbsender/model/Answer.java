package games.ani.fbsender.model;


import javax.persistence.*;

import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.*;

@Table
@Entity
public class Answer {

    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "answer_sequence"
    )
    private Long id;

    @ElementCollection
    private List<Test> tests;

    @Column(length = 350, updatable = false)
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    public Answer(){

    }

    public Answer(List<Test> tests, String feedback, User user) {
        this.tests = tests;
        this.feedback = feedback;
        this.author = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return author;
    }

    public void setUser(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return getId().equals(answer.getId()) &&
                getTests().equals(answer.getTests()) &&
                Objects.equals(getFeedback(), answer.getFeedback()) &&
                author.equals(answer.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTests(), getFeedback(), author);
    }
}
