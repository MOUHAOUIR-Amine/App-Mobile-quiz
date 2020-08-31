package android.example.com.questionsgame.utils;

public class TriviaQuestion {
    private int id;
    private String question;
    private String opta;
    private String optb;
    private String optc;

    private String answer;

    public TriviaQuestion(String q, String oa, String ob, String oc, String ans) {

        question = q;
        opta = oa;
        optb = ob;
        optc = oc;
        //optd = od;
        answer = ans;
    }

    public TriviaQuestion() {
        id = 0;
        question = "";
        opta = "";
        optb = "";
        optc = "";
        //optd = "";
        answer = "";
    }

    public String getQuestion() {
        return question;
    }

    public String getOptA() {
        return opta;
    }

    public String getOptB() {
        return optb;
    }

    public String getOptC() {
        return optc;
    }



    public String getAnswer() {
        return answer;
    }

    public void setId(int i) {
        id = i;
    }

    public void setQuestion(String q1) {
        question = q1;
    }

    public void setOptA(String o1) {
        opta = o1;
    }

    public void setOptB(String o2) {
        optb = o2;
    }

    public void setOptC(String o3) {
        optc = o3;
    }



    public void setAnswer(String ans) {
        answer = ans;
    }

}
