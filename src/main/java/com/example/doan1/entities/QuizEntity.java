package com.example.doan1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@ToString
@Table(name = "quiz",schema = "doan1", catalog = "")
public class QuizEntity {
    @Id
    @Column(name="quiz_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int quizId;
    @Column(name="test_name")
    private String testName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private CategoryEntity category;
    @OneToMany(mappedBy = "quizEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ExamEntity> examEntities = new ArrayList<>();
    @OneToMany(mappedBy = "quizEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AnswerEntity> answerEntities = new ArrayList<>();

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuizEntity that)) return false;
        return getQuizId() == that.getQuizId()  && getTestName().equals(that.getTestName()) && getCategory().equals(that.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuizId(), getTestName(), getCategory());
    }
    @Override
    public String toString() {
        return "QuizEntity{" +
                "quizId=" + quizId +
//                ", testName='" + testName + '\'' +
                // Include other fields as needed
                '}';
    }
}
