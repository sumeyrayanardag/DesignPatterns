
package ıterator;

import java.util.ArrayList;
import java.util.List;

public class BeforeIterator {

    //BEFORE ITERATOR PATTERN
    //We need to use 2 different methods for different data types. But if we use BeforeIterator, we dont need this.
    public static void main(String[] args) {
       
        Book2 book = new Book2("Mat");       
        List<Question2> questionList = book.getQuestionList();        
        printQuestions(questionList);
        
        Fasikul2 fasikul = new Fasikul2("English");       
        Question2[] questionArr = fasikul.getQuestionsArr();        
        printQuestions(questionArr);
        
    }   

    public static void printQuestions(Question2[] questionArr) {
        for(Question2 question : questionArr){
            System.out.println("Question No: " + question.getQuestionNo());
        }
    }   

    public static void printQuestions(List<Question2> questionList) {
        for(Question2 question : questionList){
            System.out.println("Question No: " + question.getQuestionNo());
        }
    }
}

class Question2 {
    
    private int questionNo;

    public Question2(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }
}

class Book2 {
    
    private String name;
    private List<Question2> questionList;

    public Book2(String name) {
        this.name = name;
        this.questionList = new ArrayList<>();
        
        //add 5 question to the book 
        questionList.add(new Question2(1));
        questionList.add(new Question2(2));
        questionList.add(new Question2(3));
        questionList.add(new Question2(4));
        questionList.add(new Question2(5));        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question2> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question2> questionList) {
        this.questionList = questionList;
    }     
}

class Fasikul2 {
    private String name;
    private Question2[] questionsArr;

    public Fasikul2(String name) {
        this.name = name;
        this.questionsArr = new Question2[10];
        
        //add 10 question from 6 to 15
        questionsArr[0] = new Question2(6);
        questionsArr[1] = new Question2(7);
        questionsArr[2] = new Question2(8);
        questionsArr[3] = new Question2(9);
        questionsArr[4] = new Question2(10);
        questionsArr[5] = new Question2(11);
        questionsArr[6] = new Question2(12);
        questionsArr[7] = new Question2(13);
        questionsArr[8] = new Question2(14);
        questionsArr[9] = new Question2(15);       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question2[] getQuestionsArr() {
        return questionsArr;
    }

    public void setQuestionsArr(Question2[] questionsArr) {
        this.questionsArr = questionsArr;
    } 
}