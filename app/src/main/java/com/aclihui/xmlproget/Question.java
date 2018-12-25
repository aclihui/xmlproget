package com.aclihui.xmlproget;

public class Question
{
    private  String questionId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;

    public  String getquestionId() {
        return questionId;
    }
    public String gettitle() {
        return title;
    }

    public void setquestionId( String questionId) {
        this.questionId = questionId;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setoptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setoptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setoptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getoptionA() {
        return optionA;
    }

    public String getoptionB() {
        return optionB;
    }

    public String getoptionC() {
        return optionC;
    }

    @Override
    public String toString() {
        return "问题编号：" + questionId +'\n'+
                "题目：" + title + '\n' +
                "选项A:" + optionA + '\n' +
                "选项B:" + optionB + '\n' +
                "选项C:" + optionC + '\n' ;
    }
}
