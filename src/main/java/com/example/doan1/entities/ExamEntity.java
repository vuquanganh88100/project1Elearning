package com.example.doan1.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
@Data
@Entity
@Table(name = "exam", schema = "doan1")
public class ExamEntity {
    @Column(name = "exam_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", referencedColumnName = "quiz_id")
    private QuizEntity quizEntity;
    @Column(name = "question_Number")
    private Integer quesNum;
    @Column(name = "question_Text")
    private String content;
    @Column(name = "answer_Option1")
    private String option1;
    @Column(name = "answer_Option2")
    private String option2;
    @Column(name = "answerOption3")
    private String option3;
    @Column(name = "answer_Option4")
    private String option4;
    @Column(name = "correct_Answer")
    private String correctAns;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public QuizEntity getQuizEntity() {
        return quizEntity;
    }

    public void setQuizEntity(QuizEntity quizEntity) {
        this.quizEntity = quizEntity;
    }

    public Integer getQuesNum() {
        return quesNum;
    }

    public void setQuesNum(Integer quesNum) {
        this.quesNum = quesNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamEntity that)) return false;
        return getExamId().equals(that.getExamId()) && getQuizEntity().equals(that.getQuizEntity()) && getQuesNum().equals(that.getQuesNum()) && getContent().equals(that.getContent()) && getOption1().equals(that.getOption1()) && getOption2().equals(that.getOption2()) && getOption3().equals(that.getOption3()) && getOption4().equals(that.getOption4()) && getCorrectAns().equals(that.getCorrectAns());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamId(), getQuizEntity(), getQuesNum(), getContent(), getOption1(), getOption2(), getOption3(), getOption4(), getCorrectAns());
    }
}
