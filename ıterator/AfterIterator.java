
package ıterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class AfterIterator {
    
    //AFTER ITERATOR PATTERN
    //We can use array and list on the same method (with iterator pattern).
    public static void main(String[] args) {
       
        Book book = new Book("Mat");               
        Fasikul fasikul = new Fasikul("English");        
        
        Iterator questionIteratorBook = book.getQuestionIterator();
        printQuestions(questionIteratorBook);
        
        Iterator questionIteratorFasikul = fasikul.getQuestionsIterator();
        printQuestions(questionIteratorFasikul);
        
    }   

    public static void printQuestions(Iterator questionIteratorBook) {
        while(questionIteratorBook.hasNext()){
            Question question = (Question) questionIteratorBook.next();
            System.out.println("Question No: " + question.getQuestionNo());
        }
    }
}

class Question {
    
    private int questionNo;

    public Question(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }
}

class Book {
    
    private String name;
    private List<Question> questionList;

    public Book(String name) {
        this.name = name;
        this.questionList = new ArrayList<>();
        
        //add 5 question to the book 
        questionList.add(new Question(1));
        questionList.add(new Question(2));
        questionList.add(new Question(3));
        questionList.add(new Question(4));
        questionList.add(new Question(5));        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Iterator getQuestionIterator() {
        return questionList.iterator();
    }    
}

class Fasikul {
    private String name;
    private Question[] questionsArr;

    public Fasikul(String name) {
        this.name = name;
        this.questionsArr = new Question[10];
        
        //add 10 question from 6 to 15
        questionsArr[0] = new Question(6);
        questionsArr[1] = new Question(7);
        questionsArr[2] = new Question(8);
        questionsArr[3] = new Question(9);
        questionsArr[4] = new Question(10);
        questionsArr[5] = new Question(11);
        questionsArr[6] = new Question(12);
        questionsArr[7] = new Question(13);
        questionsArr[8] = new Question(14);
        questionsArr[9] = new Question(15);       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestionIterator getQuestionsIterator() {
        return new QuestionIterator(questionsArr);
    }
}

class QuestionIterator implements Iterator {

    private Question[] questions;
    private int nthElement;

    public QuestionIterator(Question[] questions) {
        this.questions = questions;
    }
    
    @Override
    public boolean hasNext() {
        if(nthElement < questions.length){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object next() {
        Question q = questions[nthElement];
        nthElement++;
        return q;      
    }
    
}