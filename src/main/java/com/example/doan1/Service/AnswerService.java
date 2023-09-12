package com.example.doan1.Service;

import com.example.doan1.dto.AnswerDto;
import com.example.doan1.entities.AnswerEntity;
import com.example.doan1.entities.QuizEntity;
import com.example.doan1.entities.UserEntity;
import com.example.doan1.repository.AnswerRepository;
import com.example.doan1.repository.ExamRepository;
import com.example.doan1.repository.QuizRepository;
import com.example.doan1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    ExamRepository examRepository;
    @Autowired
    UserRepository userRepository;
    public String save(AnswerDto answerDto) throws IOException {
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setScore(answerDto.getScore());

        // Debugging: Print userEmail to check if it contains the expected value
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        System.out.println("UserEmail: " + userEmail);

        // Fetch userEntity using userEmail
        UserEntity userEntity = userRepository.findFirstByUserEmail(userEmail);

        // Debugging: Print userEntity to check if it is fetched correctly
        System.out.println("UserEntity: " + userEntity);

        if (userEntity == null) {
            // Handle the case when the user is not found
            return "User not found";
        }

        // Fetch quizEntity using answerDto.getQuizId()
        QuizEntity quizEntity = quizRepository.getById(answerDto.getQuizId());
        answerEntity.setQuizEntity(quizEntity);

        answerEntity.setUser(userEntity);
        answerRepository.save(answerEntity);

        return "Tao moi thanh cong";
    }


    public void checkAnswers(AnswerDto answerDto) {
        List<String> selectedAnswers = answerDto.getSelectedAns();
        List<String> correctAnswers = answerDto.getCorrectAns();

        if (selectedAnswers.size() != correctAnswers.size()) {
            throw new IllegalArgumentException("Selected and correct answers lists must have the same size.");
        }
        List<Boolean> answerResults = new ArrayList<>();

        for (int i = 0; i < selectedAnswers.size(); i++) {
            String selectedAnswer = selectedAnswers.get(i);
            String correctAnswer = correctAnswers.get(i);
            boolean isCorrect = selectedAnswer.equals(correctAnswer);
            answerResults.add(isCorrect);
        }

        // You can return or store the answer results as needed
        answerDto.setAnswerResults(answerResults);
    }
    public double calculateScore( List<Boolean> answerResults, int totalQuestions) {
        int correctCount = 0;

        for (int i = 0; i < totalQuestions; i++) {
            if (answerResults.get(i)==Boolean.TRUE) {
                correctCount++;
            }
        }

        double score = ((double) correctCount / totalQuestions) * 100.0;

        return score;
    }
}
