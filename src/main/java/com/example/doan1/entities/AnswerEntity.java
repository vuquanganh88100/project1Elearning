package com.example.doan1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "score",schema = "doan1",catalog = "")
@Data
@ToString
public class AnswerEntity {
    @Id
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansId;
    @Column(name="score")
    private double score;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private QuizEntity quizEntity;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private  UserEntity user;

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public QuizEntity getQuizEntity() {
        return quizEntity;
    }

    public void setQuizEntity(QuizEntity quizEntity) {
        this.quizEntity = quizEntity;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerEntity that)) return false;
        return getAnsId() == that.getAnsId() && Double.compare(that.getScore(), getScore()) == 0 && getQuizEntity().equals(that.getQuizEntity()) && getUser().equals(that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnsId(), getScore(), getQuizEntity(), getUser());
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "ansId=" + ansId +
                ", score=" + score +
                ",quizId="+quizEntity.getQuizId()+
                ",user="+user.getUserId()+
                // Include other fields as needed
                '}';
    }
}

