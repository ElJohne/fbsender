package games.ani.fbsender.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.*;

@Table
@Entity
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @Column(updatable = false, nullable = false, length = 30)
    @NotBlank(message = "Username cannot be empty")
    private String Username;

    @Column(updatable = false, nullable = false, length = 18)
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(updatable = false, nullable = false, length = 3)
    @NotBlank(message = "Age cannot be empty")
    private Integer age;

    @Column(updatable = false, nullable = false)
    @Enumerated(EnumType.STRING)
    private Sex sex;


    @Email
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public User(){

    }

    public User(@NotBlank(message = "Username cannot be empty") String username, @NotBlank(message = "Password cannot be empty") String password, @NotBlank(message = "Age cannot be empty") Integer age, Sex sex, @Email @NotBlank(message = "Email cannot be blank") String email) {
        Username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getUsername().equals(user.getUsername()) &&
                getPassword().equals(user.getPassword()) &&
                getAge().equals(user.getAge()) &&
                getSex() == user.getSex() &&
                getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getAge(), getSex(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
