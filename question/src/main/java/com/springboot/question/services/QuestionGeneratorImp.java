package com.springboot.question.services;

import com.springboot.question.dto.QuestionDto;
import com.springboot.question.entity.Question;
import com.springboot.question.functions.QuizDto;
import com.springboot.question.repository.QuestionRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class QuestionGeneratorImp implements QuestionGenerator{

    private ChatClient chatClient;
    private QuestionRepo questionRepo;
    private ModelMapper modelMapper;

    private Logger logger = LoggerFactory.getLogger(QuestionGeneratorImp.class);

    public QuestionGeneratorImp(ChatClient.Builder chatbuilder, QuestionRepo questionRepo, ModelMapper modelMapper) {
        this.chatClient = chatbuilder.build();
        this.questionRepo = questionRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void generateAndSave(QuizDto quizDto){
       List<QuestionDto> questionDtoList =  generateQuestions(quizDto.getTitle(),quizDto.getNoOfQuestions(), quizDto.getDescription());
       List<Question> questions = questionDtoList.stream().map(questionDto -> {
            questionDto.setQuizId(quizDto.getId());
            return modelMapper.map(questionDto,Question.class);
        }).toList();
        questionRepo.saveAll(questions);
        this.logger.info("Question Generated and saved");
        questions.forEach(question -> logger.info(question.getQuestion()));
    }


    @Override
    public List<QuestionDto> generateQuestions(String quizName,int numberOfQuestion,String description) {

        String systemString= """
                As a Coding expert, your role is to generate High quality question for quiz
                """;

        String promtString = """
                Generate {numberOfQuestion} number of question for {quizName}
                Having description: {description}
                """;

        Map<String, Object> values= Map.of(
                "numberOfQuestion",numberOfQuestion,
                "quizName",quizName,
                "description",description
        );

        return this.chatClient.prompt()
                .system(systemString)
                .user(userSpec->userSpec.text(promtString).params(values))
                .call()
                .entity(new ParameterizedTypeReference<List<QuestionDto>>() {
                })
        ;

    }
}
